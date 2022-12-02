package com.example.recookoil.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.recookoil.ui.home.menu.MainScreen
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.theme.ReCookOilTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: UserViewModel by viewModels()

        val user = Firebase.auth.currentUser!!.uid
        val dataUser = FirebaseDatabase.getInstance().reference.child("Users").child(user).get()

        dataUser.addOnCompleteListener { data ->
            viewModel.setName(data.result.child("Name").value.toString())
            viewModel.setLastname( data.result.child("Lastname").value.toString())
            viewModel.setIdentification(data.result.child("Identification").value.toString())
            viewModel.setPhoneNumber(data.result.child("PhoneNumber").value.toString())
            viewModel.setAddress(data.result.child("Address").value.toString())
            viewModel.setEmail(data.result.child("Email").value.toString())
            viewModel.setPoints(data.result.child("Points").value.toString())
        }

        setContent {
            ReCookOilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}


