package com.tasius.learn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tasius.learn.component.ImageCard.model.ImageCardData
import com.tasius.learn.view.DetailScreenView
import com.tasius.learn.view.HomeScreenView
import kotlinx.serialization.Serializable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreenView(navController = navController)
        }
        composable<DetailScreen> {
            val args = it.toRoute<DetailScreen>()
            val data = ImageCardData(
                path = args.path,
                contentDescription = args.contentDescription,
                title = args.title
            )
            DetailScreenView(navController = navController, data = data)
        }
    }
}

@Serializable
object HomeScreen

@Serializable
data class DetailScreen(
    var path: String,
    var contentDescription: String,
    var title: String
)
