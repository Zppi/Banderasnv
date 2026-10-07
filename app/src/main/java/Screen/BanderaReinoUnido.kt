package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val azulMarino = Color(0xFF00247D)
        val rojo = Color(0xFFC8102E)

        drawRect(color = azulMarino)

        val diagonalBlanca = size.height * 0.14f
        drawLine(Color.White, Offset(0f, 0f), Offset(size.width, size.height), diagonalBlanca)
        drawLine(Color.White, Offset(size.width, 0f), Offset(0f, size.height), diagonalBlanca)

        val diagonalRoja = size.height * 0.045f
        val desplaza = size.height * 0.025f

        drawLine(rojo, Offset(0f, -desplaza), Offset(size.width, size.height - desplaza), diagonalRoja)
        drawLine(rojo, Offset(0f, desplaza), Offset(size.width, size.height + desplaza), diagonalRoja)
        drawLine(rojo, Offset(size.width, -desplaza), Offset(0f, size.height - desplaza), diagonalRoja)
        drawLine(rojo, Offset(size.width, desplaza), Offset(0f, size.height + desplaza), diagonalRoja)


        val cruzBlanca = size.height * 0.2f
        drawRect(Color.White, Offset(0f, size.height/2f), Size(size.width, cruzBlanca))
        drawRect(Color.White, Offset(size.width / 2f - cruzBlanca / 2f, 0f), Size(cruzBlanca, size.height))

        val cruzRoja = size.height * 0.13f
        drawRect(rojo, Offset(0f, size.height /2f - cruzRoja), Size(size.width, cruzRoja))
        drawRect(rojo, Offset(size.width/ 2f - cruzRoja /2f, 0f), Size(cruzRoja, size.height))
    }
}

@Preview
@Composable
fun showScren(){
    BanderaScreen(modifier = Modifier.fillMaxSize())
}