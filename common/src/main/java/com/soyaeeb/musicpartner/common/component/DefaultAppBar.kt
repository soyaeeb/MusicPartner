package com.soyaeeb.musicpartner.common.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.soyaeeb.assets.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    titleText: String = "Music Partner",
    titleTextSize: Int = 18,
    titleTextColor: Color = Color.White,
    titleTextStyle: FontStyle = FontStyle.Normal,
    titleTextWeight: FontWeight = FontWeight.Bold,
    searchIconColor: Color = Color.White,
    onSearchClicked: () -> Unit,
    onDrawerIconClicked: () -> Unit
){
    TopAppBar(
        title = {
            Text(
                text = titleText,
                fontSize = titleTextSize.sp,
                fontStyle = titleTextStyle,
                fontWeight = titleTextWeight,
                color = titleTextColor
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(colorResource(id = R.color.primaryColor)),
        actions = {
           IconButton(onClick = { onSearchClicked.invoke() }) {
               Icon(
                   imageVector = Icons.Default.Search,
                   contentDescription = "Search Icon",
                   tint = searchIconColor
               )
           }
        },
        navigationIcon = {
            IconButton(onClick = { onDrawerIconClicked.invoke() }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Navigation Drawer Icon",
                    tint = searchIconColor
                )
            }
        }
    )
}