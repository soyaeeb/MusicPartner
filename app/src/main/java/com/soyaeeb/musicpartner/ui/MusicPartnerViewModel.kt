package com.soyaeeb.musicpartner.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.soyaeeb.musicpartner.common.utility.model.BottomNavigationVisibilityState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MusicPartnerViewModel @Inject constructor(): ViewModel() {

    private val _bottomNavigationVisibilityState: MutableState<BottomNavigationVisibilityState> =
        mutableStateOf(value = BottomNavigationVisibilityState.VISIBLE)

    val bottomNavigationVisibilityState: State<BottomNavigationVisibilityState> = _bottomNavigationVisibilityState

    fun updateBottomNavigationVisibilityState(state: BottomNavigationVisibilityState){
        _bottomNavigationVisibilityState.value = state
    }
}