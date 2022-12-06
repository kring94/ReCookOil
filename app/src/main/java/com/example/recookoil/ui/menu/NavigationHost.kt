package com.example.recookoil.ui.menu


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recookoil.ui.aculevel.AcuLevelScreen
import com.example.recookoil.ui.chat.ui.ChatScreen
import com.example.recookoil.ui.history.HistoryScreen
import com.example.recookoil.ui.profile.UserViewModel
import com.example.recookoil.ui.home.ui.*
import com.example.recookoil.ui.iot.IotScreen
import com.example.recookoil.ui.menu.MenuDestination.*
import com.example.recookoil.ui.menu.ModuleDestination.*
import com.example.recookoil.ui.payments.ui.PaymentScreen
import com.example.recookoil.ui.profile.ui.ProfileScreen


@Composable
fun NavigationHost(navHostController: NavHostController, viewModel: UserViewModel){
    NavHost(navController = navHostController, startDestination = HomeScreen.route ){
        composable(HomeScreen.route){
            HomeScreen(navHostController, viewModel)
        }
        composable(PaymentScreen.route){
            PaymentScreen()
        }
        composable(ProfileScreen.route){
            ProfileScreen(viewModel)
        }
        composable(ChatScreen.route){
            ChatScreen(navHostController)
        }
        composable(HistoryScreen.route){
            HistoryScreen(navHostController)
        }
        composable(IotScreen.route){
            IotScreen(navHostController)
        }
        composable(AcuLevelScreen.route){
            AcuLevelScreen(navHostController)
        }
    }
}

