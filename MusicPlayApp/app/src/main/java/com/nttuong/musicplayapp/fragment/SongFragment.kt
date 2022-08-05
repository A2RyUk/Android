package com.nttuong.musicplayapp.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nttuong.musicplayapp.R
import com.nttuong.musicplayapp.adapter.SongAdapter
import com.nttuong.musicplayapp.databinding.FragmentSongBinding
import com.nttuong.musicplayapp.model.Song

class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding
    private val songs = arrayListOf<Song>()
    private lateinit var adapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSong()
        putData()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(layoutInflater)
        adapter = SongAdapter(songs)
        binding.rcSong.adapter = adapter
        binding.rcSong.layoutManager = LinearLayoutManager(view?.context, RecyclerView.VERTICAL, false)
        return binding.root
    }

    private fun putData() {
        val bundle = Bundle()
        bundle.putParcelableArrayList("song", songs)
        parentFragmentManager.setFragmentResult("dataSong", bundle)
        if (bundle == null){
            Log.d(TAG, "putData: null")
        }
    }

    private fun initSong() {
        songs.add(
            Song("Lose Yourself", "Eminem")
        )
        songs.add(
            Song("Hit em up", "2pac")
        )
        songs.add(
            Song("Billie Jean", "Michael Jackson")
        )
        songs.add(
            Song("Still Dre", "Dr Dre")
        )
        songs.add(
            Song("The Next Episode", "Dr Dre")
        )
        songs.add(
            Song("Superman", "Eminem")
        )
        songs.add(
            Song("Without me", "Eminem")
        )
        songs.add(
            Song("I need a Doctor", "Eminem")
        )
        songs.add(
            Song("Dead Wrong", "The Notorious B.I.G")
        )
    }
}