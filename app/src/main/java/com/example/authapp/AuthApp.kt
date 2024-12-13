package com.example.authapp

import android.app.Application
import com.example.authapp.utils.FirebaseConfig
import com.google.firebase.FirebaseApp

class AuthApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        FirebaseConfig.initialize()
    }
}