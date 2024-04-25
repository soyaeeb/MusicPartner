package com.soyaeeb.chat.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.soyaeeb.chat.util.ChatScreenState
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(

): ViewModel() {
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

    // Main Screen State Handler

    private val _chatScreenState: MutableState<ChatScreenState> =
        mutableStateOf(value = ChatScreenState.CHATS_MAIN_SCREEN)
    val chatScreenState: State<ChatScreenState> = _chatScreenState

    fun updateChatScreenState(state: ChatScreenState){
        _chatScreenState.value = state
    }
}