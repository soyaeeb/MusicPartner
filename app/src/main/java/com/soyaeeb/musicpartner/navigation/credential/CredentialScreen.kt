package com.soyaeeb.musicpartner.navigation.credential

sealed class CredentialScreen(val route: String){
    object LoginScreen: CredentialScreen(route = CredentialConstant.LOGIN_SCREEN_ROUTE)
    object CreateAccountScreen: CredentialScreen(route = CredentialConstant.CREATE_ACCOUNT_SCREEN_ROUTE)
}

object CredentialConstant {
    const val CREDENTIAL_ROOT_ROUTE = "CREDENTIAL_ROOT_ROUTE"
    const val LOGIN_SCREEN_ROUTE = "LOGIN_SCREEN_ROUTE"
    const val CREATE_ACCOUNT_SCREEN_ROUTE = "CREATE_ACCOUNT_SCREEN_ROUTE"
}
