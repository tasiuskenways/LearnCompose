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
import com.tasius.learn.navigation.DetailScreen

@Composable
fun HomeScreenView(navController: NavHostController) {
    /** THIS IS FOR MY OWN ARCHIVE
     * FOR LEARN AND AN EXAMPLE FOR GRID LAYOUT RECYCLERVIEW **/
    val data = mutableListOf<ImageCardData>()
    for (i in 1..21) {
        data.add(
            ImageCardData(
                path = "https://cdn.discordapp.com/attachments/1188816924759560272/1234292887823585321/vts-2024-04-03_21h05_17.png?ex=66474694&is=6645f514&hm=919a5c729d25591d37f17e7d2d03ca3bcd55c9a4dabe49c25b52d10e4b6e3e3a&",
                contentDescription = "test",
                title = "Pacar Nomor $i"
            )
        )
    }
    GridLayoutRecyclerView(data = data, content = {
        val item = it as ImageCardData
        /**
         * TODO : IF THERE IS A LINK ON THE DATA IT WILL CRASH THE APPS
         */
        ImageCard(
            path = item.path,
            contentDescription = item.contentDescription,
            title = item.title,
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    navController.navigate(
                        DetailScreen(
                            item.path,
                            item.contentDescription,
                            item.title
                        )
                    )
                }
        )
    })
}