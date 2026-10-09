package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

val azul = Color(0xFF012169)
val rojo = Color(0xFFC8102E)

@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(
        modifier = modifier.fillMaxWidth().aspectRatio(2f)
    ) {
        val canvas = createRef()

        Canvas(modifier  = Modifier.constrainAs(canvas){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
            }
        ){
            val w = size.width
            val h = size.height
            val u = h/30f

            drawRect(azul)

            drawLine(Color.White, Offset(0f,0f), Offset(w,h), 6 *u)
            drawLine(Color.White, Offset(w,0f), Offset(0f,h), 6 *u)

            val recorte = Path().apply {
                moveTo(30 * u, 15 *u); lineTo(60 * u, 15 * u); lineTo(60 *u, 30 *u); close()
                moveTo(30 * u, 15 *u); lineTo(30 * u, 30 * u); lineTo(0f *u, 30 *u); close()
                moveTo(30 * u, 15 *u); lineTo(0f, 15 * u); lineTo(0f,0f); close()
                moveTo(30 * u, 15 *u); lineTo(30 * u,  0f); lineTo(60 *u, 0f); close()
            }
            clipPath(recorte){
                drawLine(rojo, Offset(0f,0f), Offset(w,h), 4 *u)
                drawLine(rojo, Offset(w,0f), Offset(0f, h), 4 *u)
            }
            drawRect(Color.White, Offset(0F,10 *u), Size(w, 10 *u))
            drawRect(Color.White, Offset(25 * u,0f), Size(10 *u, h))

            drawRect(rojo, Offset(0F,12 *u), Size(w, 6 *u))
            drawRect(rojo, Offset(27 * u, 0f), Size(6 *u,  h))
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier)
}