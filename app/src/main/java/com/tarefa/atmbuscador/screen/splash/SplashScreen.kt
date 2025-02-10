package com.tarefa.atmbuscador.screen.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.tarefa.atmbuscador.Screen

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "ATM B - Carregando...")
    }

    LaunchedEffect(Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }, 3000)
    }
}
