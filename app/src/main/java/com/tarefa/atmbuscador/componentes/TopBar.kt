package com.tarefa.atmbuscador.componentes




import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(title: String) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(text = title, fontSize = 20.sp, textAlign = TextAlign.Center)
        },

        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    content = { Text("Favoritos") },
                    onClick = { /* Ação de Favoritos */ expanded = false }
                )
                DropdownMenuItem(
                    content = { Text("Item 2") },
                    onClick = { /* Ação Item 2 */ expanded = false }
                )
                DropdownMenuItem(
                    content = { Text("Sair") },
                    onClick = { /* Ação de Logout */ expanded = false }
                )
            }
        }
    )
}
