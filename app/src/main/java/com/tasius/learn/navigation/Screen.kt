package com.tasius.learn.navigation

import android.net.Uri
import com.tasius.learn.component.ImageCard.model.ImageCardData

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Detail : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}