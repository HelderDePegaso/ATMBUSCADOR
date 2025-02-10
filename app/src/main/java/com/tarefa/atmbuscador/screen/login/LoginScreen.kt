package com.tarefa.atmbuscador.screen.login

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tarefa.atmbuscador.Screen
import com.tarefa.atmbuscador.screen.home.HomeScreen

@Composable
fun LoginScreen(navController: NavController) {
    var nomeUsuario by remember { mutableStateOf("") };

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Tela de Login")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nomeUsuario,
            onValueChange = { nomeUsuario = it},
            modifier = Modifier.height(20.dp).background(color = Color(189, 1, 1)),
            placeholder = { Text("Nome de Usuário") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.SignUp.route) }) {
            Text("Ir para Sign Up")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Text("Entrar")
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    val fakeNavController = rememberNavController()
    LoginScreen(fakeNavController) // 🔹 Passa um NavController fake para o Preview funcionar
}


