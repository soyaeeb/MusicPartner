package com.soyaeeb.musicpartner.domain.repository.local.media

import com.soyaeeb.musicpartner.model.music.audio.AudioMusic
import kotlinx.coroutines.flow.Flow

interface AudioRepository {
   fun getAudioFilesListFromExternalStorage() : Flow<List<AudioMusic>>
}