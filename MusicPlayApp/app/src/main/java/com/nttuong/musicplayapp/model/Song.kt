package com.nttuong.musicplayapp.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Song(
    val name: String?,
    val author: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        name = parcel.readString(),
        author = parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(name)
        p0?.writeString(author)
    }

    companion object CREATOR : Parcelable.Creator<Song> {
        override fun createFromParcel(parcel: Parcel): Song {
            return Song(parcel)
        }

        override fun newArray(size: Int): Array<Song?> {
            return arrayOfNulls(size)
        }
    }
}