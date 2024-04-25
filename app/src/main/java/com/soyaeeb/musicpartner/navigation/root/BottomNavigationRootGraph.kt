package com.soyaeeb.musicpartner.navigation.root

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.soyaeeb.audiomusic.ui.AudioFileMainScreen
import com.soyaeeb.chat.ui.ChatDefaultScreen
import com.soyaeeb.musicpartner.navigation.bottomnavigation.BottomNavigationScreen
import com.soyaeeb.musicpartner.navigation.root.util.RootGraphConstants
import com.soyaeeb.videomusic.ui.VideoFileMainScreen
import com.soyaeeb.youtube.ui.YouTubeScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.bottomNavigationRootGraph(
    onDrawerIconClicked: () -> Unit,
){
    navigation(
        route = RootGraphConstants.BOTTOM_NAVIGATION_ROOT_ROUTE,
        startDestination = BottomNavigationScreen.AudioFileScreen.route,
    ){
        composable(route = BottomNavigationScreen.AudioFileScreen.route) {
            AudioFileMainScreen(onDrawerIconClicked = onDrawerIconClicked)
        }
        composable(route = BottomNavigationScreen.VideoFileScreen.route) {
            VideoFileMainScreen(onDrawerIconClicked = onDrawerIconClicked)
        }
        composable(route = BottomNavigationScreen.YouTubeSearchScreen.route) {
            YouTubeScreen(onDrawerIconClicked = onDrawerIconClicked)
        }
        composable(route = BottomNavigationScreen.ChatScreen.route) {
            ChatDefaultScreen(onDrawerIconClicked = onDrawerIconClicked)
        }
    }
}