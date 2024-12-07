package com.example.authapp.ui.navigation


import SignupScreen
import WelcomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.ui.screens.*
import com.example.authapp.viewmodel.UserViewModel

@Composable
fun AuthNavigation(
    onGoogleSignInClick: () -> Unit
) {
    val navController = rememberNavController()
    val userViewModel: UserViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Welcome.route) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(Screen.Signup.route) {
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate(Screen.UserProfile.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                },
                onGoogleSignInClick = onGoogleSignInClick
            )
        }
        composable(Screen.UserProfile.route) {
            UserProfileScreen(
                userViewModel = userViewModel,
                onNavigateToLevel = {
                    navController.navigate(Screen.LevelSelection.route)
                }
            )
        }
        composable(Screen.LevelSelection.route) {
            LevelSelectionScreen(
                userViewModel = userViewModel,
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Welcome.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.ExploreAndPractice.route) {
            ExploreAndPracticeScreen(
                navController = navController,
                userViewModel = userViewModel
            )
        }
        composable(Screen.TrackProgress.route) {
            TrackProgressScreen(
                navController = navController,
                userViewModel = userViewModel
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                userViewModel = userViewModel,
                onSignOut = {
                    navController.navigate(Screen.Welcome.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            )
        }
    }
}