package com.example.recookoil.ui.signin.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recookoil.ui.signin.SignupViewModel
import com.example.recookoil.ui.signin.ui.AddressPhoneScreen
import com.example.recookoil.ui.signin.ui.EmailPassScreen
import com.example.recookoil.ui.signin.ui.NameIdentificationScreen

@Composable
fun NavigationHostSignup(viewModel: SignupViewModel, context: Context){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SignupDestination.NameIdentificationScreen.route){
        composable(SignupDestination.NameIdentificationScreen.route) {
            NameIdentificationScreen(
                viewModel = viewModel,
                context = context,
                navigateAddressPhone = {
                    navController.navigate(SignupDestination.AddressPhoneScreen.route)
                }
            )
        }
        composable(SignupDestination.AddressPhoneScreen.route) {
            AddressPhoneScreen(viewModel = viewModel,
                context = context,
                navigateEmailPassScreen = {
                    navController.navigate(SignupDestination.EmailPassScreen.route)
                }
            )
        }
        composable(SignupDestination.EmailPassScreen.route) {
            EmailPassScreen(viewModel = viewModel,
                context = context
            )
        }
    }
}