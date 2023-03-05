package com.example.recookoil.model

data class User(
    val id: String,
    val name: String,
    val lastname: String,
    val identification: String,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val points: Int
){
    constructor(): this("","",",","","","","", 0)
}
