package com.tarefa.atmbuscador


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tarefa.atmbuscador.screen.splash.SplashScreen
import com.tarefa.atmbuscador.screen.login.LoginScreen
import com.tarefa.atmbuscador.screen.signup.SignUpScreen
import com.tarefa.atmbuscador.screen.home.HomeScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")
}

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.SignUp.route) { SignUpScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
    }
}
