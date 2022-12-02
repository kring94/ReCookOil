package com.example.recookoil.ui.payments.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.recookoil.R

@Composable
fun PaymentScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.logo_header),
            contentDescription = "Header image"
        )
    }
}

