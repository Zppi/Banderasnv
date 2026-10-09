package Screen

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeAnimationSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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

val rojo = Color(0xFFCE1126)

@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = modifier.fillMaxWidth().aspectRatio(4f/3f)
    ){
        val canvas = createRef()

        Canvas(
            modifier = Modifier.constrainAs(canvas){
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

            drawRect(Color.Black)

            val triRojo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(w, h)
                close()
            }
            drawPath(triRojo, rojo)

            drawEstrella(Offset(w * 0.25f, h * 0.50f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.12f, h * 0.70f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.38f, h * 0.66f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.25f, h * 0.90f), w * 0.045f, Color.White)
            drawEstrella(Offset(w * 0.31f, h * 0.73f), w * 0.022f, Color.White)
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier)
}


