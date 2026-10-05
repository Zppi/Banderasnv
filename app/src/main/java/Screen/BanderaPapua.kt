package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import kotlin.io.path.moveTo
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun DrawScope.drawEstrella(centro: Offset, radioExterior: Float, color: Color) {
    val radioInterior = radioExterior * 0.4f
    val path = Path()
    for (i in 0 until 10) {
        val radio = if (i % 2 == 0) radioExterior else radioInterior
        val angulo = -PI / 2 + i * PI / 5
        val x = centro.x + (radio * cos(angulo)).toFloat()
        val y = centro.y + (radio * sin(angulo)).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    drawPath(path, color)
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(4f / 3f)
    ){
        Canvas(modifier = Modifier.fillMaxSize()){
            val w = size.width
            val h = size.height

            drawRect(color = Color.Black)

            val rojo = Color(0xFFCE1126)
            val Amarillo = Color(0xFFFCD116)

            val trianguloRojo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(w, h)
                close()
            }
            drawPath(trianguloRojo, rojo)

            drawEstrella(Offset(w * 0.25f, h * 0.50f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.12f, h * 0.70f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.38f, h * 0.66f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.25f, h * 0.90f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.31f, h * 0.73f), w * 0.022f, Color.White)

            val ave = listOf(
                0.05f to 0.55f, 0.25f to 0.45f, 0.35f to 0.20f, 0.45f to 0.10f,
                0.55f to 0.25f, 0.70f to 0.30f, 0.95f to 0.20f, 0.80f to 0.45f,
                0.95f to 0.70f, 0.65f to 0.60f, 0.55f to 0.85f, 0.40f to 0.60f,
                0.20f to 0.90f, 0.22f to 0.62f
            )

            val origenx = w *0.53f
            val origeny = h * 0.14f
            val anchoAve = w * 0.30f
            val altoAve = h * 0.40f
            val pathave = Path().apply {
                ave.forEachIndexed { i, (px,py) ->
                    val x = origenx + px * anchoAve
                    val y = origeny + py * altoAve
                    if (i ==0) moveTo(x,y) else lineTo(x,y)
                }
                close()
            }
            drawPath(pathave,Amarillo)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showScreen(){
    BanderaScreen()
}