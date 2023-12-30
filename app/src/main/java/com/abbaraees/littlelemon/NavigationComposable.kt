package com.abbaraees.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navController: NavHostController,
    db: MenuDatabase
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
            val viewModel = viewModel<HomeScreenViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return HomeScreenViewModel(db) as T
                    }
                }
            )
            Home(navController, viewModel)
        }
        composable(Profile.route) {
            Profile(navController)
        }
    }
}