package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun DrawScope.drawEstrellaPuntas(
    centro: Offset, radioExterior: Float, radioInterior: Float, puntas: Int, color: Color
) {
    val path = Path()
    for (i in 0 until puntas * 2) {
        val r = if (i % 2 == 0) radioExterior else radioInterior
        val ang = -PI / 2 + i * PI / puntas
        val x = centro.x + (r * cos(ang)).toFloat()
        val y = centro.y + (r * sin(ang)).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close()
    drawPath(path, color)
}

val carmesi = Color(0xFFDC143C)
val azul = Color(0xFF003893)

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier
        .width(240.dp)
        .height(290.dp)
    ){
        val canvas = createRef()

        Canvas(modifier = Modifier.constrainAs(canvas){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
        ) {
            val w = size.width
            val h = size.height

            val azulSuperior = Path().apply {
                moveTo(0f,0f)
                lineTo(w * 0.92f, h * 0.40f)
                lineTo(0f, h * 0.50f)
                close()
            }
            val azulInferior = Path().apply {
                moveTo(0f,0.50f)
                lineTo(w * 0.92f, h * 0.90f)
                lineTo(0f, h)
                close()
            }
            drawPath(azulSuperior, azul)
            drawPath(azulInferior, azul)

            val rojoSuperior = Path().apply {
                moveTo(w * 0.05f,h * 0.069f)
                lineTo(w * 0.758f, h * 0.376f)
                lineTo(w * 0.05f, h * 0.453f)
                close()
            }
            val rojoInferior = Path().apply {
                moveTo(w * 0.05f, h * 0.569f)
                lineTo(w * 0.758f, h * 0.876f)
                lineTo(w * 0.05f, h * 0.953f)
                close()
            }
            drawPath(rojoSuperior, carmesi)
            drawPath(rojoInferior, carmesi)

            val luna = Offset(w * 0.20f, h * 0.28f)
            val radioLuna = w * 0.07f
            drawCircle(Color.White, radioLuna, luna)
            drawCircle(carmesi, radioLuna * 0.85f, Offset(luna.x, luna.y - radioLuna * 0.4f))
            drawEstrellaPuntas(Offset(luna.x, luna.y - radioLuna * 0.45f), radioLuna * 0.38f, radioLuna * 0.18f, 8, Color.White)

            val sol = Offset(w * 0.26f, h * 0.78f)
            drawEstrellaPuntas(sol, w * 0.12f, w * 0.08f, 12, Color.White)
            drawCircle(carmesi, w * 0.04f, sol)
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier)
}