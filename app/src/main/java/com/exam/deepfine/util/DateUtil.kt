package com.exam.deepfine.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date: Long): String {
    val formatter = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
    return formatter.format(date)
}