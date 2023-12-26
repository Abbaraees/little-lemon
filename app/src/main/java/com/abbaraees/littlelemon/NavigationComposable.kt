package com.abbaraees.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun Navigation(
    navController: NavHostController
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("littlelemon.prefs", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("firstName", "")
    val startDestination = if (firstName == "") "Onboarding" else "Home"

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            Onboarding(navController)
        }
        composable(Home.route) {
            Home(navController)
        }
        composable(Profile.route) {
            Profile(navController)
        }
    }
}