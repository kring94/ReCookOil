package com.example.recookoil.ui.signin

import com.example.recookoil.model.User

data class SigninViewState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)