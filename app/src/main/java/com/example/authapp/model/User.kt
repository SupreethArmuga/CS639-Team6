package com.example.authapp.model

data class User(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val dateOfBirth: String = "",
    val email: String = "",
    val level: String = "",
    val completedPractices: List<Practice> = emptyList()
)

data class Practice(
    val id: String = "",
    val points: Int = 0,

    val title: String,
    val description: String,
    val completedAt: Long = System.currentTimeMillis()
)