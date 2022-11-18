package com.example.recookoil.ui.login.ui.signup

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignupViewModel {
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

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

    fun onEmailPassChanged(email: String, password: String){
        _email.value = email
        _password.value = password
        _emailPassOK.value = isValidEmail(email) && isValidPassword(password)
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


    private fun isValidPassword(password: String): Boolean  = password.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidName(name: String): Boolean = name.length>3

    private fun isValidLastName(lastname: String): Boolean = lastname.length>3

    private fun isValidIdentification(identification: String): Boolean = identification.length>3

    private fun isValidPhoneNumber(number: String): Boolean = number.length>9

    private fun isValidAddress(address: String): Boolean = address.length>10
}