package com.example.recookoil.repositories

import com.example.recookoil.constants.FirebaseConstants.MESSAGES_COLLECTION
import com.example.recookoil.constants.FirebaseConstants.SENDER
import com.example.recookoil.model.Message
import com.example.recookoil.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject
constructor(
    private val userList: CollectionReference,
    @Named("chats") val chatList: CollectionReference,
    private val authUser: FirebaseAuth
){

    fun createUser(email: String, password: String):Task<AuthResult> {
        return authUser.createUserWithEmailAndPassword(email, password)
    }

    fun addNewUser(user: User){
        val idMessages = UUID.randomUUID().toString()
        try{
            userList.document(user.id).set(user)
            val initialMessage = Message(SENDER,"Usuario: ${user.name} ${user.lastname}", Date())
            chatList.document(user.id).collection(MESSAGES_COLLECTION).document(idMessages).set(initialMessage)

        }   catch (e: java.lang.Exception){
            e.printStackTrace()
        }
    }

    fun getIdUser(): String{
        return authUser.currentUser?.uid ?: ""
    }

    fun authUser(email: String, password: String): Task<AuthResult>{
        return authUser.signInWithEmailAndPassword(email, password)
    }

    fun getUser(userId: String) : Flow<Result<User>> = flow {
        try {
            emit(Result.Loading<User>())

            //val user = userList.document(userId).get().await().toObject(User::class.java)
            val user = userList.whereGreaterThanOrEqualTo("id", userId)
                .get()
                .await()
                .toObjects(User::class.java)
                .first()

            emit(Result.Success<User>(data = user))

        }catch(e: Exception){
            emit(Result.Error(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }

    //Función para actualizar datos de usuario ne firebase
    fun updateUser(userId: String, user: User){
        try {
            val map = mapOf(
                "phoneNumber" to user.phoneNumber,
                "address" to user.address
            )
            userList.document(userId).update(map)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
    // Eliminación de usuarion en firebase
    fun deleteUser(userId: String){
        try {
            userList.document(userId).delete()
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

}

