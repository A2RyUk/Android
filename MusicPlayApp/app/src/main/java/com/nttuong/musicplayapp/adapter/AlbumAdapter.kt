package com.nttuong.musicplayapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nttuong.musicplayapp.databinding.ItemAlbumBinding
import com.nttuong.musicplayapp.model.Song

class AlbumAdapter(
    private val songs: List<Song>
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        songs[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = songs.size

    class ViewHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(song: Song){
                binding.tvName.text = song.name
                binding.tvAuthor.text = song.author
            }
    }
}