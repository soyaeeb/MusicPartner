package com.soyaeeb.musicpartner.model.music.audio

import android.net.Uri

data class AudioMusic(
    val id: Long,
    val uri: Uri,
    val displayName: String,
    val title: String,
    val artist: String,
    val albumArtist: String?,
    val data: String,
    val duration: Long
)
