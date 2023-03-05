package com.example.recookoil.ui.home.data

import com.example.recookoil.model.User

data class UserDetailState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
    )
