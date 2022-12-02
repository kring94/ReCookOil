package com.example.recookoil.ui.profile

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
import com.example.recookoil.model.*
import com.example.recookoil.ui.home.UserState


@HiltViewModel
class UserViewModel
@Inject
constructor(

): ViewModel(){
    private val _state: MutableState<UserState> = mutableStateOf(UserState())
    val state : State<UserState> = _state

    private var _points = MutableLiveData<String>()
    val points: LiveData<String> = _points

    private var _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private var _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private var _lastName = MutableLiveData<String>()
    val lastName : LiveData<String> = _lastName

    private var _identification = MutableLiveData<String>()
    val identification : LiveData<String> = _identification

    private var _phoneNumber = MutableLiveData<String>()
    val phoneNumber : LiveData<String> = _phoneNumber

    private var _address = MutableLiveData<String>()
    val address : LiveData<String> = _address

    fun setName(name: String){
        _name.value = name
    }
    fun setLastname(lastName: String){
        _lastName.value = lastName
    }
    fun setIdentification(identification: String){
        _identification.value = identification
    }
    fun setPhoneNumber(phone: String){
        _phoneNumber.value = phone
    }
    fun setAddress(address: String){
        _address.value = address
    }
    fun setEmail(email: String){
        _email.value = email
    }

    fun setPoints(points: String) {
        _points.value = points
    }
}