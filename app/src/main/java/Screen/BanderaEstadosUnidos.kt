package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun banderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (franjas, cuadro) = createRefs()

        Column(
            modifier = Modifier.constrainAs(franjas) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            }
        ) {
            repeat(13) { i ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(if (i % 2 == 0) Color(0xFFB22234) else Color.White)
                )
            }
        }
        Box(
            modifier = Modifier
                .background(Color(0xFF3C3B6E))
                .constrainAs(cuadro) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    height = Dimension.percent(0.4f)
                    width = Dimension.percent(0.538f)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun showScreen() {
    banderaScreen(modifier = Modifier.fillMaxSize())
}