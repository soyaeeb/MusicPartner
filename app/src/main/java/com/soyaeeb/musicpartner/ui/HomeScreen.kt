package com.soyaeeb.musicpartner.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.soyaeeb.musicpartner.common.utility.model.BottomNavigationVisibilityState
import com.soyaeeb.musicpartner.navigation.bottomnavigation.BottomNavigationScreen
import com.soyaeeb.musicpartner.navigation.bottomnavigation.component.CustomBottomBar
import com.soyaeeb.musicpartner.navigation.root.AppNavHost

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowHomeScreen(
    navController: NavHostController,
    onDrawerIconClicked: ()-> Unit

) {
    val musicPartnerViewModel = hiltViewModel<MusicPartnerViewModel>()
    val bottomNavigationVisibilityState by musicPartnerViewModel.bottomNavigationVisibilityState

    Scaffold(
        bottomBar = {
            when(bottomNavigationVisibilityState){
                BottomNavigationVisibilityState.VISIBLE -> {
                    CustomBottomBar(
                        navController = navController,
                        navigateToAudioMusicScreen = {
                            navController.navigate(BottomNavigationScreen.AudioFileScreen.route){
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it){
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        navigateToVideoMusicScreen = {
                            navController.navigate(BottomNavigationScreen.VideoFileScreen.route){
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it){
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        navigateToYouTubeScreen = {
                            navController.navigate(BottomNavigationScreen.YouTubeSearchScreen.route){
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it){
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        navigateToChatScreen = {
                            navController.navigate(BottomNavigationScreen.ChatScreen.route){
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it){
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
                BottomNavigationVisibilityState.INVISIBLE -> {}
            }
        }
    ) { innerPadding ->
        AppNavHost (
            navController = navController,
            innerPadding = innerPadding,
            musicPartnerViewModel = musicPartnerViewModel,
            onDrawerIconClicked = onDrawerIconClicked,
        )
    }
}