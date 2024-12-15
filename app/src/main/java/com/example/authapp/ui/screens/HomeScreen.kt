package com.example.authapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.authapp.ui.components.BenefitCard
import com.example.authapp.ui.components.HomeSection
import com.example.authapp.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = @androidx.compose.runtime.Composable {
            TopAppBar(
                title = {
                    Text(
                        "Welcome to Yoga Journey",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            // Introduction Section
            HomeSection(
                title = "What is Yoga?",
                content = "Yoga is an ancient practice that combines physical postures, breathing techniques, meditation, and philosophical principles. It originated in India thousands of years ago and has evolved into various styles and approaches, each offering unique benefits for body, mind, and spirit."
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Physical Benefits Section
            Text(
                text = "Physical Benefits",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            BenefitCard(
                title = "Flexibility",
                description = "Regular practice of asanas improves flexibility and joint mobility, reducing the risk of injury and enhancing overall movement quality."
            )
            BenefitCard(
                title = "Strength",
                description = "Yoga builds functional strength through bodyweight exercises and sustained poses, promoting balanced muscle development."
            )
            BenefitCard(
                title = "Balance",
                description = "Many yoga poses challenge and improve both physical and mental balance, enhancing stability and coordination."
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Mental Benefits Section
            Text(
                text = "Mental Benefits",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            BenefitCard(
                title = "Stress Reduction",
                description = "Yoga's combination of movement and mindfulness helps reduce stress and anxiety, promoting mental clarity and emotional balance."
            )
            BenefitCard(
                title = "Focus",
                description = "Regular practice enhances concentration and mental focus through mindful movement and breathing exercises."
            )
            BenefitCard(
                title = "Mind-Body Connection",
                description = "Yoga strengthens the connection between mind and body, leading to improved body awareness and emotional regulation."
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Getting Started Section
            HomeSection(
                title = "Getting Started",
                content = "Begin your yoga journey with basic poses and gradually progress to more challenging asanas. Focus on proper alignment and breathing. Listen to your body and move at your own pace. Regular practice, even for short periods, can lead to significant improvements in both physical and mental well-being."
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}