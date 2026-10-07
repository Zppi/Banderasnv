package Screen

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    Canvas(modifier = modifier.fillMaxSize()){
        val verde = Color(0xFF007749)
        val azul = Color(0xFF002395)
        val dorado = Color(0xFFFFB81C)

        drawRect(color = azul, size = Size(size.width, size.height /2f))
        drawRect(color = dorado, topLeft = Offset(0f, size.height /2f), size = Size(size.width, size.height/ 2f))

        val bloque = Offset(size.width * 0.36f, size.height/2f)

        drawLine(Color.White, Offset(0f, 0f), bloque, size.height *0.30f)
        drawLine(Color.White, Offset(0f, size.height), bloque, size.height *0.30f)
        drawLine(Color.White, bloque, Offset(size.width, size.height *0.14f), size.height * 0.30f)
        drawLine(Color.White, bloque, Offset(size.width, size.height *0.86f), size.height *0.30f)

        drawLine(verde, Offset(0f, 0f), bloque, size.height * 0.10f)
        drawLine(verde, Offset(0f, size.height), bloque, size.height * 0.20f)
        drawLine(verde, bloque, Offset(size.width, size.height * 0.14f), size.height * 0.20f)
        drawLine(verde, bloque, Offset(size.width, size.height * 0.86f), size.height *0.20f)

        val triangulo = Path().apply {
            moveTo(0f, 0f)
            lineTo(bloque.x * 0.7f, size.height /2f)
            lineTo(0f, size.height)
            close()
        }
        drawPath(triangulo, color = Color.Black)
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier.fillMaxSize())
}