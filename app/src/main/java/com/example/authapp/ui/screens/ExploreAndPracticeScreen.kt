package com.example.authapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.ui.navigation.Screen
import com.example.authapp.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreAndPracticeScreen(
    navController: NavController,
    userViewModel: UserViewModel = viewModel()
) {
    // Updated list of practices with asanas and their descriptions
    val practices = listOf(
        Practice(
            id = "anasana1",
            title = "Anantasana",
            description = "Supported side posture"
        ),
        Practice(
            id = "anasana2",
            title = "Uttanasana",
            description = "Standing forward bend"
        ),
        Practice(
            id = "anasana3",
            title = "Ardha Uttanasana",
            description = "Standing half forward bend"
        ),
        Practice(
            id = "anasana4",
            title = "Urdhva Prasarita Eka Padasana",
            description = "Standing split"
        ),
        Practice(
            id = "anasana5",
            title = "Salamba Sirsasana",
            description = "Supported headstand"
        ),
        Practice(
            id = "anasana6",
            title = "Gomukhasana",
            description = "Cow face pose"
        ),
        Practice(
            id = "anasana7",
            title = "Savasana",
            description = "Corpse pose"
        ),
        Practice(
            id = "anasana8",
            title = "Padmasana",
            description = "Lotus posture"
        ),
        Practice(
            id = "anasana9",
            title = "Trikona Asana",
            description = "Triangle pose"
        ),
        Practice(
            id = "anasana10",
            title = "Sirsa Asana",
            description = "Headstand posture"
        )
    )

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

                                // Show success message
                                Log.d("Im here","")
                        navController.navigate(Screen.PracticeDetails.createRoute(practice.id))

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
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2596BE),  // Correct parameter name for background color
                    contentColor = androidx.compose.ui.graphics.Color.White       // Correct parameter name for text color
                ),
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
