package com.exam.deepfine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.exam.deepfine.presentation.TodoScreen
import com.exam.deepfine.ui.theme.DeepfineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeepfineTheme {
                TodoScreen()
            }
        }
    }
}
