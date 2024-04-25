package com.soyaeeb.musicpartner.data.repositoryImplementation.media.audiorepoimpl

import android.os.Build
import androidx.annotation.RequiresApi
import com.soyaeeb.musicpartner.domain.repository.local.media.AudioRepository
import com.soyaeeb.musicpartner.helper.media.contentresolver.AudioFilesContentResolver
import com.soyaeeb.musicpartner.model.music.audio.AudioMusic
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AudioRepoImpl @Inject constructor(
    private val audioContentResolver : AudioFilesContentResolver
): AudioRepository {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun getAudioFilesListFromExternalStorage(): Flow<List<AudioMusic>> {
        return audioContentResolver.getAllAudioFiles()
    }
}