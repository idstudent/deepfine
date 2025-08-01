package com.exam.deepfine.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.exam.deepfine.R
import com.exam.deepfine.data.model.TodoItem
import com.exam.deepfine.navigation.AppRoutes
import com.exam.deepfine.presentation.viewmodel.TodoViewModel
import com.exam.deepfine.util.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(
    navController: NavController
) {
    val todoViewModel: TodoViewModel = hiltViewModel()
    val todos = todoViewModel.todos.collectAsState()

    var inputText by remember { mutableStateOf("") }

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
                    text = "DEEP.FINE TODO",
                    color = AppColors.Black,
                    fontSize = 20.sp,
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = AppColors.White
            ),
            actions = {
                IconButton(
                    onClick = {
                        navController.navigate(AppRoutes.HISTORY)
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_deployed_code_history_24),
                        tint = AppColors.Black,
                        contentDescription = "historyBtn"
                    )
                }
            }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            items(
                todos.value.filter { !it.isCompleted },
                key = { it.id }
            ) {
                TodoItemView(
                    todo = it,
                    onCompleteClick = { item ->
                        todoViewModel.updateItem(item)
                    },
                    onDragDelete = { item ->
                        todoViewModel.deleteItem(item)
                    }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppColors.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(
                        text = "할 일을 입력해주세요.",
                        color = AppColors.Color686868
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = AppColors.White,
                    unfocusedLabelColor = AppColors.White
                ),
                shape = RoundedCornerShape(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                // trim을 써야될지 말아야할지 생각하다가, 입력창이 비어있으면 이라고해서 공백도 입력으로 보았습니다.
                enabled = inputText.isNotEmpty(),
                modifier = Modifier
                    .background(color = AppColors.Color686868, shape = CircleShape),
                onClick = {
                    todoViewModel.insertItem(TodoItem(content = inputText))
                    inputText = ""
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_check_24),
                    contentDescription = "addBtn",
                    tint = AppColors.Black
                )
            }
        }
    }
}
