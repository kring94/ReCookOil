package com.example.recookoil.ui.menu

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recookoil.ui.profile.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PrincipalScreen(context: Context, viewModel: UserViewModel){
    val navHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigationItem = listOf(
        MenuDestination.HomeScreen,
        MenuDestination.ProfileScreen,
        MenuDestination.PaymentScreen
    )

    Scaffold(scaffoldState = scaffoldState,
        bottomBar = { NavigationBottom(navHostController,navigationItem)},
        floatingActionButton = {Fab(scope, scaffoldState)},
        isFloatingActionButtonDocked = true
    ){
        NavigationHost(navHostController = navHostController, context = context, viewModel = viewModel)
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
fun NavigationBottom(navHostController: NavHostController, navigationItem: List<MenuDestination>) {
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