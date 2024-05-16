package com.tasius.learn.navigation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.tasius.learn.component.ImageCard.model.ImageCardData
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
            route = Screen.Detail.route + "/{${DETAIL_ARGUMENTS.DATA}}",
            arguments = listOf(
                navArgument(DETAIL_ARGUMENTS.DATA) {
                    type = NavType.StringType
                }
            )
        ) {
            val data = Gson().fromJson(
                it.arguments?.getString(DETAIL_ARGUMENTS.DATA),
                ImageCardData::class.java
            )
            DetailScreen(navController, data)
        }
    }
}