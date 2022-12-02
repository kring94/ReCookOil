package com.example.recookoil.data.network

import com.example.recookoil.ui.signin.model.UserSignIn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserService @Inject constructor(private val firebase: FirebaseClient){
    companion object {
        const val  USER_COLLECTION = "User"
    }

    suspend fun createUserTable(userSignIn: UserSignIn) = kotlin.runCatching {

        val user = hashMapOf(
            "name" to userSignIn.name,
            "lastName" to userSignIn.lastName,
            "address" to userSignIn.address,
            "phoneNumber" to userSignIn.phoneNumber,
            "email" to userSignIn.email,
        )

        firebase.db
            .collection(USER_COLLECTION)
            .add(user).await()
    }.isSuccess
}