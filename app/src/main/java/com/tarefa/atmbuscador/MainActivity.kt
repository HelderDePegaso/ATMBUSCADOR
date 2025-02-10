package com.tarefa.atmbuscador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.tarefa.atmbuscador.ui.theme.ATMBUSCADORTheme

import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavGraph()
        }
    }
}
