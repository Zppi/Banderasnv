package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
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

val Azul = Color(0xFF002A8F)
val Rojo = Color(0xFFCF142B)

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .background(Color.White)
    ) {
        val (franja1, franja3, franja5, triangulo) = createRefs()

        val linea1 = createGuidelineFromTop(0.2f)
        val linea2 = createGuidelineFromTop(0.4f)
        val linea3 = createGuidelineFromTop(0.6f)
        val linea4 = createGuidelineFromTop(0.8f)

        Box(
            modifier = Modifier
                .constrainAs(franja1) {
                    top.linkTo(parent.top)
                    bottom.linkTo(linea1)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Azul)
        )

        Box(
            modifier = Modifier.constrainAs(franja3) {
                top.linkTo(linea2)
                bottom.linkTo(linea3)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
                .background(Azul)
        )
        Box(
            modifier = Modifier.constrainAs(franja5) {
                top.linkTo(linea4)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
                .background(Azul)
        )

        Canvas(
            modifier = Modifier.constrainAs(triangulo){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ) {
            val h = size.height
            val punta = h * 0.866f

            val trianguloRojo = Path().apply {
                moveTo(0f, 0f)
                lineTo(punta, h /2f)
                lineTo(0f, h)
                close()
            }
            drawPath(trianguloRojo, Rojo)
            drawEstrella(Offset(punta/3f,h/2f), h * 0.14f, Color.White)
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier)
}