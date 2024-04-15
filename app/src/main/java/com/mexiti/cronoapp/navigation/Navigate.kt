package com.mexiti.cronoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mexiti.cronoapp.ui.views.AddView
import com.mexiti.cronoapp.ui.views.CronometroViewModel
import com.mexiti.cronoapp.ui.views.DataViewModel
import com.mexiti.cronoapp.ui.views.EditView
import com.mexiti.cronoapp.ui.views.HomeView

@Composable
fun NavManager(cronometroVM:CronometroViewModel,dataVM:DataViewModel ) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController,dataVM)
        }
        composable("AddView") {
            AddView(navController,cronometroVM, dataVM)
        }
        composable("EditView/{id}",
            arguments = listOf(
                navArgument("id"){type = NavType.LongType}
            )){
            val id = it.arguments?.getLong("id") ?:0
            EditView(navController = navController,
                cronometroVM =cronometroVM , dataVM = dataVM, id =id )

        }

    }
}