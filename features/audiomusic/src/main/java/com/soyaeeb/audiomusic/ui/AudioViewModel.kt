package com.soyaeeb.audiomusic.ui

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState
import com.soyaeeb.musicpartner.domain.usecase.media.audio.GetAudioMusicListUseCase
import com.soyaeeb.musicpartner.model.music.audio.AudioMusic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class AudioMusicScreenState {
    IDLE,
    LOADING,
    SUCCESS,
}

sealed class AudioMusicUiState {
    data class GetAudioMusicListMusic(val audioMusicList: List<AudioMusic> = emptyList()): AudioMusicUiState()
}

sealed class AudioMusicUiEvent {
    object NoDataFoundInfoDialogEvent: AudioMusicUiEvent()
}

sealed class AudioMusicUiAction {}

@HiltViewModel
class AudioViewModel @Inject constructor(
    private val getAudioMusicListUseCase : GetAudioMusicListUseCase
) : ViewModel() {
    private val _audioState = MutableStateFlow(AudioMusicUiState.GetAudioMusicListMusic())
    val audioState = _audioState.asStateFlow()

    private val _visibleScreenState = MutableStateFlow(AudioMusicScreenState.IDLE)
    val visibleScreenState = _visibleScreenState.asStateFlow()

    private val _uiEvent = Channel<AudioMusicUiEvent>()
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
        getAudiMusicList()
    }
    private fun getAudiMusicList() {
       viewModelScope.launch(Dispatchers.IO) {
           _visibleScreenState.value = AudioMusicScreenState.LOADING
          getAudioMusicListUseCase.execute(Unit).collect { audioList ->
              if(audioList.isEmpty()){
                  sendEvent(AudioMusicUiEvent.NoDataFoundInfoDialogEvent)
                  _visibleScreenState.value = AudioMusicScreenState.IDLE
              } else {
                  _audioState.value = AudioMusicUiState.GetAudioMusicListMusic(audioList)
                  _visibleScreenState.value = AudioMusicScreenState.SUCCESS
              }
          }
       }
    }


    private fun sendEvent( event: AudioMusicUiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun loadAlbumArt(uri: Uri, context: Context): Bitmap? {
        var albumArt : Bitmap? = null
        try {
            albumArt = context.contentResolver.loadThumbnail(uri, android.util.Size(100,100),null)
        } catch (e: Exception){
            e.printStackTrace()
        }
        return albumArt
    }
}
