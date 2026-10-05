package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(Color(0xFFD52B1E))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.20f)
                .fillMaxHeight(0.60f)
                .background(Color.White)
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.20f)
                .fillMaxWidth(0.60f)
                .background(Color.White)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun showScreen() {
    BanderaScreen(modifier = Modifier.fillMaxSize())
}