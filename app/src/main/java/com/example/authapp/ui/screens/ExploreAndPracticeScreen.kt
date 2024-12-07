package com.example.authapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreAndPracticeScreen(
    navController: NavController,
    userViewModel: UserViewModel = viewModel()
) {
    val practices = (1..10).map { 
        Practice(
            id = "practice$it",
            title = "Practice $it",
            description = "Description for Practice $it"
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Explore & Practice") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(practices) { practice ->
                PracticeCard(
                    practice = practice,
                    onComplete = { practiceId ->
                        userViewModel.completePractice(practiceId) { success ->
                            if (success) {
                                // Show success message
                            }
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PracticeCard(
    practice: Practice,
    onComplete: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = practice.title,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = practice.description)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { onComplete(practice.id) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Complete")
            }
        }
    }
}

data class Practice(
    val id: String,
    val title: String,
    val description: String
)