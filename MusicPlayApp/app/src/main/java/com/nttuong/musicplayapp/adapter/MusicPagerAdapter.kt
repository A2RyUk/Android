package com.nttuong.musicplayapp.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nttuong.musicplayapp.fragment.AlbumFragment
import com.nttuong.musicplayapp.fragment.ArtistFragment
import com.nttuong.musicplayapp.fragment.SongFragment

class MusicPagerAdapter(
    activity: AppCompatActivity
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SongFragment()
            1 -> AlbumFragment()
            2 -> ArtistFragment()
            else -> throw  IllegalArgumentException("Unknown fragment for position $position")
        }
    }
}