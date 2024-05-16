package com.tasius.learn.navigation

import android.net.Uri
import com.tasius.learn.component.ImageCard.model.ImageCardData

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Detail : Screen(
        "detail_screen/{${DETAIL_ARGUMENTS.TITLE}}/{${
            DETAIL_ARGUMENTS.DETAIL
        }}"
    ) {
        /**
         * TODO : PARSE DATA ONLY USING OBJECT AND PARSE URI
         */
        fun passData(data: ImageCardData): String {
            val path = Uri.parse(data.path)
            return "detail_screen/${data.title}/${data.contentDescription}"
        }
    }
}