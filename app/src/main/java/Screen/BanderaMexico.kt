package Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderasnv.R

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (caja, caja1, caja2) = createRefs()

        val lineaguia = createGuidelineFromStart(0.3f)
        val linea1 = createGuidelineFromStart(0.7f)


        Box(
            modifier = Modifier
                .background(Color.Green)
                .constrainAs(caja) {
                    start.linkTo(parent.start)
                    end.linkTo(lineaguia)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                })

        ConstraintLayout(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(caja1) {
                    start.linkTo(lineaguia)
                    end.linkTo(linea1)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints


                }) {
            val escudo = createRef()

            Image(
                painter = painterResource(id = R.drawable.escudo_mexico),
                contentDescription = "foto del escudo mexicano",
                modifier = Modifier.constrainAs(escudo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
        Box(
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(caja2) {
                    start.linkTo(linea1)
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
fun ShowScreen() {
    BanderaScreen(modifier = Modifier.fillMaxSize())
}

