package com.soyaeeb.musicpartner.di.appmodule

import com.soyaeeb.musicpartner.data.repositoryImplementation.media.audiorepoimpl.AudioRepoImpl
import com.soyaeeb.musicpartner.data.repositoryImplementation.media.videorepoimpl.VideoRepoImpl
import com.soyaeeb.musicpartner.domain.repository.local.media.AudioRepository
import com.soyaeeb.musicpartner.domain.repository.local.media.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideAudioRepository(audioRepoImpl: AudioRepoImpl): AudioRepository

    @Binds
    fun provideVideoRepository(videoRepoImpl: VideoRepoImpl): VideoRepository

}