package com.soyaeeb.musicpartner.data.repositoryImplementation.media.videorepoimpl

import com.soyaeeb.musicpartner.domain.repository.local.media.VideoRepository
import com.soyaeeb.musicpartner.helper.media.contentresolver.VideoFilesContentResolver
import com.soyaeeb.musicpartner.model.music.video.VideoMusic
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VideoRepoImpl @Inject constructor(
    private val videoFilesContentResolver: VideoFilesContentResolver
): VideoRepository {
    override  fun getVideoFilesListFromExternalStorage(): Flow<List<VideoMusic>> {
       return videoFilesContentResolver.getAllVideoFiles()
    }
}