package com.example.recookoil

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.recookoil.ui.login.ui.LoginScreen
import com.example.recookoil.ui.login.ui.LoginViewModel
import com.example.recookoil.ui.theme.ReCookOilTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReCookOilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val user = Firebase.auth.currentUser
                    if(user != null) {
                        val navigate = Intent(this@AuthActivity,HomeActivity::class.java)
                        startActivity(navigate)
                    } else {
                        LoginScreen(LoginViewModel(), this@AuthActivity)
                    }

                }
            }
        }
    }
}
