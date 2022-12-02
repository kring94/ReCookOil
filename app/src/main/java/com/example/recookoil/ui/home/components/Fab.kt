package com.example.recookoil.ui.home.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope

@Composable
fun Fab(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    FloatingActionButton(onClick = {
//        scope.launch {
//            TODO()
//        }
    }
    ) {
        Icon(imageVector = Icons.Default.Email, contentDescription = "Contactar central para recolección")
    }
}