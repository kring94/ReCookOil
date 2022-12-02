package com.example.recookoil.ui.home.menu


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.home.ui.*
import com.example.recookoil.ui.payments.ui.PaymentScreen
import com.example.recookoil.ui.profile.ui.ProfileScreen


@Composable
fun NavigationHost(navHostController: NavHostController, viewModel: UserViewModel){
    NavHost(navController = navHostController, startDestination = MenuDestination.HomeScreen.route ){
        composable(MenuDestination.HomeScreen.route){
            HomeScreen(viewModel)
        }
        composable(MenuDestination.PaymentScreen.route){
            PaymentScreen()
        }
        composable(MenuDestination.ProfileScreen.route){
            ProfileScreen(viewModel)
        }
    }
}