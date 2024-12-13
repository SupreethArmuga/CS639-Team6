package com.example.authapp.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Signup : Screen("signup")
    object UserProfile : Screen("user_profile")
    object LevelSelection : Screen("level_selection")
    object Home : Screen("home")
    object ExploreAndPractice : Screen("explore_practice")
    object TrackProgress : Screen("track_progress")
    object Profile : Screen("profile")
    object PracticeDetails : Screen("practice_details/{practiceId}") {
        fun createRoute(practiceId: String) = "practice_details/$practiceId"
    }

    companion object {
        fun fromRoute(route: String?): Screen {
            return when (route) {
                Welcome.route -> Welcome
                Signup.route -> Signup
                UserProfile.route -> UserProfile
                LevelSelection.route -> LevelSelection
                Home.route -> Home
                ExploreAndPractice.route -> ExploreAndPractice
                TrackProgress.route -> TrackProgress
                Profile.route -> Profile
                else -> Welcome
            }
        }
    }
}