package com.tasius.learn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tasius.learn.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}

/** THIS IS FOR MY OWN ARCHIVE
 * FOR LATER USE AND FOR LEARN  PURPOSE **/

data class BottomNavItem(
    val title: String,
    val selectedItem: ImageVector,
    val unselectedItem: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BtmNav() {
    val items = listOf(
        BottomNavItem(
            title = "Home",
            selectedItem = Icons.Filled.Home,
            unselectedItem = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = 0
        ),
        BottomNavItem(
            title = "Chat",
            selectedItem = Icons.Filled.Email,
            unselectedItem = Icons.Outlined.Email,
            hasNews = false,
            badgeCount = 40
        ),
        BottomNavItem(
            title = "Settings",
            selectedItem = Icons.Filled.Settings,
            unselectedItem = Icons.Outlined.Settings,
            hasNews = true,
            badgeCount = 0
        )
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index

                            },
                            label = {
                                Text(text = item.title)
                            },
                            icon = {
                                BadgedBox(badge = {
                                    if (item.badgeCount > 0) {
                                        Text(text = item.badgeCount.toString())
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) item.selectedItem else item.unselectedItem,
                                        contentDescription = item.title
                                    )
                                }
                            })
                    }
                }
            }
        ) {

        }
    }
}