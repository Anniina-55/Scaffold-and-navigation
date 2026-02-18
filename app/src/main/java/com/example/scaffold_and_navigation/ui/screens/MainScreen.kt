package com.example.scaffold_and_navigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.unit.dp
import com.example.scaffold_and_navigation.ui.components.MainTopBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
// parameters from parent
fun MainScreen(
    navController: NavController,
    nameInput: String,
    onNameChange: (String) -> Unit
) {

    Scaffold(
        topBar = {
            MainTopBar(navController )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = nameInput, // name is given here
                onValueChange = { onNameChange(it) }, // callback to update
                label = { Text("Enter your name") },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                singleLine = true
            )
            if (nameInput.isNotBlank()) {
                Greeting(
                    name = nameInput,
                    modifier = Modifier
                        .padding(20.dp)

                )
            }
        }
    }
}
// Greeting composable
@Composable
    private fun Greeting(name: String, modifier: Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )
    }

