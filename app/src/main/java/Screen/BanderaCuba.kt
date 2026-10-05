package Screen

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.cos
import kotlin.math.sin

fun starPath(cx: Float, cy: Float, radio: Float, radiointerior: Float): Path {
    val path = Path()
    val puntos = 5
    val anguloinicial = -Math.PI / 2
    for (i in 0 until puntos * 2) {
        val radio = if (i % 2 == 0) radio else radiointerior
        val angulo = anguloinicial + (i * Math.PI / puntos)
        val x = cx + (radio * cos(angulo)).toFloat()
        val y = cy + (radio * sin(angulo)).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    return path
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        drawRect(
            color = Color.White,
            topLeft = Offset(0f, 0f),
            size = Size(size.width, size.height)
        )
        val banda = size.height / 5f
        for (i in 0 until 5) {
            if (i % 2 == 0) drawRect(
                color = Color(0xFF002E6E),
                topLeft = Offset(0f, i * banda),
                size = Size(size.width, banda)
            )
        }
        val triWith = size.width * 0.38f
        val trianglePath = Path().apply {
            moveTo(0f, 0f)
            lineTo(triWith, size.height / 2f)
            lineTo(0f, size.height)
            close()
        }
        drawPath(trianglePath, color = Color(0xFFCB1428))

        val centrox = triWith / 3f
        val centroy = size.height / 2f
        val radioEstrella = size.height * 0.07f

        val estrella = starPath(centrox, centroy, radioEstrella, radioEstrella * 0.4f)
        drawPath(estrella,color = Color.White)
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier.fillMaxSize())
}