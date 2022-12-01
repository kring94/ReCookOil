package com.example.recookoil.ui.signin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.recookoil.ui.signin.NavigationHostSignup
import com.example.recookoil.ui.signin.SignupViewModel
import com.example.recookoil.ui.theme.ReCookOilTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    val viewModel: SignupViewModel by viewModels()
                    val state = viewModel.state.value
                    NavigationHostSignup(viewModel = viewModel, context = this@SignupActivity)
                }
            }
        }
    }
}

