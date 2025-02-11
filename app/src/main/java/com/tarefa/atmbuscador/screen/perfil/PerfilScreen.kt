package com.tarefa.atmbuscador.screen.perfil


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material.Icon
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.tarefa.atmbuscador.componentes.BottomNavigationBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

import com.tarefa.atmbuscador.screen.perfil.EditarPerfilBottomSheet


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen(navController: NavController) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Perfil",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Nome de Usuário", fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(40.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Contato", fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(40.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { showSheet = true },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text("Alterar")
            }
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            EditarPerfilBottomSheet(sheetState) { showSheet = false }
        }
    }
}


@Preview
@Composable
fun PerfilScreenPreview() {

    PerfilScreen(rememberNavController())
}