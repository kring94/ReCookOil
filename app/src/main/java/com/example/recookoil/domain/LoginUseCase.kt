package com.example.recookoil.domain

import com.example.recookoil.data.network.AuthenticationService
import com.example.recookoil.data.response.LoginResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authenticationService: AuthenticationService) {

    suspend operator fun invoke(email: String, password: String): LoginResult =
        authenticationService.login(email, password)
}