package com.soyaeeb.musicpartner.navigation.bottomnavigation.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.soyaeeb.musicpartner.navigation.bottomnavigation.BottomNavigationScreen
import com.soyaeeb.musicpartner.ui.theme.primaryColor


@Composable
fun CustomBottomBar(
    modifier: Modifier = Modifier,
    containerColor: Color = primaryColor,
    contentColor: Color = MaterialTheme.colorScheme.contentColorFor(Color.Green),
    tonalElevation: Dp = 3.dp,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    navController: NavHostController,
    navigateToAudioMusicScreen: () -> Unit,
    navigateToVideoMusicScreen: () -> Unit,
    navigateToYouTubeScreen: () -> Unit,
    navigateToChatScreen: () -> Unit
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        windowInsets = windowInsets
    ) {
        NavigationBarItem(
           icon = {
               Icon(
                   imageVector = BottomNavigationScreen.AudioFileScreen.icon,
                   contentDescription = BottomNavigationScreen.AudioFileScreen.content_description
               )
           },
            label = {
                Text(
                    text = BottomNavigationScreen.AudioFileScreen.label,
                    color = Color.White,
                )
            },
            alwaysShowLabel = false,
            selected = currentDestination?.hierarchy?.any { it.route == BottomNavigationScreen.AudioFileScreen.route } == true,
            onClick = { navigateToAudioMusicScreen.invoke() },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = primaryColor,
                unselectedIconColor = Color.White,
                indicatorColor = Color.White
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = BottomNavigationScreen.VideoFileScreen.icon,
                    contentDescription = BottomNavigationScreen.VideoFileScreen.content_description
                )
            },
            label = {
                Text(
                    text = BottomNavigationScreen.VideoFileScreen.label,
                    color = Color.White
                )
            },
            alwaysShowLabel = false,
            selected = currentDestination?.hierarchy?.any { it.route == BottomNavigationScreen.VideoFileScreen.route } == true,
            onClick = { navigateToVideoMusicScreen.invoke() },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = primaryColor,
                unselectedIconColor = Color.White,
                indicatorColor = Color.White
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.soyaeeb.assets.R.drawable.ic_youtube),
                    contentDescription = BottomNavigationScreen.YouTubeSearchScreen.content_description
                )
            },
            label = {
                Text(
                    text = BottomNavigationScreen.YouTubeSearchScreen.label,
                    color = Color.White
                )
            },
            alwaysShowLabel = false,
            selected = currentDestination?.hierarchy?.any { it.route == BottomNavigationScreen.YouTubeSearchScreen.route } == true,
            onClick = { navigateToYouTubeScreen.invoke() },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = primaryColor,
                unselectedIconColor = Color.White,
                indicatorColor = Color.White
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = BottomNavigationScreen.ChatScreen.icon,
                    contentDescription = BottomNavigationScreen.ChatScreen.content_description
                )
            },
            label = {
                Text(
                    text = BottomNavigationScreen.ChatScreen.label,
                    color = Color.White
                )
            },
            alwaysShowLabel = false,
            selected = currentDestination?.hierarchy?.any { it.route == BottomNavigationScreen.ChatScreen.route } == true,
            onClick = { navigateToChatScreen.invoke() },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = primaryColor,
                unselectedIconColor = Color.White,
                indicatorColor = Color.White
            )
        )
    }
}