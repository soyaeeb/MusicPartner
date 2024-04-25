package com.soyaeeb.audiomusic.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.soyaeeb.assets.R
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
import com.soyaeeb.audiomusic.component.AudioMusicMainAppBar
import com.soyaeeb.musicpartner.common.component.*
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AudioFileMainScreen(
    onDrawerIconClicked: ()->Unit
) {
    val audioViewModel = hiltViewModel<AudioViewModel>()
    val audioList by audioViewModel.audioState.collectAsState()
    val visibleScreen by audioViewModel.visibleScreenState.collectAsState()
    var isInfoDialogOpen by remember { mutableStateOf(false) }

    // for search
    val searchWidgetState by audioViewModel.searchWidgetState
    val searchTextState by audioViewModel.searchTextState

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
           AudioMusicMainAppBar(
               searchWidgetState = searchWidgetState,
               searchTextState = searchTextState ,
               onTextChange = { text ->
                   audioViewModel.updateSearchTextState(text)
               } ,
               onCloseClicked = {
                   audioViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
               },
               onSearchClicked = { searchText ->
                  Log.d("asd","Search Test: $searchText")
               },
               onSearchTriggered = {
                   audioViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
               },
               onDrawerIconClicked = onDrawerIconClicked
           )
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.custom_background_color)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            LaunchedEffect(key1 = true, block = {
                audioViewModel.uiEvent.collect { uiEvent ->
                    when(uiEvent){
                        is AudioMusicUiEvent.NoDataFoundInfoDialogEvent -> {
                            isInfoDialogOpen = true
                        }
                    }
                }
            })
            when(visibleScreen){
                AudioMusicScreenState.IDLE -> {
                    if(!isInfoDialogOpen){
                        DefaultScreen(
                            infoText = "You Have No Audio Music"
                        )
                    }
                }

                AudioMusicScreenState.LOADING -> LoadingScreen()

                AudioMusicScreenState.SUCCESS -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(audioList.audioMusicList,) { audio ->
                            AudioMusicItem(audioMusic = audio)
                            CustomDivider(
                                dividerColor = Color.White
                            )
                        }
                    }
                }
            }

            if(isInfoDialogOpen){
                CustomAlertDialog (
                    onDismissRequest = {},
                    title = "No Audio Found!",
                    message = "Please import Some Musics From External Source",
                    titleTextColor = MaterialTheme.colorScheme.primary,
                    onConfirmButton = { isInfoDialogOpen = false },
                    confirmButtonText = "Okay",
                    confirmButtonTextColor = Color.DarkGray,
                    confirmButtonTextWeight = FontWeight.Bold,
                    onDismissButton = {  },
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



