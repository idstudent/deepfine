package com.exam.deepfine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.exam.deepfine.presentation.view.HistoryScreen
import com.exam.deepfine.presentation.view.TodoScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.TODO_LIST
    ) {
        composable(route = AppRoutes.TODO_LIST) {
            TodoScreen(navController)
        }
        composable(route = AppRoutes.HISTORY) {
            HistoryScreen(navController)
        }
    }
}