package com.example.banderasnv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderasnv.ui.theme.BanderasnvTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasnvTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BanderaEspana(modifier = Modifier.padding(innerPadding).fillMaxSize())
                }
            }
        }
    }
}

@Preview
@Composable
fun BanderaEspana(modifier: Modifier= Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(1f).
            fillMaxWidth().
            background(Color(0xFFAA151B))
        )
        Box(
            modifier = Modifier.weight(2f).
            fillMaxWidth().
            background(Color(0xFFF1BF00)),
            contentAlignment = Alignment.CenterStart
        ){
            Image(painter = painterResource(id = R.drawable.escudo_espana),
                contentDescription = "imagen del esculo de espana",
                modifier = Modifier.padding(start = 40.dp).size(150.dp),
                )
        }
        Box(
            modifier = Modifier.weight(1f).
            fillMaxWidth().
            background(Color(0xFFAA151B))
        )
    }

}