package com.example.recookoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.recookoil.ui.home.HomeViewModel
import com.example.recookoil.ui.login.NavigationHostSignup
import com.example.recookoil.ui.login.ui.signup.NameIdentificationScreen
import com.example.recookoil.ui.login.ui.signup.SignupViewModel
import com.example.recookoil.ui.theme.ReCookOilTheme

class SignupActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReCookOilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationHostSignup(viewModel = SignupViewModel(), context = this@SignupActivity)
                }
            }
        }
    }
}

