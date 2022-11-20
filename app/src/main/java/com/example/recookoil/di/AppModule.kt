package com.example.recookoil.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFiresAuthInstance() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirestoreInstance() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideUserList(firestore: FirebaseFirestore) = firestore.collection("users")

}