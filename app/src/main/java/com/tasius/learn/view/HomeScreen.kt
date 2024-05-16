package com.tasius.learn.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tasius.learn.component.GridLayoutRecyclerView
import com.tasius.learn.component.ImageCard.ImageCard
import com.tasius.learn.component.ImageCard.model.ImageCardData
import com.tasius.learn.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    /** THIS IS FOR MY OWN ARCHIVE
     * FOR LEARN AND AN EXAMPLE FOR GRID LAYOUT RECYCLERVIEW **/
    val data = mutableListOf<ImageCardData>()
    for (i in 1..21) {
        data.add(
            ImageCardData(
                path = "https://cdn.discordapp.com/attachments/1188816924759560272/1234292887823585321/vts-2024-04-03_21h05_17.png?ex=6645f514&is=6644a394&hm=8e488bd16a54e53d6dae763f57e4df69d8361d446b5336ec0617df62ac63d8c4&",
                contentDescription = "test",
                title = "Pacar #$i"
            )
        )
    }
    GridLayoutRecyclerView(data = data, content = {
        val item = it as ImageCardData
        ImageCard(
            path = item.path,
            contentDescription = item.contentDescription,
            title = item.title,
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    navController.navigate(route = Screen.Detail.passData(item))
                }
        )
    })
}