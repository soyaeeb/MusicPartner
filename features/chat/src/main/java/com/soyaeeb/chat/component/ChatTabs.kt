package com.soyaeeb.chat.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.soyaeeb.assets.R
import com.soyaeeb.chat.ui.ChatViewModel
import com.soyaeeb.chat.util.ChatScreenState

@Composable
fun ChatTabs(
    modifier: Modifier= Modifier,
    containerColor: Color = colorResource(id = R.color.custom_background_color),
    contentColor: Color = colorResource(id = R.color.custom_background_color),
){
    var selectedTabIndex by remember { mutableStateOf(0) }
    val chatVieModel = hiltViewModel<ChatViewModel>()
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        tabs = {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = {
                    selectedTabIndex = 0
                    chatVieModel.updateChatScreenState(ChatScreenState.CHATS_MAIN_SCREEN)
                },
                modifier = modifier,
                enabled = true,
                text = {
                    Text(
                        text = "Chats"
                    )
                },
                icon = {
                    Icon(
                        painter =  painterResource(id = R.drawable.ic_chats),
                        contentDescription = "Chats Icon",
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                interactionSource = remember { MutableInteractionSource() }
            )
            Tab(
                selected = selectedTabIndex == 1,
                onClick = {
                    selectedTabIndex = 1
                    chatVieModel.updateChatScreenState(ChatScreenState.CALLS_MAIN_SCREEN)
                },
                modifier = modifier,
                enabled = true,
                text = {
                    Text(
                        text = "Calls"
                    )
                },
                icon = {
                    Icon(
                        painter =  painterResource(id = R.drawable.ic_calls),
                        contentDescription = "Calls Icon",
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                interactionSource = remember { MutableInteractionSource() }
            )
            Tab(
                selected = selectedTabIndex == 2,
                onClick = {
                    selectedTabIndex = 2
                    chatVieModel.updateChatScreenState(ChatScreenState.GROUPS_MAIN_SCREEN)
                },
                modifier = modifier,
                enabled = true,
                text = {
                    Text(
                        text = "Groups"
                    )
                },
                icon = {
                    Icon(
                        painter =  painterResource(id = R.drawable.ic_groups),
                        contentDescription = "Groups Icon",
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                interactionSource = remember { MutableInteractionSource() }
            )
        }
    )
}