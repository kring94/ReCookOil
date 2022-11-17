package com.example.recookoil.ui.home

import android.content.Context
import android.graphics.drawable.Icon
import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorApplier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recookoil.Items_menu
import kotlinx.coroutines.CoroutineScope
import com.example.recookoil.R
import com.example.recookoil.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun PrincipalScreen(context: Context){
    val navHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigationItem = listOf(
        Items_menu.HomeScreen,
        Items_menu.ProfileScreen,
        Items_menu.PaymentScreen
    )

    Scaffold(scaffoldState = scaffoldState,
        bottomBar = { NavigationBottom(navHostController,navigationItem)},
        floatingActionButton = {Fab(scope, scaffoldState)},
        isFloatingActionButtonDocked = true
    ){
        NavigationHost(navHostController = navHostController, context = context)
    }

}

@Composable
fun Fab(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    FloatingActionButton(onClick = {
        scope.launch {
            TODO()
        }
    }
    ) {
        Icon(imageVector = Icons.Default.Email, contentDescription = "Contactar central para recolección")

    }
}

@Composable
fun currentRoute(navHostController: NavHostController):String?{
    val entrada by navHostController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavigationBottom(navHostController: NavHostController, navigationItem: List<Items_menu>) {
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        )
    ) {
        BottomNavigation(
            modifier = Modifier.padding(
                0.dp, 0.dp, 80.dp, 0.dp
            )
        ) {
            navigationItem.forEach { item ->
                val currentRoute = currentRoute(navHostController = navHostController)
                BottomNavigationItem(selected = currentRoute == item.ruta,
                    onClick = { navHostController.navigate(item.ruta) },
                    icon = {
                        Icon(painter = painterResource(id = item.icon),
                            contentDescription = item.title)
                    },
                    label = { Text(item.title) },
                    alwaysShowLabel = false)
            }
        }

    }
}