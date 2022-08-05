package com.nttuong.musicplayapp.fragment

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nttuong.musicplayapp.R
import com.nttuong.musicplayapp.adapter.AlbumAdapter
import com.nttuong.musicplayapp.adapter.SongAdapter
import com.nttuong.musicplayapp.databinding.FragmentAlbumBinding
import com.nttuong.musicplayapp.model.Song

class AlbumFragment : Fragment() {
    private lateinit var binding: FragmentAlbumBinding
    private var songs = arrayListOf<Song>()
    private lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parentFragmentManager.setFragmentResultListener("dataSong", this, FragmentResultListener { requestKey, result ->
            songs = result.getParcelableArrayList<Song>("song") as ArrayList<Song>
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(layoutInflater)
        adapter = AlbumAdapter(songs)
        binding.rcAlbum.adapter = adapter
        binding.rcAlbum.layoutManager = GridLayoutManager(view?.context, 2)
        return binding.root
    }
}

