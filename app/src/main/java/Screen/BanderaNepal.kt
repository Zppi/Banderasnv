package Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.yield
import kotlin.math.cos
import kotlin.math.sin

fun triangulo(a: Offset, b: Offset, c: Offset, factor: Float =1f) : Path{
    val centro = Offset((a.x + b.x +c.x) /3f, (a.y +b.y +c.y)/3f)
    fun e(p: Offset) = centro + (p- centro) * factor
    return Path().apply {
        moveTo(e(a).x, e(a).y)
        lineTo(e(b).x, e(b).y)
        lineTo(e(c).x, e(c).y)
        close()
    }
}

fun estrella(cx: Float, cy: Float, radioext: Float, radioint: Float, puntas: Int): Path{
    val path = Path()
    for (i in 0 until puntas *2){
        val radio = if(i %2 ==0) radioext else radioint
        val angulo = -Math.PI/2 +i * Math.PI/puntas
        val x = cx + (radio * cos(angulo)).toFloat()
        val y = cy + (radio * sin(angulo).toFloat())
        if (i == 0) path.moveTo(x,y) else path.lineTo(x,y)
    }
    path.close()
    return  path
}


@Composable
fun BanderaScreen(modifier: Modifier = Modifier){
    Canvas(modifier = modifier.width(240.dp).height(290.dp)){
        val w = size.width
        val h = size.height
        val azul = Color(0xFF003893)
        val carmesi = Color(0xFFDC143C)

        val infA = Offset(0f, h*0.22f)
        val infB = Offset(w * 0.88f, h)
        val infc = Offset(0f, h)
        drawPath(triangulo(infA, infB, infc), color = azul)
        drawPath(triangulo(infA, infB, infc, 0.88f), color = carmesi)

        val supA = Offset(0f, 0f)
        val supB = Offset(w * 0.75f, h * 0.46f)
        val supC = Offset(0f, h* 0.46f)
        drawPath(triangulo(supA, supB, supC),color = azul)
        drawPath(triangulo(supA, supB, supC, 0.88f), color =carmesi)

        val centroluna= Offset(w * 0.22f, h *0.31f)
        val radioluna = w*0.09f
        drawCircle(Color.White, radius = radioluna, center = centroluna)
        drawCircle(carmesi, radius = radioluna *0.8f, center = Offset(centroluna.x, centroluna.y - radioluna * 0.4f))
        val sol = estrella(w * 0.27f, h * 0.76f, w * 0.11f, w * 0.11f * 0.6f, 12)
        drawPath(sol,color = Color.White)
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen()
}