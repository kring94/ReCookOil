package com.example.recookoil.repositories

import com.example.recookoil.model.User
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject
constructor(
    private val userList: CollectionReference
){
    fun addNewUser(user: User){
        try{
            userList.document(user.id).set(user)
        }   catch (e: java.lang.Exception){
            e.printStackTrace()
        }
    }

    fun getUser(userId: String) : Flow<Result<User>> = flow {
        try {
//            emit(Result.Loading<List<User>>())
//            val user = userList.get().await().map { user ->
//                user.toObject(User::class.java)
//            }
            emit(Result.Loading())

            val user = userList.document(userId).get().await().toObject(User::class.java)

            emit(Result.Success(data = user))

        }catch(e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }
}

