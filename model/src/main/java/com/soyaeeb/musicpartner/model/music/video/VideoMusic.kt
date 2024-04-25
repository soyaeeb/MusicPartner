package com.soyaeeb.musicpartner.model.music.video

import android.net.Uri

data class VideoMusic(
    val id: Long,
    val uri : Uri,
    val displayName : String,
    val artist: String,
    val title: String,
    val duration: Long,
    val size: Int
)