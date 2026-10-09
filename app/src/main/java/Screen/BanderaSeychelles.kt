package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


val Azul = Color(0xFF003F87)
val Amarrillo = Color(0xFFFCD856)
val Rojo = Color(0xFFD62828)
val Verde = Color(0xFF007A3D)

@Composable
fun BanderaSceen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2f)
    ) {
        val canvas = createRefs().component1()

        Canvas(
            modifier = Modifier.constrainAs(canvas){
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
            val origen = Offset(0f, h)

            fun franja(p1: Offset, p2: Offset, color: Color){
                val path = Path().apply {
                    moveTo(origen.x, origen.y)
                    lineTo(p1.x, p1.y)
                    lineTo(p2.x, p2.y)
                    close()
                }
                drawPath(path, color)
            }
            franja(Offset(0f, 0f), Offset(w/3f, 0f),Azul)
            franja(Offset(w/3f, 0f), Offset(w * 2f/3f,0f), Amarrillo)
            franja(Offset(w * 2f /3f, 0f), Offset(w,0f), Rojo)
            franja(Offset(w, 0f), Offset(w, h /2f), Color.White)
            franja(Offset(w, h/2f), Offset(w, h), Verde)
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaSceen(modifier = Modifier)
}
