package com.soyaeeb.musicpartner.domain.repository.local.media

import com.soyaeeb.musicpartner.model.music.video.VideoMusic
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
     fun getVideoFilesListFromExternalStorage() : Flow<List<VideoMusic>>
}