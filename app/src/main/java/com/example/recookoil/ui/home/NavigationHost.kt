package com.example.recookoil.ui.home

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recookoil.ui.home.ui.*


@Composable
fun NavigationHost(navHostController: NavHostController, context: Context){
    NavHost(navController = navHostController, startDestination = MenuDestination.HomeScreen.ruta ){
        composable(MenuDestination.HomeScreen.ruta){
            HomeScreen(context)
        }
        composable(MenuDestination.PaymentScreen.ruta){
            PaymentScreen(context)
        }
        composable(MenuDestination.ProfileScreen.ruta){
            ProfileScreen(context)
        }
    }
}