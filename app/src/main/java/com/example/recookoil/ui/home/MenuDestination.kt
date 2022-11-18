package com.example.recookoil.ui.home

import com.example.recookoil.R

sealed class MenuDestination(
    val icon: Int,
    val title: String,
    val ruta: String
){
    object ProfileScreen: MenuDestination(R.drawable.ic_person_bottom_menu, "Profile", "profileScreen")
    object PaymentScreen: MenuDestination(R.drawable.ic_payments_bottom_menu, "Payments", "paymentScreen")
    object HomeScreen: MenuDestination(R.drawable.ic_home_bottom_menu, "Home","homeScreen")
}
