package com.soyaeeb.youtube.component

import androidx.compose.runtime.Composable
import com.soyaeeb.musicpartner.common.component.CustomSearchBar
import com.soyaeeb.musicpartner.common.component.DefaultAppBar
import com.soyaeeb.musicpartner.common.utility.model.SearchWidgetState

@Composable
fun YouTubeMainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit,
    onDrawerIconClicked: ()-> Unit
){
    when(searchWidgetState){
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = onSearchTriggered,
                onDrawerIconClicked = { onDrawerIconClicked.invoke() }
            )
        }
        SearchWidgetState.OPENED -> {
            CustomSearchBar(
                searchText = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}