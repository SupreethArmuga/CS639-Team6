package com.example.authapp.data

import com.example.authapp.model.Practice

object PracticeData {
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

    val detailedDescriptions = mapOf(
        "Anantasana" to listOf(
            "Anantasana is a supported side posture where you lie on your back and rest your head on a cushion. It helps open the hips and stretch the side body.",
            "This asana improves balance and stability while strengthening the core and obliques. It is also beneficial for improving posture.",
            "It provides a gentle stretch to the hips and legs while relaxing the upper body, making it a great restorative pose.",
            "Additional benefit of Anantasana is that it can relieve back pain and promote a sense of deep relaxation."
        ),
        // ... (keep all other descriptions)
    )
}