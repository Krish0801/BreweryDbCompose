package com.example.brewerydb.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.brewerydb.ui.brewery.BreweryScreen
import com.example.brewerydb.ui.breweryDetail.BreweryDetailScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val targetScreen =
        rememberSaveable { mutableStateOf(Screen.BreweryScreen) }

    Scaffold(topBar = { MyAppTopBar(targetScreen.value, navController) },
        content = {
            NavHost(
                navController = navController,
                startDestination = Screen.BreweryScreen.route,
            ) {
                composable(Screen.BreweryScreen.route) {
                    targetScreen.value = Screen.BreweryScreen
                    BreweryScreen(navController = navController)
                }
                composable("${Screen.BreweryDetailScreen.route}/{breweryId}") { backStackEntry ->
                    Text(text = "Brewery Detail Screen")
                    Log.d("BreweryDetailScreen", "BreweryDetailScreen composable called")
                    targetScreen.value = Screen.BreweryDetailScreen
                    backStackEntry.arguments?.getString("breweryId")?.toLongOrNull()?.let { it1 ->
                        BreweryDetailScreen(
                            it1
                        )
                    }
                }
            }
        })
}

@Composable
fun MyAppTopBar(targetScreen: Screen, navController: NavController) {
    if (targetScreen != Screen.BreweryScreen) {
        TopAppBar(
            title = { Text(text = targetScreen.header, color = Color.White) },
            navigationIcon = { BackButton(navController = navController) },
            backgroundColor = Color(0xFF22324C)
        )
    } else {
        TopAppBar(
            title = { Text(text = targetScreen.header, color = Color.White) },
            backgroundColor = Color(0xFF22324C)
        )
    }
}

@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.navigateUp() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}