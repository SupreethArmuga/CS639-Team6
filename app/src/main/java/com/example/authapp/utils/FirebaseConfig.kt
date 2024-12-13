package com.example.authapp.utils


import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirebaseConfig {
    private var db: FirebaseFirestore? = null

    fun initialize() {
        if (db == null) {
            db = Firebase.firestore
        }
    }

    fun getFirestore(): FirebaseFirestore {
        return db ?: Firebase.firestore.also { db = it }
    }
}