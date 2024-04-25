package com.soyaeeb.musicpartner.common.utility.permission

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.shouldShowRationale
import com.soyaeeb.musicpartner.common.component.CustomAlertDialog

@Composable
fun HandleLastStagePermission(
    context : Context,
    deniedMessage : String = "You permanently denied the permission! Please go to your phone setting to enable permission manually"
) {
    CustomAlertDialog(
        onDismissRequest = { },
        title = "Oops! It's Must Needed",
        titleTextColor = Color.Red,
        message = deniedMessage,
        onConfirmButton = {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri: Uri = Uri.fromParts("package", context.packageName, null)
            intent.data = uri
            context.startActivity(intent)
        },
        confirmButtonText = "Go to Settings",
        confirmButtonTextColor = Color.Black,
        confirmButtonTextWeight = FontWeight.Bold,
        onDismissButton = {},
        icon = {
            Icon(
                painter = painterResource(id = com.soyaeeb.assets.R.drawable.ic_sad_imoji),
                contentDescription = "",
            )
        }
    )
}


