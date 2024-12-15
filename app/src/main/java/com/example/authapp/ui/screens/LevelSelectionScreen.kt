package com.example.authapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.example.authapp.R
import com.example.authapp.viewmodel.UserViewModel

@Composable
fun LevelSelectionScreen(
    userViewModel: UserViewModel,
    onNavigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Add padding around the screen
        verticalArrangement = Arrangement.Top,  // Align children at the top
        horizontalAlignment = Alignment.CenterHorizontally  // Keep buttons centered horizontally
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF2596BE), shape = CircleShape)
                    .clickable {  }
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back)

                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = stringResource(R.string.level_selection),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
        Text(
            text = stringResource(R.string.level_selection1),
            modifier = Modifier.align(Alignment.Start),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium)
        )
        Text(
            text = stringResource(R.string.level_selection2),
            modifier = Modifier.align(Alignment.Start),
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Medium)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Add some padding at the top of the screen
        Spacer(modifier = Modifier.height(32.dp))

        // Create a Row to display buttons in two columns
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LevelButton(
                text = "Beginner",
                icon = Icons.Default.Star,
                onClick = {
                    userViewModel.setUserLevel("beginner") { success ->
                        if (success) onNavigateToHome()
                    }
                }
            )
            LevelButton(
                text = "Intermediate",
                icon = Icons.Default.Star,
                onClick = {
                    userViewModel.setUserLevel("intermediate") { success ->
                        if (success) onNavigateToHome()
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Space between rows

        // Row for another set of two buttons (Advanced)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LevelButton(
                text = "Advanced",
                icon = Icons.Default.Star, // Use StarOutline instead of StarBorder
                onClick = {
                    userViewModel.setUserLevel("advanced") { success ->
                        if (success) onNavigateToHome()
                    }
                }
            )
        }
    }
}

@Composable
private fun LevelButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(120.dp) // Make the box square (120dp x 120dp)
            .border(2.dp, Color(0xFF2596BE), shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)) // Add border and corner radius
            .clickable(onClick = onClick)
            .padding(16.dp), // Padding inside the box
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(32.dp), // Icon size
                tint = Color(0xFF2596BE) // Icon color
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                color = Color(0xFF2596BE)
            )
        }
    }
}
