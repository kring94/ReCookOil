package com.example.recookoil.ui.menu

import com.example.recookoil.R

sealed class MenuDestination(
    val icon: Int,
    val title: String,
    val route: String
){
    object ProfileScreen: MenuDestination(R.drawable.ic_person_bottom_menu, "Profile", "profileScreen")
    object PaymentScreen: MenuDestination(R.drawable.ic_payments_bottom_menu, "Payments", "paymentScreen")
    object HomeScreen: MenuDestination(R.drawable.ic_home_bottom_menu, "Home","homeScreen")
}

sealed class ModuleDestination(
    val icon: Int,
    val title: String,
    val route: String
){
    object ChatScreen: ModuleDestination(R.drawable.ic_message_70, "Chat", "chatScreen")
    object HistoryScreen: ModuleDestination(R.drawable.ic_stats_70, "History", "historyScreen")
    object IotScreen: ModuleDestination(R.drawable.ic_iot_70, "Iot", "iotScreen")
    object AcuLevelScreen: ModuleDestination(R.drawable.ic_level_70, "AcuLevel", "acuLevelScreen")
}
