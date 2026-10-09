package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.cos
import kotlin.math.sin

val EstrellaShape = GenericShape { size, _ ->
    val cx = size.width / 2f
    val cy = size.height / 2f
    val radioExt = size.width / 2f
    val radioInt = radioExt * 0.38f

    for (i in 0 until 10) {
        val radio = if (i % 2 == 0) radioExt else radioInt
        val angulo = -Math.PI / 2 + i * Math.PI / 5
        val x = cx + (radio * cos(angulo)).toFloat()
        val y = cy + (radio * sin(angulo)).toFloat()
        if (i == 0) moveTo(x, y) else lineTo(x, y)
    }
    close()
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    val rojo = Color(0xFFE30A17)
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .background(rojo)
    ) {
        val (lunaexterior, lunainferior, estrella) = createRefs()

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
                .constrainAs(lunaexterior) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    horizontalBias = 0.25f
                    width = Dimension.percent(0.333f)
                    height = Dimension.percent(0.5f)
                }
        )

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(rojo)
                .constrainAs(lunainferior) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    horizontalBias = 0.33f
                    width = Dimension.percent(0.266f)
                    height = Dimension.percent(0.4f)
                }
        )

        Box(
            modifier = Modifier
                .clip(EstrellaShape)
                .background(Color.White)
                .constrainAs(estrella) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    horizontalBias = 0.54f
                    width = Dimension.percent(0.166f)
                    height = Dimension.percent(0.25f)
                }
        )
    }
}

@Preview
@Composable
fun showScreen(){
    BanderaScreen(modifier = Modifier)
}
