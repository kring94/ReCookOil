package com.example.recookoil.ui.signin

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recookoil.domain.CreateAccountUseCase
import com.example.recookoil.model.User
import com.example.recookoil.repositories.UserRepository
import com.example.recookoil.ui.home.data.UserDetailState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel
@Inject
constructor(
    private val userRepository: UserRepository,
    val createAccountUseCase: CreateAccountUseCase
    ) : ViewModel() {

    private val _state: MutableState<UserDetailState> = mutableStateOf(UserDetailState())
    val state: State<UserDetailState>
        get() = _state

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _passwordConfirmation = MutableLiveData<String>()
    val passwordConfirmation : LiveData<String> = _passwordConfirmation

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _lastName = MutableLiveData<String>()
    val lastName : LiveData<String> = _lastName

    private val _identification = MutableLiveData<String>()
    val identification : LiveData<String> = _identification

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber : LiveData<String> = _phoneNumber

    private val _address = MutableLiveData<String>()
    val address : LiveData<String> = _address


    private val _emailPassOK = MutableLiveData<Boolean>()
    val emailPassOK : LiveData<Boolean> = _emailPassOK

    private val _nameIdentificationOK = MutableLiveData<Boolean>()
    val nameIdentificationOK : LiveData<Boolean> = _nameIdentificationOK

    private val _addressPhoneOK = MutableLiveData<Boolean>()
    val addressPhoneOK : LiveData<Boolean> = _addressPhoneOK

    fun onEmailPassChanged(email: String, password: String, passwordConfirmation: String){
        _email.value = email
        _password.value = password
        _passwordConfirmation.value = passwordConfirmation
        _emailPassOK.value = isValidEmail(email) && isValidPasswordConfirmation(password, passwordConfirmation)
    }

    fun onNameIdentificationChanged(name: String, lastName: String, identification: String){
        _name.value = name
        _lastName.value = lastName
        _identification.value = identification
        _nameIdentificationOK.value = isValidName(name) && isValidLastName(lastName) && isValidIdentification(identification)
    }

    fun onAddressPhoneChanged(numberPhone: String, address: String){
        _address.value = address
        _phoneNumber.value = numberPhone
        _addressPhoneOK.value = isValidPhoneNumber(numberPhone) && isValidAddress(address)
    }

    private fun isValidPasswordConfirmation(password: String, passwordConfirmation: String): Boolean{
        return (password == passwordConfirmation) && isValidPassword(password) && isValidPasswordConfirmation(passwordConfirmation)
    }

    private fun isValidPassword(password: String): Boolean  = password.length > 6

    private fun isValidPasswordConfirmation(passwordConfirmation: String): Boolean  = passwordConfirmation.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidName(name: String): Boolean = name.length>3

    private fun isValidLastName(lastname: String): Boolean = lastname.length>3

    private fun isValidIdentification(identification: String): Boolean = identification.length>3

    private fun isValidPhoneNumber(number: String): Boolean = number.length>9

    private fun isValidAddress(address: String): Boolean = address.length>10

    fun onSignin(email: String, password: String): Task<AuthResult> {
        return userRepository.createUser(email, password)
    }

    fun retrieveIdUser(): String {
        return userRepository.getIdUser()
    }

    fun addNewUser(
        id: String,
        name: String,
        lastName: String,
        identification: String,
        address: String,
        phoneNumber: String,
        email: String,
        points: Int
    ){
        val user = User(
            id,
            name,
            lastName,
            identification,
            phoneNumber,
            address,
            email,
            points
        )
        userRepository.addNewUser(user)
    }
}