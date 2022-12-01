package com.example.recookoil.ui.signin

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recookoil.ui.signin.SignupDestination.*

@Composable
fun NavigationHostSignup(viewModel: SignupViewModel, context: Context){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NameIdentificationScreen.route){
        composable(NameIdentificationScreen.route) {
            NameIdentificationScreen(
                viewModel = viewModel,
                context = context,
                navigateAddressPhone = {
                    navController.navigate(AddressPhoneScreen.route)
                }
            )
        }
        composable(AddressPhoneScreen.route) {
            AddressPhoneScreen(viewModel = viewModel,
                context = context,
                navigateEmailPassScreen = {
                    navController.navigate(EmailPassScreen.route)
                }
            )
        }
        composable(EmailPassScreen.route) {
            EmailPassScreen(viewModel = viewModel,
                context = context
            )
        }
    }
}