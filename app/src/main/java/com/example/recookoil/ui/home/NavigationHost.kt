package com.example.recookoil.ui.home

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.recookoil.Items_menu.*
import com.example.recookoil.ui.home.ui.*

@Composable
fun NavigationHost(navHostController: NavHostController, context: Context){
    NavHost(navController = navHostController, startDestination = HomeScreen.ruta ){
        composable(HomeScreen.ruta){
            HomeScreen(context)
        }
        composable(PaymentScreen.ruta){
            PaymentScreen(context)
        }
        composable(ProfileScreen.ruta){
            ProfileScreen(context)
        }
    }
}