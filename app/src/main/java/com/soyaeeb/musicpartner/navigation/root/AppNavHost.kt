package com.soyaeeb.musicpartner.navigation.root

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.soyaeeb.musicpartner.navigation.root.util.RootGraphConstants
import com.soyaeeb.musicpartner.ui.MusicPartnerViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    innerPadding: PaddingValues,
    navController: NavHostController,
    musicPartnerViewModel: MusicPartnerViewModel,
    onDrawerIconClicked: ()-> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    NavHost(
        navController = navController,
        modifier = Modifier.padding(innerPadding),
        route = RootGraphConstants.APP_ROOT_ROUTE,
        startDestination = RootGraphConstants.BOTTOM_NAVIGATION_ROOT_ROUTE
    ){
        bottomNavigationRootGraph (onDrawerIconClicked = onDrawerIconClicked)
        navigationDrawerRootGraph(
            navController = navController,
            musicPartnerViewModel = musicPartnerViewModel,
            backStackEntry = backStackEntry,
            navigateToCredentialGraph = {
                credentialRootGraph(
                    navController = navController,
                    musicPartnerViewModel = musicPartnerViewModel
                )
            }
        )
    }
}
