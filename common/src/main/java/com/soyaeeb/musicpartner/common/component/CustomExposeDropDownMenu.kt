package com.soyaeeb.musicpartner.common.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soyaeeb.assets.R
import com.soyaeeb.musicpartner.common.utility.others.AppConstants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomExposeDropDownMenu(
    modifier: Modifier = Modifier,
    icon: Painter = painterResource(id = R.drawable.ic_language),
    dropDownType: String,
    itemList: List<String> = listOf("Bengali", "English"),
    onItemSelected: (String) -> Unit
) {

    var expanded by remember {  mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(itemList[0]) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 16.dp, end = 16.dp),
    ){
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedItem,
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                readOnly = true,
                onValueChange = {
                    selectedItem = it
                },
                leadingIcon = {
                    Icon(
                        painter = icon,
                        contentDescription = "$dropDownType icon"
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow"
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                itemList.forEach { item ->
                    DropdownMenuItem(
                        text = {
                           Text(text = item)
                        },
                        onClick = {
                            onItemSelected(item)
                            selectedItem = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }

}

/*
@Preview
@Composable
fun PreviewExposeDropDownMenu(){
    CustomExposeDropDownMenu(
        dropDownType = AppConstants.languageDropDown,
        onItemSelected = {}
    )
}*/
