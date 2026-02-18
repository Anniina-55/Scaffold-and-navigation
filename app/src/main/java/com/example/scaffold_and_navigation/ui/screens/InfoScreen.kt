package com.example.scaffold_and_navigation.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.scaffold_and_navigation.ui.components.ScreenTopBar

@Composable
// parameters from parent
fun InfoScreen(navController: NavController, nameInput: String) {
    Scaffold(
        topBar = { ScreenTopBar(title = "Info", navController) },
    ) { innerPadding ->
        Text(
            text = "Hi $nameInput,\n this is Info screen",
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center,
        )
    }

}