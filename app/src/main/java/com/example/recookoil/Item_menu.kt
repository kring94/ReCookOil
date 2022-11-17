package com.example.recookoil

sealed class Items_menu(
    val icon: Int,
    val title: String,
    val ruta: String
){
    object ProfileScreen: Items_menu(R.drawable.ic_person_bottom_menu, "Profile", "profileScreen")
    object PaymentScreen: Items_menu(R.drawable.ic_payments_bottom_menu, "Payments", "paymentScreen")
    object HomeScreen: Items_menu(R.drawable.ic_home_bottom_menu, "Home","homeScreen")
}
