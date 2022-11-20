package com.example.recookoil.repositories

import com.example.recookoil.model.User
import com.google.firebase.firestore.CollectionReference
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
}