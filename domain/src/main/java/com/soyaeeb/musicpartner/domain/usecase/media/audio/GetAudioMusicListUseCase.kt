package com.soyaeeb.musicpartner.domain.usecase.media.audio

import com.soyaeeb.musicpartner.model.music.audio.AudioMusic
import com.soyaeeb.musicpartner.domain.repository.local.media.AudioRepository
import com.soyaeeb.musicpartner.domain.base.CollectableUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAudioMusicListUseCase @Inject constructor(
    private val audioRepository: AudioRepository
): CollectableUseCase<Unit, List<AudioMusic>> {
    override fun execute(params: Unit): Flow<List<AudioMusic>> {
        return audioRepository.getAudioFilesListFromExternalStorage()
    }
}