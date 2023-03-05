package com.example.recookoil.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.recookoil.ui.chat.ChatViewModel
import com.example.recookoil.ui.menu.MainScreen
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.theme.ReCookOilTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: UserViewModel by viewModels()
        val chatViewModel: ChatViewModel by viewModels()

        setContent {
            ReCookOilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(viewModel, chatViewModel)
                }
            }
        }
    }
}


