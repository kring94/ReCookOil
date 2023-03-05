package com.example.recookoil.ui.menu

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.recookoil.ui.chat.ChatViewModel
import com.example.recookoil.ui.menu.components.Fab
import com.example.recookoil.ui.menu.components.NavigationBottom
import com.example.recookoil.ui.menu.MenuDestination.*
import com.example.recookoil.ui.profile.UserViewModel
import kotlinx.coroutines.coroutineScope

@Composable
fun MainScreen(viewModel: UserViewModel, chatViewModel: ChatViewModel){
    val navHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    val navigationItem = listOf(
        HomeScreen,
        ProfileScreen,
        PaymentScreen
    )

    Scaffold(
        scaffoldState = scaffoldState,
        content = {NavigationHost(navHostController = navHostController, viewModel = viewModel, chatViewModel = chatViewModel)},
        bottomBar = {
            NavigationBottom(navHostController,navigationItem)
            if(navHostController.currentDestination?.route.toString() != "homeScreen"){
            }
        },
        floatingActionButton = { Fab(scope, scaffoldState) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    )

}


