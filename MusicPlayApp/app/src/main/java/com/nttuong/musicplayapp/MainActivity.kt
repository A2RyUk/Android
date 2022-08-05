package com.nttuong.musicplayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.nttuong.musicplayapp.adapter.MusicPagerAdapter
import com.nttuong.musicplayapp.databinding.ActivityMainBinding
import com.nttuong.musicplayapp.fragment.SongFragment
import com.nttuong.musicplayapp.model.Song

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabTitles = arrayOf("Song", "Album", "Artist")
        binding.vpMusic.adapter = MusicPagerAdapter(this)
        TabLayoutMediator(binding.tabMain, binding.vpMusic){
                tab, position -> tab.text = tabTitles[position]
        }.attach()
    }

}