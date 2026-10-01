package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {

        val (amarillo, azul, rojo) = createRefs()

        val linea1 = createGuidelineFromTop(0.333f)
        val linea2 = createGuidelineFromTop(0.666f)

        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .constrainAs(amarillo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(linea1)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(azul) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea1)
                    bottom.linkTo(linea2)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(rojo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea2)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowScreen(modifier: Modifier = Modifier) {
    BanderaScreen(modifier.fillMaxSize())

}