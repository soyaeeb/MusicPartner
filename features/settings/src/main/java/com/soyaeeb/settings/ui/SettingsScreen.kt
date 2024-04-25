package com.soyaeeb.settings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.soyaeeb.assets.R
import com.soyaeeb.musicpartner.common.component.CustomExposeDropDownMenu
import com.soyaeeb.musicpartner.common.utility.others.AppConstants

@Composable
fun SettingsScreen(
    onThemeChosen: (String) -> Unit,
    onLanguageChosen: (String) -> Unit,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(colorResource(id = R.color.custom_background_color))
    ) {
        /** Languages Drop Down */
        val languageList = listOf("Bengali", "English")
        CustomExposeDropDownMenu(
            itemList = languageList,
            icon = painterResource(id = R.drawable.ic_language),
            dropDownType = AppConstants.languageDropDown,
            onItemSelected = {
                onLanguageChosen(it)
            }
        )

        /** Themes Drop Down */
        val themesList = listOf("Default", "Light", "Dark")
        CustomExposeDropDownMenu(
            itemList = themesList,
            icon = painterResource(id = R.drawable.ic_themes),
            dropDownType = AppConstants.themeDropDown,
            onItemSelected = {
                onThemeChosen(it)
            }
        )
    }
}

@Preview
@Composable
fun PreviewSettingsScreen(){
    SettingsScreen(
        onThemeChosen = { /*TODO*/ },
        onLanguageChosen = { /*TODO*/ },
        innerPadding = PaddingValues()
    )
}