package com.soyaeeb.musicpartner.domain.usecase.media.video

import com.soyaeeb.musicpartner.domain.repository.local.media.VideoRepository
import com.soyaeeb.musicpartner.domain.base.CollectableUseCase
import com.soyaeeb.musicpartner.model.music.video.VideoMusic
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVideoMusicListUseCase @Inject constructor(
    private val videoRepository: VideoRepository
): CollectableUseCase<Unit, List<VideoMusic>> {
    override fun execute(params: Unit): Flow<List<VideoMusic>> {
        return videoRepository.getVideoFilesListFromExternalStorage()
    }
}