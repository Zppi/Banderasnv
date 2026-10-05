package Screen

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.SwipeMode
import java.nio.file.WatchEvent

import kotlin.math.cos
import kotlin.math.sin

fun triangulo(cx: Float, cy: Float, r: Float, rotacion: Float): Path {
    val path = Path()
    for (i in 0..2) {
        val angulo = Math.toRadians((rotacion + i * 120).toDouble())
        val x = cx + r * cos(angulo).toFloat()
        val y = cy + r * sin(angulo).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    return path
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth()
                    .background(Color(0xFF0038B8))
            )
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxWidth()
                    .background(Color(0xFF0038B8))
            )
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxWidth())
        }
        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(120.dp)
        ) {
            val cx = size.width /2f
            val cy = size.height /2f
            val radio = size.maxDimension /2.5f

            val trianguloArriba = triangulo(cx,cy,radio, -90f)
            val trianguloabajo = triangulo(cx,cy, radio, 90f)

            drawPath(trianguloArriba, color = Color(0xFF0038B8), style = Stroke(width = 8f))
            drawPath(trianguloabajo, color = Color(0xFF0038B8), style = Stroke(width = 8f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showScreen() {
    BanderaScreen(modifier = Modifier.fillMaxSize())
}