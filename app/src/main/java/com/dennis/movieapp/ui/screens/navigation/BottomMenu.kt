package com.dennis.movieapp.ui.screens.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomMenu(){
   val bottomNavItem = listOf(
       BottomNavItem(name="Home" ,route="home" ,icon=Icons.Rounded.Home),
       BottomNavItem(name="Movies" ,route="movies" ,icon=Icons.Rounded.PlayArrow),
       BottomNavItem(name="Tv-Shows" ,route="tv_shows" ,icon=Icons.Rounded.Star),
       BottomNavItem(name="Settings" ,route="settings" ,icon=Icons.Rounded.Settings)
   )

   var selectedItem by remember {
       mutableStateOf(0)
   }

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Black,
        contentColor = Color.White,
    ) {
        bottomNavItem.forEachIndexed { index, item ->

            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                          selectedItem = index
                          },
                label={
                      Text(text=item.name,
                          fontWeight = FontWeight.SemiBold)
                      },
                icon = {
                Icon(imageVector = item.icon,
                    contentDescription ="${item.name}" )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomMenuPreview(){
    BottomMenu()
}