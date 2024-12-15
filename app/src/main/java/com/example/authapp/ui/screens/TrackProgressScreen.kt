package com.example.authapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackProgressScreen(
    navController: NavController,
    userViewModel: UserViewModel = viewModel()
) {
    // List of asanas (practice names)
    val practices = listOf(
        "Anantasana", "Uttanasana", "Ardha Uttanasana", "Urdhva Prasarita Eka Padasana",
        "Salamba Sirsasana", "Gomukhasana", "Savasana", "Padmasana", "Trikonasana", "Sirsa Asana"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Track Progress") },
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
                ProgressItem(
                    title = practice,
                    progress = (10..100).random() / 100f // Random progress for demonstration
                )
            }
        }
    }
}

@Composable
private fun ProgressItem(
    title: String,
    progress: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = title)
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
