package com.example.recookoil.ui.payments.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recookoil.R
import com.example.recookoil.ui.theme.PrimaryDark

@Composable
fun PaymentScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Spacer(modifier = Modifier
            .padding(24.dp))
        Text(
            text = "Principales convenios de canje para tus puntos",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp),
            color = PrimaryDark
        )

        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.logos_bancos),
            contentDescription = "Header image"
        )
    }
}

