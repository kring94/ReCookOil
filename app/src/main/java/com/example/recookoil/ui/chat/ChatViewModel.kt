package com.example.recookoil.ui.chat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recookoil.repositories.Result
import com.example.recookoil.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ChatViewModel
@Inject
constructor(
    private val userRepository: UserRepository
): ViewModel(){
    private val _state: MutableState<ChatListState> = mutableStateOf(ChatListState())
    val state: State<ChatListState> = _state

    private val _message = MutableLiveData<String>()
    val message : LiveData<String> = _message

    init {
        getMessageList()
    }

    private fun retrieveIdUser(): String {
        return userRepository.getIdUser()
    }

    fun getMessageList(){
        userRepository.getMessageList(retrieveIdUser()).onEach {   result ->
            when(result){
                is Result.Error -> {
                    _state.value = ChatListState(error = result.message ?: "Error inesperado")
                }
                is Result.Loading -> {
                    _state.value = ChatListState(isLoading = true)
                }
                is Result.Success -> {
                    _state.value = ChatListState(chats = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

    fun sendMessage(message: String, userId: String = retrieveIdUser() ){
        if(message != "" && message.length > 4){
            userRepository.sendNewMessage(message,userId)
        }
    }

    fun onMessageChanged(message: String){
        _message.value = message
    }


}