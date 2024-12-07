package com.example.authapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authapp.model.User
import com.example.authapp.model.Practice
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class UserViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun saveUserProfile(firstName: String, lastName: String, dateOfBirth: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val userId = auth.currentUser?.uid ?: return@launch
                val user = User(
                    id = userId,
                    firstName = firstName,
                    lastName = lastName,
                    dateOfBirth = dateOfBirth,
                    email = auth.currentUser?.email ?: ""
                )
                db.collection("users").document(userId).set(user).await()
                _user.value = user
                onComplete(true)
            } catch (e: Exception) {
                onComplete(false)
            }
        }
    }

    fun setUserLevel(level: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val userId = auth.currentUser?.uid ?: return@launch
                db.collection("users").document(userId)
                    .update("level", level)
                    .await()
                _user.value = _user.value?.copy(level = level)
                onComplete(true)
            } catch (e: Exception) {
                onComplete(false)
            }
        }
    }

    fun completePractice(practiceId: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val userId = auth.currentUser?.uid ?: return@launch
                val points = (10..100).random()
                val practice = Practice(practiceId, points)

                db.collection("users").document(userId)
                    .collection("practices").add(practice)
                    .await()

                onComplete(true)
            } catch (e: Exception) {
                onComplete(false)
            }
        }
    }

    fun loadUserProfile() {
        viewModelScope.launch {
            try {
                val userId = auth.currentUser?.uid ?: return@launch
                val userDoc = db.collection("users").document(userId).get().await()
                _user.value = userDoc.toObject(User::class.java)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun signOut() {
        auth.signOut()
        _user.value = null
    }
}