package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DontMemoize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

val RomboShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
    close()
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (fondo, rombo, circulo) = createRefs()

        Box(
            modifier = Modifier
                .background(Color(0xFF009C3B))
                .constrainAs(fondo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .clip(RomboShape)
                .background(Color(0xFFFFDF00))
                .constrainAs(rombo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.percent(0.55f)
                    width = Dimension.percent(0.75f)
                }
        )

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFF002776))
                .constrainAs(circulo) {
                    start.linkTo(rombo.start)
                    end.linkTo(rombo.end)
                    top.linkTo(rombo.top)
                    bottom.linkTo(rombo.bottom)
                    height = Dimension.percent(0.20f)
                    width = Dimension.percent(0.40f)
                }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun showScreen() {
    BanderaScreen(modifier = Modifier.fillMaxSize())
}
