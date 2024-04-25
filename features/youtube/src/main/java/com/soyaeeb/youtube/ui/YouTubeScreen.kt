package com.soyaeeb.youtube.ui

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.soyaeeb.assets.R
import com.soyaeeb.musicpartner.common.component.ExitAlertDialog
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState
import com.soyaeeb.youtube.component.YouTubeMainAppBar

@Composable
fun YouTubeScreen(
    onDrawerIconClicked : () -> Unit
){
    val youTubeViewModel = hiltViewModel<YoutubeViewModel>()
    // for search
    val searchWidgetState by youTubeViewModel.searchWidgetState
    val searchTextState by youTubeViewModel.searchTextState

    val activity = (LocalContext.current as? Activity)
    var isExitDialogOpen by remember { mutableStateOf(false) }

    BackHandler {
        isExitDialogOpen = true
    }

    if(isExitDialogOpen){
        ExitAlertDialog(
            onConfirmButtonClick = {
                activity?.finish()
                isExitDialogOpen = false
            },
            onCancelButtonClick = { isExitDialogOpen = false },
            onDismissRequest = { isExitDialogOpen = false }
        )
    }

    Scaffold(
        topBar = {
            YouTubeMainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState ,
                onTextChange = { text ->
                    youTubeViewModel.updateSearchTextState(text)
                } ,
                onCloseClicked = {
                    youTubeViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                },
                onSearchClicked = { searchText ->
                    Log.d("asd","Search Test: $searchText")
                },
                onSearchTriggered = {
                    youTubeViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                },
                onDrawerIconClicked = onDrawerIconClicked
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorResource(id = R.color.custom_background_color))
        ){
            
        }
    }
}