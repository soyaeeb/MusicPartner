package com.soyaeeb.musicpartner.navigation.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.soyaeeb.musicpartner.navigation.bottomnavigation.util.BottomNavConstants

sealed class BottomNavigationScreen(
    val route: String,
    val label: String,
    val content_description: String,
    val icon: ImageVector
){
    object AudioFileScreen: BottomNavigationScreen(
        route = BottomNavConstants.AUDIO_FILE_SCREEN_ROUTE,
        label = BottomNavConstants.AUDIO,
        content_description = BottomNavConstants.AUDIO_ICON_CONTENT_DESCRIPTION,
        icon = Icons.Filled.Audiotrack
    )
    object VideoFileScreen: BottomNavigationScreen(
        route = BottomNavConstants.VIDEO_FILE_SCREEN_ROUTE,
        label =  BottomNavConstants.VIDEO,
        content_description = BottomNavConstants.VIDEO_ICON_CONTENT_DESCRIPTION,
        icon = Icons.Filled.VideoLibrary
    )
    object YouTubeSearchScreen: BottomNavigationScreen(
        route = BottomNavConstants.YOUTUBE_SEARCH_SCREEN_ROUTE,
        label =  BottomNavConstants.YOUTUBE,
        content_description = BottomNavConstants.YOU_TUBE_SEARCH_ICON_CONTENT_DESCRIPTION,
        icon = Icons.Filled.VideoLibrary
    )
    object ChatScreen: BottomNavigationScreen(
        route = BottomNavConstants.CHAT_SCREEN_ROUTE,
        label =  BottomNavConstants.CHAT,
        content_description = BottomNavConstants.CHAT_ICON_CONTENT_DESCRIPTION,
        icon = Icons.Filled.Chat
    )
}