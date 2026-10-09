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
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

fun DrawScope.dibujarEstrella(centro: Offset, radio: Float, color: Color) {
    val triangulo = Path().apply {
        moveTo(centro.x, centro.y - radio)
        lineTo(centro.x - radio * 0.866f, centro.y + radio * 0.5f)
        lineTo(centro.x + radio * 0.866f, centro.y + radio * 0.5f)
        close()
    }
    drawPath(triangulo, color)
    rotate(180f, pivot = centro) {
        drawPath(triangulo, color)
    }
}

private val Azul = Color(0xFF0038B8)

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(11f / 8f)
            .background(Color.White)
    ) {
        val (franjaazul, franjaazul2, estrella) = createRefs()

        val lineasuperior = createGuidelineFromTop(0.094f)
        val lineasuperior1 = createGuidelineFromTop(0.25f)
        val lineaInferior2 = createGuidelineFromTop(0.75f)
        val lineaInferior3 = createGuidelineFromTop(0.906f)

        Box(
            modifier = Modifier.constrainAs(franjaazul) {
                top.linkTo(lineasuperior)
                bottom.linkTo(lineasuperior1)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
                .background(Azul)
        )
        Box(
            modifier = Modifier.constrainAs(franjaazul2) {
                top.linkTo(lineaInferior2)
                bottom.linkTo(lineaInferior3)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
                .background(Azul)
        )
        Canvas(
            modifier = Modifier.constrainAs(estrella){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ){
            val centro = Offset(size.width/2f, size.height/2f)
            dibujarEstrella(centro, size.height *0.22f, Azul)
            dibujarEstrella(centro, size.height *0.155f, Color.White)
        }
    }
}

@Preview
@Composable
fun ShowScreen(){
    BanderaScreen(modifier = Modifier)
}