package com.exam.deepfine.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exam.deepfine.R
import com.exam.deepfine.util.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen() {
    var inputText by remember { mutableStateOf("") }
    val todoList = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Color686868)
    ) {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "DEEP.FINE TODO",
                    color = AppColors.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = AppColors.White
            ),
            actions = {
                IconButton(
                    onClick = {}
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
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(todoList) { todo ->
                TodoItem()
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
                    Text("할 일을 입력해주세요.", color = AppColors.Color686868)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = AppColors.Color686868,
                    unfocusedLabelColor = AppColors.Color686868
                ),
                shape = RoundedCornerShape(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(
                modifier = Modifier
                    .background(color = AppColors.Color686868, shape = CircleShape),
                onClick = {
                    if (inputText.isNotEmpty()) {
                        // TODO: 저장 작업
                        inputText = ""
                    }
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
