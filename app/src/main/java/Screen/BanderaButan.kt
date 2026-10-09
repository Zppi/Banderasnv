package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

val AmarilloBU = Color(0xFFFFD520)
val NaranjaBU = Color(0xFFFF4E12)

@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = modifier.fillMaxWidth().aspectRatio(3f/2f)
    ) {
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

            drawRect(AmarilloBU)
            val trainguloNaranja = Path().apply {
                moveTo(w, 0f)
                lineTo(w,h)
                lineTo(0f, h)
                close()
            }
            drawPath(trainguloNaranja, NaranjaBU)

            val grosor = h * 0.07f
            drawLine(Color.White, Offset(w * 0.30f, h * 0.65f), Offset(w *0.50f, h * 0.40f), grosor,
                StrokeCap.Round)
            drawLine(Color.White, Offset(w * 0.50f, h * 0.40f), Offset(w *0.70f, h * 0.35f), grosor,
                StrokeCap.Round)
            drawCircle(Color.White, h * 0.09f, Offset(w * 0.27f, h * 0.69f))
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier)
}

