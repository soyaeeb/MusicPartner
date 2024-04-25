package com.soyaeeb.chat.ui

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.soyaeeb.assets.R
import com.soyaeeb.chat.component.ChatMainAppBar
import com.soyaeeb.chat.component.ChatTabs
import com.soyaeeb.chat.ui.calls.CallsMainScreen
import com.soyaeeb.chat.ui.chats.ChatsMainScreen
import com.soyaeeb.chat.ui.groups.GroupsMainScreen
import com.soyaeeb.chat.util.ChatScreenState
import com.soyaeeb.musicpartner.common.component.ExitAlertDialog
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatDefaultScreen(
    onDrawerIconClicked: ()-> Unit
){

    val chatViewModel = hiltViewModel<ChatViewModel>()

    // for search
    val searchWidgetState by chatViewModel.searchWidgetState
    val searchTextState by chatViewModel.searchTextState
    val chatScreenState by chatViewModel.chatScreenState

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
            ChatMainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState ,
                onTextChange = { text ->
                    chatViewModel.updateSearchTextState(text)
                } ,
                onCloseClicked = {
                    chatViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                },
                onSearchClicked = { searchText ->
                    Log.d("asd","Search Test: $searchText")
                },
                onSearchTriggered = {
                    chatViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                },
                onDrawerIconClicked = onDrawerIconClicked
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorResource(id = R.color.custom_background_color)),
        ) {
            ChatTabs()
            when(chatScreenState){
                ChatScreenState.CHATS_MAIN_SCREEN -> ChatsMainScreen()
                ChatScreenState.CALLS_MAIN_SCREEN -> CallsMainScreen()
                ChatScreenState.GROUPS_MAIN_SCREEN -> GroupsMainScreen()
            }
        }
    }
}