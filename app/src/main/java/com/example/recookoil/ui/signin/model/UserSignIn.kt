package com.example.recookoil.ui.signin.model

data class UserSignIn(
    val name: String,
    val lastName: String,
    val address: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String
) {
    fun isNotEmpty() =
        name.isNotEmpty() && lastName.isNotEmpty() && address.isNotEmpty() && phoneNumber.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passwordConfirmation.isNotEmpty()
}
