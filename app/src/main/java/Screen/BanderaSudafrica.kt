package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

val RojoSA = Color(0xFFE03C31)
val azul = Color(0xFF001489)
val verde = Color(0xFF007749)
val dorado = Color(0xFFFFB81C)

@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = modifier.fillMaxWidth().aspectRatio(3f/2f)
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
                .clipToBounds()
        ) {
            val w = size.width
            val h = size.height
            val medio = h/2f

            drawRect(RojoSA, Offset(0f, 0f), Size(w, medio))
            drawRect(azul, Offset(0f, medio), Size(w, medio))

            val punto = Offset(w * 0.36f, medio)
            drawLine(Color.White, Offset(0f,0f), punto, h *0.30f)
            drawLine(Color.White, Offset(0f,h), punto, h *30f)
            drawLine(Color.White, punto, Offset(w,medio),h *0.30f)

            drawLine(verde, Offset(0f,0f),  punto, h * 0.20f)
            drawLine(verde, Offset(0f,h), punto, h * 0.20f)
            drawLine(verde, punto, Offset(w,medio), h * 0.20f)

            val trianguloOro = Path().apply {
                moveTo(0f, h * 0.14f)
                lineTo(0f, h * 0.86f)
                lineTo(w * 0.26f, medio)
                close()
            }
            drawPath(trianguloOro, dorado)

            val traianguloNegro = Path().apply {
                moveTo(0f, h * 0.19f)
                lineTo(0f, h * 0.81f)
                lineTo(w * 0.22f, medio)
                close()
            }
            drawPath(trianguloOro, Color.Black)
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier)
}