package Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
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
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (rojo, amarillo, rojo1, escudo) = createRefs()

        val linea1 = createGuidelineFromTop(0.333f)
        val linea2 = createGuidelineFromTop(0.666f)


        Box(
            modifier = modifier
                .background(Color(0xFFAA151B))
                .constrainAs(rojo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(linea1)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
        Box(
            modifier = modifier
                .background(Color(0xFFF1BF00))
                .constrainAs(amarillo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea1)
                    bottom.linkTo(linea2)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
        Box(
            modifier = modifier
                .background(Color(0xFFAA151B))
                .constrainAs(rojo1) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(linea2)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
        Image(
            painter = painterResource(id = R.drawable.escudo_espana),
            contentDescription = "escudo de espana",
            modifier = Modifier.constrainAs(escudo) {
                start.linkTo(parent.start, margin = 24.dp)
                top.linkTo(linea1)
                bottom.linkTo(linea2)
            }
                .size(140.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun showScreen() {
    BanderaScreen(modifier = Modifier.fillMaxSize())
}