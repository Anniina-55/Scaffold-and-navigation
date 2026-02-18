package com.example.scaffold_and_navigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.scaffold_and_navigation.ui.components.ScreenTopBar


@Composable
// parameters from parent
fun SettingsScreen(
    navController: NavController,
    darkModeEnabled: Boolean,
    onToggleDarkMode: () -> Unit,
    nameInput: String
) {

    Scaffold(
        topBar = { ScreenTopBar("Settings", navController) },
    ) { innerPadding ->

        Column (
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            Text(
                text = "Hi $nameInput,\nthis is Settings screen",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center
            )
            // button has toggle function as onClick parameter
            Button(
                onClick = onToggleDarkMode,
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                // conditional text based on dark mode state
                Text(
                    text = if (darkModeEnabled) "Switch to light mode" else "Switch to dark mode",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}



