package com.soyaeeb.musicpartner.common.component

import androidx.compose.runtime.Composable

@Composable
fun ExitAlertDialog(
    onConfirmButtonClick: () -> Unit,
    onCancelButtonClick: () -> Unit,
    onDismissRequest: () -> Unit
){
    CustomAlertDialog(
        onDismissRequest = onDismissRequest,
        onConfirmButton = onConfirmButtonClick,
        onDismissButton = onCancelButtonClick,
        title = "Are your sure?",
        message = "Press yes to exit app",
        confirmButtonText = "Yes",
        dismissButtonText = "No",
    )
}