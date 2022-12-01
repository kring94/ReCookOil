package com.example.recookoil.ui.menu

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.home.ui.*
import com.example.recookoil.ui.payments.PaymentScreen
import com.example.recookoil.ui.profile.ProfileScreen


@Composable
fun NavigationHost(navHostController: NavHostController, context: Context, viewModel: UserViewModel){
    NavHost(navController = navHostController, startDestination = MenuDestination.HomeScreen.ruta ){
        composable(MenuDestination.HomeScreen.ruta){
            HomeScreen(context, viewModel)
        }
        composable(MenuDestination.PaymentScreen.ruta){
            PaymentScreen(context)
        }
        composable(MenuDestination.ProfileScreen.ruta){
            ProfileScreen(context, viewModel)
        }
    }
}