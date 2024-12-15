package com.example.authapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.authapp.R // Ensure you have a drawable image to show
import com.example.authapp.model.Practice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeDetailsScreen(
    navController: NavController,
    practice: Practice,
    onNavigateBack: () -> Unit
) {
    // A list of detailed descriptions for each asana
    val detailedDescriptions = mapOf(
        "Anantasana" to listOf(
            "Anantasana is a supported side posture where you lie on your back and rest your head on a cushion. It helps open the hips and stretch the side body.",
            "This asana improves balance and stability while strengthening the core and obliques. It is also beneficial for improving posture.",
            "It provides a gentle stretch to the hips and legs while relaxing the upper body, making it a great restorative pose.",
            "Additional benefit of Anantasana is that it can relieve back pain and promote a sense of deep relaxation."
        ),
        "Uttanasana" to listOf(
            "Uttanasana is the standing forward bend pose. It stretches the hamstrings and calves while strengthening the legs.",
            "In this pose, you fold forward from the hips with straight legs, reaching your hands to the floor or your ankles.",
            "It helps improve flexibility, reduce tension, and calm the mind. It's commonly practiced in both standing and seated yoga sequences.",
            "Uttanasana is beneficial for your spine, relieving stress and improving blood circulation.",
            "Additionally, this pose stimulates the abdominal organs and tones the abdominal muscles."
        ),
        "Ardha Uttanasana" to listOf(
            "Ardha Uttanasana is a half forward bend that elongates the spine, strengthens the legs, and opens the chest.",
            "This asana is commonly practiced as a part of the Sun Salutation sequence.",
            "It helps improve digestion and provides a mild stretch for the back and hamstrings.",
            "The pose also stimulates the thyroid gland and improves posture by enhancing spinal alignment."
        ),
        "Urdhva Prasarita Eka Padasana" to listOf(
            "This pose involves balancing on one leg while the other leg is lifted vertically, with the arms extended overhead.",
            "It strengthens the core, legs, and hips, and improves balance and coordination.",
            "This asana also stretches the hamstrings and helps improve flexibility in the lower back.",
            "The pose builds mental focus and stability, offering a great challenge for practitioners at any level."
        ),
        "Salamba Sirsasana" to listOf(
            "Salamba Sirsasana is a headstand pose where the body is supported on the head and forearms, with the legs extended upwards.",
            "It builds strength in the arms, shoulders, and core while improving balance and circulation.",
            "This inversion is often referred to as the 'king of asanas' and helps in improving concentration and mental clarity.",
            "Salamba Sirsasana is believed to aid digestion, relieve stress, and improve the functioning of the nervous system."
        ),
        "Gomukhasana" to listOf(
            "Gomukhasana is a seated pose that stretches the shoulders, arms, and chest, while also opening the hips and thighs.",
            "The pose is named after the shape of a cow's face, with the arms and legs forming the ears and snout.",
            "This asana is particularly helpful for increasing flexibility in the upper back and shoulders.",
            "It helps release tension in the neck and shoulders and is beneficial for improving posture and reducing stress."
        ),
        "Savasana" to listOf(
            "Savasana is a resting pose in which you lie flat on your back with arms and legs extended, allowing the body to fully relax.",
            "It is typically practiced at the end of a yoga session to absorb the benefits of the practice and calm the nervous system.",
            "Savasana promotes deep relaxation, mental clarity, and stress relief.",
            "This pose helps improve circulation and is beneficial for reducing anxiety and restoring energy levels."
        ),
        "Padmasana" to listOf(
            "Padmasana is a seated posture in which the feet are placed on the opposite thighs, with the legs crossed in a specific way.",
            "This asana promotes physical stability, calms the mind, and is often used for meditation.",
            "It opens the hips and stretches the knees and ankles, while strengthening the back and spine.",
            "Padmasana improves posture and is ideal for calming the nervous system and encouraging focus."
        ),
        "Trikona Asana" to listOf(
            "Trikonasana is a standing pose that stretches the legs, hips, and torso while strengthening the muscles in the legs and arms.",
            "It involves extending one leg out to the side, reaching the arm down toward the foot and the other arm upward, creating a triangle shape.",
            "This asana improves flexibility in the spine, stimulates the abdominal organs, and improves digestion.",
            "It also enhances balance, strengthens the legs, and increases stamina."
        ),
        "Sirsa Asana" to listOf(
            "Sirsa Asana is a headstand pose where the body is inverted with the head and forearms on the floor, and the legs extended upwards.",
            "This asana strengthens the arms, shoulders, and core while promoting balance and stability.",
            "Sirsa Asana improves circulation, enhances focus, and encourages mental clarity.",
            "This inversion is believed to help reduce stress and anxiety and has a calming effect on the nervous system."
        )
    )

    // Current description index for step-wise navigation
    var currentStep by remember { mutableStateOf(0) }

    // List of steps for the current asana
    val descriptions = detailedDescriptions[practice.title] ?: emptyList()
    val imgSrc = when(practice.title) {
        "Anantasana" -> R.drawable.anantasana_image
        "Uttanasana" -> R.drawable.uttanasana_image
        "Ardha Uttanasana" -> R.drawable.ardha_uttanasana
        "Urdhva Prasarita Eka Padasana" -> R.drawable.urdhva_prasarita_image
        "Salamba Sirsasana" -> R.drawable.salamba_sirsasana_image
        "Gomukhasana" -> R.drawable.gomukhasana_image
        "Savasana" -> R.drawable.savasana_image
        "Padmasana" -> R.drawable.padmasana_image
        "Trikona Asana" -> R.drawable.trikonasana_image
        "Sirsa Asana" -> R.drawable.sirsa_asana_image

        else -> R.drawable.sample_asana_image
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(practice.title) },
                navigationIcon = {
                    IconButton(onClick = { onNavigateBack() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Asana image (replace with actual image resource)
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imgSrc)
                    .crossfade(true)
                    .build(), // Add your image resource here
                contentDescription = "Image of ${practice.title}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(bottom = 16.dp)
            )

            // Display the description based on the current step
            if (currentStep < descriptions.size) {
                Text(
                    text = descriptions[currentStep],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            // Next Button
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2596BE),  // Correct parameter name for background color
                        contentColor = androidx.compose.ui.graphics.Color.White       // Correct parameter name for text color
                    ),
                    onClick = {
                        if (currentStep < descriptions.size - 1) {
                            currentStep++
                        } else {
                            // Navigate back after 3 descriptions or last step
                            onNavigateBack()
                        }
                    }
                ) {
                    Text("Next")
                }
            }
        }
    }
}
