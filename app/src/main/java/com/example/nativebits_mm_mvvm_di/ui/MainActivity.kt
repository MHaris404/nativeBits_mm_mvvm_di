package com.example.nativebits_mm_mvvm_di.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.nativebits_mm_mvvm_di.ui.navigation.AppNavigationGraph
import com.example.nativebits_mm_mvvm_di.ui.theme.NativeBits_mm_mvvm_diTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //
        installSplashScreen()
        setContent {
            NativeBits_mm_mvvm_diTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    AppEntryPoint()
                }
            }
        }
    }

}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}
