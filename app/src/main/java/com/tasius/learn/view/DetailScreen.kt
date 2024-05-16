package com.tasius.learn.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.tasius.learn.component.ImageCard.ImageCard
import com.tasius.learn.component.ImageCard.model.ImageCardData

@Composable
fun DetailScreen(navController: NavHostController, data: ImageCardData) {
    ImageCard(
        path = if (data.path.equals("A", true)) {
            "https://cdn.discordapp.com/attachments/1188816924759560272/1234292887823585321/vts-2024-04-03_21h05_17.png?ex=6645f514&is=6644a394&hm=8e488bd16a54e53d6dae763f57e4df69d8361d446b5336ec0617df62ac63d8c4&"
        } else "https://cdn.discordapp.com/attachments/1188816924759560272/1234292887823585321/vts-2024-04-03_21h05_17.png?ex=6645f514&is=6644a394&hm=8e488bd16a54e53d6dae763f57e4df69d8361d446b5336ec0617df62ac63d8c4&",
        contentDescription = data.contentDescription,
        title = data.title
    )
}