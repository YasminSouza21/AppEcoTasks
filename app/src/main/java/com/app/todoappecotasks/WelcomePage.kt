package com.app.todoappecotasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomePage(navController: NavController, username: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Olá, $username!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Bem-vindo ao EcoTasks!",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Button(onClick = {
            navController.navigate("todolist") {
                popUpTo("login) { inclusive = true }")
            }
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF408834),
            contentColor = Color.White
        )){
            Text("Ir para suas tarefas")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    val navController = rememberNavController()
    WelcomePage(navController = navController, username = "Usuário Teste")
}