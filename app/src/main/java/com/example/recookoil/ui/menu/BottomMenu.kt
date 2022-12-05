package com.example.recookoil.ui.menu

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.recookoil.ui.menu.components.Fab
import com.example.recookoil.ui.menu.components.NavigationBottom
import com.example.recookoil.ui.menu.MenuDestination.*
import com.example.recookoil.ui.profile.UserViewModel

@Composable
fun MainScreen(viewModel: UserViewModel){
    val navHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigationItem = listOf(
        HomeScreen,
        ProfileScreen,
        PaymentScreen
    )

    Scaffold(scaffoldState = scaffoldState,
        bottomBar = { NavigationBottom(navHostController,navigationItem) },
        floatingActionButton = { Fab(scope, scaffoldState) },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.End
    ){
        NavigationHost(navHostController = navHostController, viewModel = viewModel)
    }
}


