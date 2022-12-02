package com.example.recookoil.ui.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.recookoil.ui.home.menu.MenuDestination

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
                BottomNavigationItem(selected = currentRoute == item.route,
                    onClick = {
                        navHostController.navigate(item.route){
                            popUpTo(navHostController.graph.findStartDestination().id){
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                              },
                    icon = {
                        Icon(painter = painterResource(id = item.icon),
                            contentDescription = item.title)
                    },
                    label = { Text(item.title) },
                    alwaysShowLabel = false
                )
            }
        }

    }
}