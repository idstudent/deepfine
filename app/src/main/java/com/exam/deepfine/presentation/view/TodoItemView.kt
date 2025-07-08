package com.exam.deepfine.presentation.view

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.exam.deepfine.R
import com.exam.deepfine.data.model.TodoItem
import com.exam.deepfine.util.AppColors

@Composable
fun TodoItemView(
    todo: TodoItem,
    onCompleteClick: (TodoItem) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .background(AppColors.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .background(
                    color = AppColors.White,
                    shape = CircleShape
                )
                .clickable {
                    onCompleteClick(todo)
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.outline_check_24),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = "checkBtn"
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = todo.content,
            color = AppColors.Black
        )
    }
}