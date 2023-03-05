package com.example.recookoil.ui.iot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.recookoil.R
import com.example.recookoil.ui.menu.components.NavigationTopAppBar

@Composable
fun IotScreen(navHostController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar() {
                    NavigationTopAppBar(navHostController = navHostController, "IOT")
            }
        }
    ){
        Box(modifier = Modifier
            .fillMaxSize()
        ){
            Image(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.iot_conn),
                contentDescription = "Header image"
            )
        }

    }
}