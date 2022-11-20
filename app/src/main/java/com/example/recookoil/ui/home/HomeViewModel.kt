package com.example.recookoil.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.recookoil.model.User
import com.example.recookoil.repositories.UserRepository
import com.example.recookoil.ui.home.data.UserDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _state: MutableState<UserDetailState> = mutableStateOf(UserDetailState())
    val state: State<UserDetailState>
        get() = _state

    fun addNewUser(
        id: String,
        name: String,
        lastname: String,
        identification: String,
        phoneNumber: String,
        address: String,
        email: String
    ){
        val user = User(
            id,
            name,
            lastname,
            identification,
            phoneNumber,
            address,
            email
        )
        userRepository.addNewUser(user)
    }

}