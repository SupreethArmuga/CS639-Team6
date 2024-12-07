package com.example.authapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.authapp.viewmodel.UserViewModel

@Composable
fun LevelSelectionScreen(
    userViewModel: UserViewModel,
    onNavigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LevelButton(
            text = "Beginner",
//            icon = Icons.Default.Star,
            onClick = {
                userViewModel.setUserLevel("beginner") { success ->
                    if (success) onNavigateToHome()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LevelButton(
            text = "Intermediate",
//            icon = Icons.Default.StarHalf,
            onClick = {
                userViewModel.setUserLevel("intermediate") { success ->
                    if (success) onNavigateToHome()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LevelButton(
            text = "Advanced",
//            icon = Icons.Default.StarBorder,
            onClick = {
                userViewModel.setUserLevel("advanced") { success ->
                    if (success) onNavigateToHome()
                }
            }
        )
    }
}

@Composable
private fun LevelButton(
    text: String,
//    icon: ImageVector,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
//        Icon(
//            imageVector = icon,
//            contentDescription = null,
//            modifier = Modifier.size(24.dp)
//        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}