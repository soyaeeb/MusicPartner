package com.soyaeeb.musicpartner.navigation.navigationdrawer

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.soyaeeb.musicpartner.common.component.CustomDivider
import com.soyaeeb.musicpartner.navigation.credential.CredentialConstant
import com.soyaeeb.musicpartner.navigation.navigationdrawer.util.DrawerConstants
import com.soyaeeb.musicpartner.ui.ShowHomeScreen
import com.soyaeeb.musicpartner.ui.theme.primaryColor
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationDrawer(
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    navController: NavHostController,
    navigateToLoginScreen: () -> Unit,
    navigateToProfileScreen: () -> Unit,
    navigateToSettingsScreen: () -> Unit,
    navigateToAboutScreen: () -> Unit,
    logoutFromSystem: () -> Unit,
    navigateToTermsAndConditionsScreen: (Boolean) -> Unit,
    showExitDialog: () -> Unit
){
    val scope = rememberCoroutineScope()
    var selectedItemRoute by remember { mutableStateOf("") }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    ModalNavigationDrawer(
        gesturesEnabled = drawerState.isOpen,
        drawerState = drawerState,
        scrimColor = DrawerDefaults.scrimColor,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = primaryColor,
                drawerContentColor =  Color.White,
            ) {
                DrawerHeader()
                CustomDivider()
                Spacer(modifier = Modifier.height(12.dp))
                DrawerBody.itemsList.forEach { drawerItem ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        icon = drawerItem.icon,
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedIconColor = Color.White,
                            unselectedBadgeColor = Color.White,
                            unselectedContainerColor = primaryColor,
                            unselectedTextColor = Color.White,
                            selectedIconColor = primaryColor,
                            selectedBadgeColor = primaryColor,
                            selectedTextColor = primaryColor,
                            selectedContainerColor = Color.White
                        ),
                        label = { Text(text = drawerItem.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == drawerItem.route } == true,
                        onClick = {
                            selectedItemRoute = drawerItem.route
                            scope.launch {
                                drawerState.close()
                            }
                            when(selectedItemRoute){
                                CredentialConstant.LOGIN_SCREEN_ROUTE ->{
                                    navigateToLoginScreen.invoke()
                                }
                                DrawerConstants.PROFILE_SCREEN_ROUTE -> {
                                    navigateToProfileScreen.invoke()
                                }
                                DrawerConstants.SETTINGS_SCREEN_ROUTE -> navigateToSettingsScreen.invoke()
                                DrawerConstants.ABOUT_SCREEN_ROUTE -> navigateToAboutScreen.invoke()
                                DrawerConstants.TERMS_AND_CONDITIONS_SCREEN_ROUTE -> navigateToTermsAndConditionsScreen.invoke(true)
                                DrawerConstants.EXIT_SCREEN_ROUTE -> showExitDialog.invoke()
                                DrawerConstants.LOGOUT_SCREEN_ROUTE -> logoutFromSystem.invoke()
                            }
                        }
                    )
                }
            }
        },
    ) {
        ShowHomeScreen(
            navController = navController,
            onDrawerIconClicked = {
                scope.launch {
                    drawerState.open()
                }
            }
        )
    }
}