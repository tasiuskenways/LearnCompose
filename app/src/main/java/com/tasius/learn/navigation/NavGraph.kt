package com.tasius.learn.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tasius.learn.view.DetailScreen
import com.tasius.learn.view.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENTS.TITLE) {
                    type = NavType.StringType
                },
                navArgument(DETAIL_ARGUMENTS.DETAIL) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("TASIUSLOG", "TITLE: ${it.arguments?.getString(DETAIL_ARGUMENTS.TITLE)}")
            Log.d("TASIUSLOG", "DETAIL: ${it.arguments?.getString(DETAIL_ARGUMENTS.DETAIL)}")
            DetailScreen(navController)
        }
    }
}