package com.example.banderasnv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderasnv.ui.theme.BanderasnvTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasnvTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanderaColombia(modifier = Modifier.padding(innerPadding).fillMaxSize())
                }
            }
        }
    }
}

@Preview
@Composable
fun BanderaColombia(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(2f).
            fillMaxWidth().
            background(Color(0xFFFFCE00))
        )
        Box(
            modifier = Modifier.weight(1f).
            fillMaxWidth().
            background(Color(0xFF00247E))
        )
        Box(
            modifier = Modifier.weight(1f).
            fillMaxWidth().
            background(Color(0xFFE80351))
        )
    }

}