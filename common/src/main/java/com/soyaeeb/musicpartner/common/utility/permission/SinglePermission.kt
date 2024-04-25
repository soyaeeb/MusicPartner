package com.soyaeeb.musicpartner.common.utility.permission

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.google.accompanist.permissions.*
import com.soyaeeb.musicpartner.common.component.CustomAlertDialog

@ExperimentalPermissionsApi
@Composable
fun RequestSinglePermission(
    context: Context,
    permission : String,
    rationalMessage: String,
    onPermissionGranted : () -> Unit,
) {
    val firstStagePermissionState = rememberPermissionState(permission)
    //val secondStagePermissionState = rememberPermissionState(permission)
    var isPermissionDenied by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = firstStagePermissionState){
       firstStagePermissionState.launchPermissionRequest()
    }
    when (firstStagePermissionState.status) {
        is PermissionStatus.Granted -> { onPermissionGranted.invoke() }
        is PermissionStatus.Denied -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                 if (firstStagePermissionState.status.shouldShowRationale) {
                     CustomAlertDialog(
                         onDismissRequest = { },
                         title = "Important!",
                         titleTextColor = Color.Red,
                         message = rationalMessage,
                         onConfirmButton = {
                             firstStagePermissionState.launchPermissionRequest()
                             when(firstStagePermissionState.status){
                                 is PermissionStatus.Denied -> {
                                     if(firstStagePermissionState.status.shouldShowRationale){
                                         isPermissionDenied = true
                                     }
                                 }
                                 is PermissionStatus.Granted -> {
                                     onPermissionGranted.invoke()
                                 }
                             }
                         },
                         confirmButtonText = "Give Permission",
                         confirmButtonTextColor = Color.Black,
                         confirmButtonTextWeight = FontWeight.Bold,
                         onDismissButton = {}
                     )
                }
                if(isPermissionDenied){
                    HandleLastStagePermission(context = context)
                }
            }
        }
    }
}