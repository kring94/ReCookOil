package com.example.recookoil.ui.signin.navigation


sealed class SignupDestination(
    val route: String
){
    object NameIdentificationScreen: SignupDestination("nameIdentification")
    object AddressPhoneScreen: SignupDestination("addressPhone")
    object EmailPassScreen: SignupDestination("emailPass")
}
