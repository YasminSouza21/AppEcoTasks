package com.app.todoappecotasks

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(model: TodoViewModel) {
    val navController = rememberNavController()
    val todoViewModel: TodoViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController) }
        composable("welcome/{email}") { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: "Usuário"
            WelcomePage(navController, email)
        }
        composable("todolist") { TodoListPage(model) }
    }
}
