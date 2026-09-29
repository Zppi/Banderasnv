package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (azul, blanco, rojo) = createRefs()

        val linea1 = createGuidelineFromStart(0.333f)
        val linea2 = createGuidelineFromStart(0.666f)

        Box(
            modifier = Modifier
                .background(Color(0xFF002654))
                .constrainAs(azul) {
                    start.linkTo(parent.start)
                    end.linkTo(linea1)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
        Box(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(blanco) {
                    start.linkTo(linea1)
                    end.linkTo(linea2)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
        Box(
            modifier = Modifier
                .background(Color(0xFFED2939))
                .constrainAs(rojo) {
                    start.linkTo(linea2)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun previewBandera() {
    BanderaScreen(
        modifier = Modifier.fillMaxSize()
    )
}