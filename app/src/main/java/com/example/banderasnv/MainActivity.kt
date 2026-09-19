package com.example.banderasnv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderasnv.ui.theme.BanderasnvTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasnvTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   BanderaMexico(modifier = Modifier.padding(innerPadding).fillMaxSize())
                }
            }
        }
    }
}

@Preview
@Composable
fun BanderaMexico(modifier: Modifier = Modifier){
    Row(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(1f).
            fillMaxHeight().
            background(Color.Green)
        )
        Box(
            modifier = Modifier.weight(1f).
            fillMaxHeight().
            background(Color.White),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.escudo_nacional_mexicano),
                contentDescription = "imagen del escudo de mexico"
            )
        }
        Box(
            modifier = Modifier.weight(1f).
            fillMaxHeight().
            background(Color.Red)
        )
    }
}
