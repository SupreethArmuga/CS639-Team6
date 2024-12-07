package com.example.authapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.authapp.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, "Explore") },
                    label = { Text("Explore & Practice") },
                    selected = false,
                    onClick = { navController.navigate(Screen.ExploreAndPractice.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AddCircle, "Progress") },
                    label = { Text("Track Progress") },
                    selected = false,
                    onClick = { navController.navigate(Screen.TrackProgress.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { navController.navigate(Screen.Profile.route) }
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Text("Welcome to Home Screen", modifier = Modifier.padding(16.dp))
        }
    }
}