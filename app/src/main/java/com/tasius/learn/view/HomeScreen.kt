package com.tasius.learn.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.gson.Gson
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
                path = "A",
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
                    val uri = Gson().toJson(item)
                    navController.navigate(
                        route = Screen.Detail.withArgs(uri)
                    )
                }
        )
    })
}