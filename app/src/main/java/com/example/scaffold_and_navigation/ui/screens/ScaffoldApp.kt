package com.example.scaffold_and_navigation.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
// parameters from parent
fun ScaffoldApp(
    darkModeEnabled: Boolean,
    onToggleDarkMode: () -> Unit,
    nameInput: String,
    onNameChange: (String) -> Unit
    )

    {
        // navigation logic for whole app is created here
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable(route = "home") {
                MainScreen(
                    navController,
                    nameInput = nameInput,       // pass state variable
                    onNameChange = onNameChange  // callback to update is given for MainScreen only
                )
            }
            composable(route = "info") {
                InfoScreen(
                    navController,
                    nameInput = nameInput // pass state variable
                )
            }
            composable(route = "settings") {
                SettingsScreen(
                    navController,
                    darkModeEnabled = darkModeEnabled, // pass state variable
                    onToggleDarkMode = onToggleDarkMode, // pass callback to update for SettingsScreen only
                    nameInput = nameInput
                )
            }
        }
    }