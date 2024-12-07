package com.example.authapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    userViewModel: UserViewModel = viewModel(),
    onSignOut: () -> Unit
) {
    val user by userViewModel.user.collectAsState()

    LaunchedEffect(Unit) {
        userViewModel.loadUserProfile()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            user?.let { user ->
                ProfileField("First Name", user.firstName)
                ProfileField("Last Name", user.lastName)
                ProfileField("Email", user.email)
                ProfileField("Date of Birth", user.dateOfBirth)
                ProfileField("Level", user.level.capitalize())
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    userViewModel.signOut()
                    onSignOut()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign Out")
            }
        }
    }
}

@Composable
private fun ProfileField(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = label, style = MaterialTheme.typography.bodySmall)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}