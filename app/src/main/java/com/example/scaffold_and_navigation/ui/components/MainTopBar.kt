package com.example.scaffold_and_navigation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar() {

    var expanded by remember {mutableStateOf(false)}

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        title = {
            Text("My app")
        },
        navigationIcon = {

            IconButton (onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Open menu dropdown",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Open submenu",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Info")},
                    onClick = { navController.navigate("info") }
                )
                DropdownMenuItem(
                    text = { Text("Settings")},
                    onClick = { navController.navigate("settings") }
                )
            }
        }
    )
}
