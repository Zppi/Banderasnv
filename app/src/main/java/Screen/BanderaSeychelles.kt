package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.cos
import kotlin.math.sin

fun puntoEnelBorde(origen: Offset, angulo: Float, width: Float, height: Float): Offset{
    val angulo = Math.toRadians(angulo.toDouble())
    val dx = cos(angulo).toFloat()
    val dy = -sin(angulo).toFloat()
    val tParaArriba = if (dy != 0f) (0f - origen.y) / dy else Float.MAX_VALUE
    val tParaDerecha = if (dx != 0f) (width - origen.x) / dx else Float.MAX_VALUE
    val t = minOf(tParaArriba, tParaDerecha)

    return Offset(
        x = (origen.x + dx * t).coerceIn(0f, width),
        y = (origen.y + dy * t).coerceIn(0f, height)
    )
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    Canvas(modifier = modifier.fillMaxSize()){
        val origen = Offset(0f, size.height)
        val colores = listOf(
            Color(0xFF003F87),
            Color(0xFFFCD856),
            Color(0xFFD62828),
            Color.White,
            Color(0xFF007A3D)
        )
        val angulos = listOf(90f, 72f, 54f, 36f, 18f, 0f)

        for (i in 0 until 5){
            val puntoA = puntoEnelBorde(origen, angulos[i], size.width, size.height)
            val puntoB = puntoEnelBorde(origen, angulos[i +1], size.width, size.height)

            val path = Path().apply {
                moveTo(origen.x, origen.y)
                lineTo(puntoA.x, puntoA.y)

                val aEnArriba = puntoA.y == 0f
                val bEnArriba = puntoB.y == 0f
                if(aEnArriba != bEnArriba){
                    lineTo(size.width, 0f)
                }
                lineTo(puntoB.x, puntoB.y)
                close()
            }
            drawPath(path, color = colores[i])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier.fillMaxSize())
}