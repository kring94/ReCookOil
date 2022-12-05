package com.example.recookoil.model

import com.example.recookoil.constants.FirebaseConstants.SENDER
import java.util.Date

data class Message(
    val sender: String,
    val message: String,
    val date: Date
){
    constructor(): this(SENDER,"", Date())
}
