package com.example.recookoil.ui.profile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recookoil.repositories.Result
import com.example.recookoil.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import com.example.recookoil.model.*
import com.example.recookoil.ui.home.UserState


@HiltViewModel
class UserViewModel
@Inject
constructor(
    private val userRepository: UserRepository
): ViewModel(){
    private val _state: MutableState<UserState> = mutableStateOf(UserState())
    val state : State<UserState> = _state

    init {
        getUser()
    }


    fun retrieveIdUser(): String {
        return userRepository.getIdUser()
    }

    fun getUser(){
        userRepository.getUser(retrieveIdUser()).onEach { result ->
            when(result){
                is Result.Error -> {
                    _state.value = UserState(error = result.message ?: "Error inesperado")
                }
                is Result.Loading -> {
                    _state.value = UserState(isLoading = true)
                }
                is Result.Success -> {
                    _state.value = UserState(
                        user = result.data ?: User("","","","","","","",0)
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}