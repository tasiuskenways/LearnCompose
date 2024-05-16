package com.tasius.learn.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.tasius.learn.component.ImageCard.ImageCard

@Composable
fun DetailScreen(navController: NavHostController) {
    ImageCard(
        path = "https://cdn.discordapp.com/attachments/1188816924759560272/1218240444635418675/vts-2024-03-15_23h43_15.png?ex=66459113&is=66443f93&hm=31bdcc5d5f8aaa985fa0fa1106a4e350b23fa1cd07b13f54862c501d8d9674ef&",
        contentDescription = "princess vanta",
        title = "Vanta Arissa"
    )
}