package com.soyaeeb.createaccount.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.TextFormat
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soyaeeb.assets.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAccountScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onSignUpClicked: (String, String, String, String, Boolean) -> Unit,
    onLoginClicked: () -> Unit,
    onTermsAndConditionsClicked: () -> Unit
){
    var userNameState by rememberSaveable { mutableStateOf("") }
    var userPhoneNumberOrGmailState by rememberSaveable { mutableStateOf("") }
    var userPasswordState by rememberSaveable { mutableStateOf("") }
    var userConfirmPasswordState by rememberSaveable { mutableStateOf("") }
    var isTermsAndConditionsAccepted by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(color = colorResource(id = R.color.custom_background_color)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Create Account",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = modifier.height(30.dp))

        OutlinedTextField(
            modifier = modifier.fillMaxWidth(.9f),
            value = userNameState,
            onValueChange = { updatedValue ->
                userNameState = updatedValue
            },
            label = {
                Text(
                    text = "Choose your user name",
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
                    imageVector = Icons.Default.TextFormat,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(.9f),
            value = userPhoneNumberOrGmailState,
            onValueChange = { updatedValue ->
                userPhoneNumberOrGmailState = updatedValue
            },
            label = {
                Text(
                    text = "Enter your email or phone number",
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
                    text = "Choose your password",
                    color = Color.White
                )
            },
            placeholder = {
                Text(
                    modifier = modifier.alpha(.3f),
                    text = "Required at least 6 digit",
                    color = Color.White,
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
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(.9f),
            value = userConfirmPasswordState,
            onValueChange = { updatedValue ->
                userConfirmPasswordState = updatedValue
            },
            label = {
                Text(
                    text = "Confirm your password",
                    color = Color.White
                )
            },
            placeholder = {
                Text(
                    modifier = modifier.alpha(.3f),
                    text = "Enter same password again",
                    color = Color.White,
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
                onSignUpClicked(
                    userNameState,
                    userPhoneNumberOrGmailState,
                    userPasswordState,
                    userConfirmPasswordState,
                    isTermsAndConditionsAccepted
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor =colorResource(id = R.color.light_gray),
                contentColorFor(backgroundColor = Color.White)
            )
        ) {
            Text(
                text = "Create Account",
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier =  modifier.fillMaxWidth(.9f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have an account?",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = modifier.clickable { onLoginClicked.invoke() },
                text = "Let's login",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = modifier.fillMaxWidth(.9f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isTermsAndConditionsAccepted,
                onCheckedChange = {
                    isTermsAndConditionsAccepted = it
                },
                colors = CheckboxDefaults.colors(
                   checkedColor = colorResource(id = R.color.light_gray),
                   uncheckedColor = Color.White
                )
            )
            Text(
                text = "Terms and Conditions",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = modifier.clickable { onTermsAndConditionsClicked.invoke() }
            )
        }

    }
}