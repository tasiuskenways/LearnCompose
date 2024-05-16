package com.tasius.learn.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.tasius.learn.component.ImageCard.ImageCard
import com.tasius.learn.component.ImageCard.model.ImageCardData

@Composable
fun DetailScreenView(navController: NavHostController, data: ImageCardData) {
    ImageCard(
        path = data.path,
        contentDescription = data.contentDescription,
        title = data.title
    )
}