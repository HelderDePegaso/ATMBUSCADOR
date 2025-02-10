package com.tarefa.atmbuscador.componentes


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.tarefa.atmbuscador.Screen
import com.tarefa.atmbuscador.screen.*


@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate(Screen.Home.route) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            label = { Text("Buscar") },
            selected = false,
            onClick = { /* Implementar */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.CheckCircle, contentDescription = "comuns") },
            label = { Text("Comuns") },
            selected = false,
            onClick = { /* Implementar */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.KeyboardArrowUp, contentDescription = "filas") },
            label = { Text("Filas") },
            selected = false,
            onClick = { /* Implementar */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = false,
            onClick = { /* Implementar */ }
        )
    }
}
