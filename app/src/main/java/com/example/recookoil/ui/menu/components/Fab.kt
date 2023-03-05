package com.example.recookoil.ui.menu.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recookoil.R
import kotlinx.coroutines.CoroutineScope

@Composable
fun Fab(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    FloatingActionButton(
        onClick = {
//        scope.launch {
//            TODO()
//        }
    },
        shape = RoundedCornerShape(30.dp,0.dp, 30.dp, 30.dp),
        modifier = Modifier.rotate(-45f)
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Contactar central para recolección",
            modifier = Modifier.rotate(45f)
        )
    }
}