package com.soyaeeb.musicpartner.common.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.soyaeeb.assets.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
    searchText: String,
    searchIconColor: Color = Color.White,
    closeIconColor: Color = Color.White,
    placeHolderText: String = "Type here..",
    placeHolderTestColor: Color = Color.White,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
){
   Surface(
       modifier = Modifier
           .fillMaxWidth()
           .height(64.dp),
       tonalElevation = 5.dp,
       shadowElevation = 5.dp,
       color = colorResource(id = R.color.primaryColor)
   ) {
       TextField(
           modifier = Modifier.fillMaxWidth(),
           value = searchText,
           onValueChange = {
               onTextChange(it)
           },
           textStyle = TextStyle(
               color = Color.White
           ),
           placeholder = {
               Text(
                   modifier = Modifier
                       .alpha(.5f),
                   text = placeHolderText,
                   color = placeHolderTestColor
               )
           },
           singleLine = true,
           leadingIcon = {
               IconButton(
                   onClick = { onSearchClicked.invoke(searchText)}
               ) {
                   Icon(
                       imageVector = Icons.Default.Search,
                       contentDescription = "Search Icon",
                       tint = searchIconColor
                   )
               }
           },
           trailingIcon = {
               IconButton(
                   modifier = Modifier.alpha(.5f),
                   onClick = {
                       if(searchText.isNotEmpty()){
                           onTextChange("")
                       }else{
                           onCloseClicked.invoke()
                       }
                   }
               ) {
                   Icon(
                       imageVector = Icons.Default.Close,
                       contentDescription = "Close Icon",
                       tint = closeIconColor
                   )
               }
           },
           keyboardOptions = KeyboardOptions(
               imeAction = ImeAction.Search
           ),
           keyboardActions = KeyboardActions(
               onSearch = {
                   onSearchClicked(searchText)
               }
           ),
           colors = TextFieldDefaults.textFieldColors(
               containerColor = Color.Transparent,
               cursorColor = Color.White.copy(alpha = .5f),
               focusedIndicatorColor = Color.Transparent
           )
       )
   }
}