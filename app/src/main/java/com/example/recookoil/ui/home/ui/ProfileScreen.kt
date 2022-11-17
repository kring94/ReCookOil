package com.example.recookoil.ui.home.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recookoil.AuthActivity
import com.example.recookoil.ui.theme.PrimaryDisable
import com.example.recookoil.ui.theme.Secondary
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(context: Context){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        LogoutButton {
            FirebaseAuth.getInstance().signOut()
            val navigate = Intent(context, AuthActivity::class.java)
            context.startActivity(navigate)
        }

    }
}

@Composable
fun LogoutButton(onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(48.dp), colors = ButtonDefaults.buttonColors(
            backgroundColor = Secondary, disabledBackgroundColor = PrimaryDisable, contentColor = Color.White, disabledContentColor = Color.White
        )
    ) {
        Text(text = "Cerrar Sesión")
    }
}