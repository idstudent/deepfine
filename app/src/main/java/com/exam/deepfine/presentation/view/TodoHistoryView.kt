package com.exam.deepfine.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.exam.deepfine.data.model.TodoItem
import com.exam.deepfine.util.AppColors
import com.exam.deepfine.util.formatDate


@Composable
fun TodoHistoryView(
    todo: TodoItem
) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .background(AppColors.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = todo.content,
            color = AppColors.Black
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text("등록일:${formatDate(todo.addTimeStamp)}")
            Text("완료일:${todo.completedTimeStamp?.let { formatDate(it) } ?: ""}")
        }
    }

}