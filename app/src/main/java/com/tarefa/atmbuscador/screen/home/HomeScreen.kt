package com.tarefa.atmbuscador.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.tarefa.atmbuscador.componentes.BottomNavigationBar
import com.tarefa.atmbuscador.componentes.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar(title = "ATM 2") },
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchBar()
            AppliedFilters()
            WebViewGoogleMaps()
        }
    }
}

@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Pesquisar") }
        )
        IconButton(onClick = { /* Ação de pesquisa */ }) {
            Icon(Icons.Default.Search, contentDescription = "Buscar")
        }
    }
}

@Composable
fun AppliedFilters() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp).horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        listOf("Um filtro Aplicado", "Outro filtro", "Mais um filtro").forEach { filter ->
            Chip(text = filter, onRemove = { /* Remover filtro */ })
        }
    }
}

@Composable
fun Chip(text: String, onRemove: () -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text)
            IconButton(onClick = onRemove) {
                Icon(Icons.Default.Close, contentDescription = "Remover")
            }
        }
    }
}

@Composable
fun WebViewGoogleMaps() {
    val state = rememberWebViewState(url = "https://www.google.com/maps")
    WebView(
        state = state,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val fakeNavController = rememberNavController()
    HomeScreen(fakeNavController) // 🔹 Passa um NavController fake para o Preview funcionar
}