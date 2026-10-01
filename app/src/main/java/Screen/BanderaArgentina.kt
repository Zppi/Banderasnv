package Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.packFloats
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderasnv.R


@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {

        val (abiceleste, blanco, abiceleste1, sol) = createRefs()

        val linea1 = createGuidelineFromTop(0.333f)
        val linea2 = createGuidelineFromTop(0.666f)

        Box(
            modifier = Modifier
                .background(Color(0xFF74ACDF))
                .constrainAs(abiceleste) {
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
                .background(Color.White)
                .constrainAs(blanco) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea1)
                    bottom.linkTo(linea2)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier
                .background(Color(0xFF74ACDF))
                .constrainAs(abiceleste1) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea2)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
        Image(
            painter = painterResource(id = R.drawable.argentina_escudo),
            contentDescription = "escudo de argentina",
            modifier = Modifier.constrainAs(sol){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
                .size(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowScreen(modifier: Modifier = Modifier) {
    BanderaScreen(modifier = Modifier.fillMaxSize())
}