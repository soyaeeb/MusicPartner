package com.soyaeeb.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginButtonClicked: (String, String) -> Unit,
    onCreateAccountClicked: () -> Unit,
    onContinueWithGoogleClicked: () -> Unit,
    onContinueWithFacebookClicked: () -> Unit,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    var userPhoneNumberOrGmailState by rememberSaveable { mutableStateOf("") }
    var userPasswordState by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(color = colorResource(id = com.soyaeeb.assets.R.color.custom_background_color)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = modifier.height(30.dp))

        OutlinedTextField(
            modifier = modifier.fillMaxWidth(.9f),
            value = userPhoneNumberOrGmailState,
            onValueChange = { updatedValue ->
                userPhoneNumberOrGmailState = updatedValue
            },
            label = {
                Text(
                    text = "Enter phone number or gmail",
                    color = Color.White
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(.9f),
            value = userPasswordState,
            onValueChange = { updatedValue ->
                userPasswordState = updatedValue
            },
            label = {
                Text(
                    text = "Enter password",
                    color = Color.White
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                cursorColor = Color.White,
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Password,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        )
        Spacer(modifier = modifier.height(20.dp))
        Button(
            modifier = modifier
                .fillMaxWidth(.9f)
                .height(45.dp),
            onClick = {
                onLoginButtonClicked(
                    userPhoneNumberOrGmailState,
                    userPasswordState
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = com.soyaeeb.assets.R.color.light_gray),
                contentColorFor(backgroundColor = Color.White)
            )
        ) {
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        Spacer(modifier = modifier.height(13.dp))
        Surface(
            modifier = modifier
                .fillMaxWidth(.9f)
                .height(45.dp),
            color = colorResource(id = com.soyaeeb.assets.R.color.light_gray),
            shape = RoundedCornerShape(25.dp),
        ) {
            Row(modifier  = modifier
                .clickable { onContinueWithGoogleClicked.invoke() }
                .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
               Icon(
                   painter = painterResource(id = com.soyaeeb.assets.R.drawable.ic_google),
                   contentDescription = "google icon",
                   tint = Color.White
               )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Continue with google",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = modifier.height(13.dp))
        Surface(
            modifier = modifier
                .fillMaxWidth(.9f)
                .height(45.dp),
            color = colorResource(id = com.soyaeeb.assets.R.color.light_gray),
            shape = RoundedCornerShape(25.dp),
        ) {
            Row(modifier  = modifier
                .clickable { onContinueWithFacebookClicked.invoke() }
                .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = com.soyaeeb.assets.R.drawable.ic_facebook),
                    contentDescription = "facebook icon",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Continue with Facebook",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier =  modifier.fillMaxWidth(.9f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account?",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = modifier.clickable { onCreateAccountClicked.invoke() },
                text = "Create Account",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
