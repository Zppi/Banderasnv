package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxWidth()
        .aspectRatio(3f / 2f)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            drawRect(Color(0xFFFFD520))
            drawPath(
                Path().apply {
                    moveTo(w, 0f); lineTo(w, h); lineTo(0f, h); close()
                },
                Color(0xFFFF4E12)
            )

            val cuerpo = Path().apply {
                moveTo(w *0.25f, h *0.65f)
                quadraticBezierTo(w * 0.35f, h * 0.25f, w * 0.50f, h *0.45f)
                quadraticBezierTo(w * 0.65f, h * 0.65f, w * 0.78f, h * 0.30f)
            }
            drawPath(
                cuerpo, Color.White,
                style = Stroke(width = h *0.06f, cap = StrokeCap.Round, join = StrokeJoin.Round)
            )
            drawCircle(Color.White, h * 0.07f, Offset(w * 0.22f, h * 0.67f))
            drawCircle(Color.Black, h * 0.012f, Offset(w * 0.21f, h * 0.65f))
        }
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier.fillMaxSize())
}