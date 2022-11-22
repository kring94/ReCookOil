package com.example.recookoil.ui.home


import com.example.recookoil.model.*

data class UserState(
    val isLoading: Boolean = false,
    val user: User = User("","","","","","","",0),
    val error: String = ""
)
