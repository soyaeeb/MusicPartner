package com.soyaeeb.videomusic.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.soyaeeb.assets.R
import com.soyaeeb.musicpartner.common.component.*
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState
import com.soyaeeb.videomusic.component.VideoMusicMainAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun VideoFileMainScreen(
    onDrawerIconClicked: ()-> Unit
){

    val videoViewModel = hiltViewModel<VideoViewModel>()
    val videoList by videoViewModel.videoState.collectAsState()
    val visibleScreen by videoViewModel.visibleScreenState.collectAsState()
    var isInfoDialogOpen by remember { mutableStateOf(false) }

    // for search
    val searchWidgetState by videoViewModel.searchWidgetState
    val searchTextState by videoViewModel.searchTextState

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
            VideoMusicMainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState ,
                onTextChange = { text ->
                    videoViewModel.updateSearchTextState(text)
                } ,
                onCloseClicked = {
                    videoViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                },
                onSearchClicked = { searchText ->
                    Log.d("asd","Search Test: $searchText")
                },
                onSearchTriggered = {
                    videoViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                },
                onDrawerIconClicked = onDrawerIconClicked
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.custom_background_color)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            LaunchedEffect(key1 = true, block = {
                videoViewModel.uiEvent.collect { uiEvent ->
                    when(uiEvent){
                        is VideoMusicUiEvent.NoDataFoundInfoDialogEvent -> {
                            isInfoDialogOpen = true
                        }
                    }
                }
            })

            when(visibleScreen){
                VideoMusicScreenState.IDLE -> {
                    if(!isInfoDialogOpen){
                        DefaultScreen(
                            infoText = "You Have No Video Music"
                        )
                    }
                }

                VideoMusicScreenState.LOADING -> LoadingScreen()

                VideoMusicScreenState.SUCCESS -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(videoList.videoMusicList) { video ->
                            VideoMusicItem(videoMusic = video)
                            Divider(color = Color.DarkGray)
                        }
                    }
                }
            }
            if(isInfoDialogOpen){
                CustomAlertDialog(
                    onDismissRequest = {},
                    title = "No Video Found!",
                    message = "Please import Some Musics From External Source",
                    titleTextColor = MaterialTheme.colorScheme.primary,
                    onConfirmButton = { isInfoDialogOpen = false },
                    confirmButtonText = "Okay",
                    confirmButtonTextColor = Color.DarkGray,
                    confirmButtonTextWeight = FontWeight.Bold,
                    onDismissButton = {},
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sad_imoji),
                            contentDescription = "Sad Imoji Icon"
                        )
                    }
                )
            }
        }
    }
}
