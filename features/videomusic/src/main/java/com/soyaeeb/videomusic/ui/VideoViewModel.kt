package com.soyaeeb.videomusic.ui

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soyaeeb.musicpartner.domain.usecase.media.video.GetVideoMusicListUseCase
import com.soyaeeb.musicpartner.model.music.video.VideoMusic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import android.util.Size
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

enum class VideoMusicScreenState {
    IDLE,
    LOADING,
    SUCCESS,
}

sealed class VideoUiState {
    data class GetAllVideos(val videoMusicList: List<VideoMusic> = emptyList())
}

sealed class VideoMusicUiEvent {
    object NoDataFoundInfoDialogEvent: VideoMusicUiEvent()
}

sealed class VideoMusicUiAction {}

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val getAllExternalVideosUseCase: GetVideoMusicListUseCase
) : ViewModel() {
    private val _videoState = MutableStateFlow(VideoUiState.GetAllVideos())
    val videoState = _videoState.asStateFlow()

    private val _visibleScreenState = MutableStateFlow(VideoMusicScreenState.IDLE)
    val visibleScreenState = _visibleScreenState.asStateFlow()

    private val _uiEvent = Channel<VideoMusicUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    // for Search
    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }


    init {
        getAllVideos()
    }

    private fun getAllVideos() {
        viewModelScope.launch(Dispatchers.IO) {
            _visibleScreenState.value = VideoMusicScreenState.LOADING
            getAllExternalVideosUseCase.execute(Unit).collect{ videoList ->
                if(videoList.isEmpty()){
                    sendEvent(VideoMusicUiEvent.NoDataFoundInfoDialogEvent)
                    _visibleScreenState.value = VideoMusicScreenState.IDLE
                } else {
                    _videoState.value = VideoUiState.GetAllVideos(videoList)
                    _visibleScreenState.value = VideoMusicScreenState.SUCCESS
                }

            }
        }
    }

    private fun sendEvent( event: VideoMusicUiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun loadAlbumArt(uri: Uri, context: Context): Bitmap? {
        var albumArt : Bitmap? = null
        try {
            albumArt = context.contentResolver.loadThumbnail(uri, Size(100,100),null)
        } catch (e: Exception){
            e.printStackTrace()
        }
        return albumArt
    }
}



