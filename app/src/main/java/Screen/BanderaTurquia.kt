package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex


@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE30A17))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 5.dp)
                .size(210.dp)
                .clip(CircleShape)
                .background(Color.White)
        )

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 38.dp)
                .size(200.dp)
                .clip(CircleShape)
                .background(Color(0xFFE30A17))
        )

        Text(
            text = "\u2B50",
            fontSize = 60.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart).padding(start = 220.dp)
        )
    }


}


@Preview(showBackground = true)
@Composable
fun showScreen() {
    BanderaScreen(modifier = Modifier.fillMaxSize())
}