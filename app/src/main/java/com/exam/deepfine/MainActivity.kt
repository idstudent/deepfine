package com.exam.deepfine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.exam.deepfine.navigation.NavigationGraph
import com.exam.deepfine.ui.theme.DeepfineTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeepfineTheme {
                val navController = rememberNavController()
                NavigationGraph(navController = navController)
            }
        }
    }
}
