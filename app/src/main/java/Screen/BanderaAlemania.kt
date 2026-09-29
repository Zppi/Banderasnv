package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (negro, rojo, amarillo) = createRefs()

        val linea1 = createGuidelineFromStart(0.333f)
        val linea2 = createGuidelineFromStart(0.666f)

        Box(
            modifier = Modifier
                .background(Color.Black)
                .constrainAs(negro) {
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
                .background(Color.Red)
                .constrainAs(rojo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )


    }


}


@Preview
@Composable
fun BanderaPreview() {
    BanderaScreen(
        modifier = Modifier.fillMaxSize()
    )
}