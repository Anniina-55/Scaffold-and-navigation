package com.example.scaffold_and_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.scaffold_and_navigation.ui.screens.ScaffoldApp
import com.example.scaffold_and_navigation.ui.theme.ScaffoldandnavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // hoisted state variables for app color theme and name input (managed and transferred from top to children)
            var darkModeEnabled by remember { mutableStateOf(false) } // by default light theme
            var nameInput by remember { mutableStateOf("") } // name is given at MainScreen

            ScaffoldandnavigationTheme(darkTheme = darkModeEnabled) {
                // state values and callback functions are passed down to children components
                ScaffoldApp(
                    darkModeEnabled = darkModeEnabled,
                    onToggleDarkMode = { darkModeEnabled = !darkModeEnabled },
                    nameInput = nameInput,
                    onNameChange = {nameInput = it}
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScaffoldandnavigationTheme {
        ScaffoldApp( darkModeEnabled = false, onToggleDarkMode = {}, nameInput = "", onNameChange = {})

    }
}