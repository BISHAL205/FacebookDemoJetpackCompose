package com.example.jetpackcomposetest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposetest.ui.screens.HomeScreen
import com.example.jetpackcomposetest.ui.screens.LoginScreen
import com.example.jetpackcomposetest.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Splash.route
    ) {
        composable(Routes.Splash.route)  {
            SplashScreen(navHostController)
        }
        composable(Routes.Login.route)   {
            LoginScreen(navHostController)
        }
        composable(Routes.Home.route)    {
            HomeScreen(navHostController)
        }
    }
}