package com.tasius.learn.component

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@SuppressLint("ModifierParameter")
fun GridLayoutRecyclerView(
    data: List<Any>,
    columns: GridCells = GridCells.Fixed(3),
    content: @Composable (Any) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = columns,
        modifier = modifier,
    ) {
        items(data) { item ->
            content(item)
        }
    }
}