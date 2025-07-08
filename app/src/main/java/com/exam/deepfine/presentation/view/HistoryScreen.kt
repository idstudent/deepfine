package com.exam.deepfine.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.exam.deepfine.R
import com.exam.deepfine.presentation.viewmodel.TodoViewModel
import com.exam.deepfine.util.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navController: NavController
) {
    val todoViewModel: TodoViewModel = hiltViewModel()
    val todos = todoViewModel.todos.collectAsState()

    LaunchedEffect(Unit) {
        todoViewModel.getTodos()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Color686868)
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "History",
                    color = AppColors.Black,
                    fontSize = 20.sp,
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = AppColors.White
            ),
            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.outline_arrow_back_24),
                        tint = AppColors.Black,
                        contentDescription = "backBtn"
                    )
                }
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(todos.value.filter { it.isCompleted }) {
                TodoHistoryView(it)
            }
        }
    }
}