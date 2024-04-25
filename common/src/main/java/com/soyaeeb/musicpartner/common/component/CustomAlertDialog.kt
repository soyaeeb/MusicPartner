package com.soyaeeb.musicpartner.common.component

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun CustomAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String = "",
    titleTextSize: Int = 20,
    titleTextColor: Color = Color.Black,
    titleTextStyle: FontStyle = FontStyle.Normal,
    titleTextWeight: FontWeight = FontWeight.Bold,
    message: String = "",
    messageTextColor: Color = Color.Black,
    messageTextStyle: FontStyle = FontStyle.Normal,
    messageTextWeight: FontWeight = FontWeight.Normal,
    messageTextSize: Int = 18,
    onConfirmButton: () -> Unit,
    confirmButtonText: String = "",
    confirmButtonTextSize: Int = 18,
    confirmButtonTextColor: Color = Color.Black,
    confirmButtonTextStyle: FontStyle = FontStyle.Normal,
    confirmButtonTextWeight: FontWeight = FontWeight.Normal,
    onDismissButton: () -> Unit,
    dismissButtonText: String = "",
    dismissButtonTextSize: Int = 18,
    dismissButtonTextColor: Color = Color.Black,
    dismissButtonTextStyle: FontStyle = FontStyle.Normal,
    dismissButtonTextWeight: FontWeight = FontWeight.Normal,
    icon: (@Composable () -> Unit)? = null,
    shape: Shape = AlertDialogDefaults.shape,
    containerColor: Color = AlertDialogDefaults.containerColor,
    iconContentColor: Color = AlertDialogDefaults.iconContentColor,
    titleContentColor: Color = AlertDialogDefaults.titleContentColor,
    textContentColor: Color = AlertDialogDefaults.textContentColor,
    tonalElevation: Dp = AlertDialogDefaults.TonalElevation,
    properties: DialogProperties = DialogProperties()
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = title,
                fontSize = titleTextSize.sp,
                fontWeight = titleTextWeight,
                fontStyle = titleTextStyle,
                color = titleTextColor
            )
        },
        text = {
            Text(
                text = message,
                fontSize = messageTextSize.sp,
                fontWeight = messageTextWeight,
                fontStyle = messageTextStyle,
                color = messageTextColor
            )
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirmButton.invoke()
            }) {
                Text(
                    text = confirmButtonText,
                    fontSize = confirmButtonTextSize.sp,
                    fontWeight = confirmButtonTextWeight,
                    fontStyle = confirmButtonTextStyle,
                    color = confirmButtonTextColor
                )
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismissButton.invoke()
            }) {
                Text(
                    text = dismissButtonText,
                    fontSize = dismissButtonTextSize.sp,
                    fontWeight = dismissButtonTextWeight,
                    fontStyle = dismissButtonTextStyle,
                    color = dismissButtonTextColor
                )
            }
        },
        icon = icon,
        shape = shape,
        containerColor = containerColor,
        iconContentColor = iconContentColor,
        titleContentColor = titleContentColor,
        textContentColor = textContentColor,
        tonalElevation = tonalElevation,
        properties = properties
    )
}