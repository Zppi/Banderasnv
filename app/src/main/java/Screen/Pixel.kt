package Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val fondo = Color(0xFF1E1E2E)
val melena = Color(0xFF9C5A1A)
val melenaclara = Color(0xFFD08A2E)
val cara = Color(0xFFF2B866)
val boca = Color(0xFFFFE0A6)
val negro = Color(0xFF000000)
val blanco = Color(0xFFFFFFFF)
val nariz = Color(0xFFE57373)

@Composable
fun pixel(color:Color){
    Box(modifier = Modifier.size(20.dp).background(color))
}

@Composable
fun Leon(modifier: Modifier = Modifier){
    Column(modifier = modifier.background(fondo)) {

        Row{pixel(fondo); pixel(fondo); pixel(fondo); pixel(cara); pixel(cara); pixel(fondo); pixel(fondo); pixel(fondo); pixel(fondo); pixel(fondo);pixel(fondo);pixel(cara);pixel(cara);pixel(fondo);pixel(fondo);pixel(fondo) }
        Row{pixel(fondo); pixel(fondo); pixel(melena); pixel(cara); pixel(cara); pixel(melena); pixel(melena); pixel(melena); pixel(melena); pixel(melena);pixel(melena);pixel(cara);pixel(cara);pixel(melena);pixel(fondo);pixel(fondo)}
        Row{ pixel(fondo); pixel(melena); pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melena); pixel(melena); pixel(fondo) }
        Row{ pixel(melena); pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melena); pixel(melena) }
        Row{ pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(melenaclara); pixel(melenaclara); pixel(melena) }
        Row{ pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(cara); pixel(negro); pixel(blanco); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(blanco); pixel(negro); pixel(cara); pixel(melenaclara); pixel(melenaclara); pixel(melena) }
        Row{ pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(cara); pixel(negro); pixel(negro); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(negro); pixel(negro); pixel(cara); pixel(melenaclara); pixel(melenaclara); pixel(melena) }
        Row{ pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(cara); pixel(cara); pixel(cara); pixel(nariz); pixel(nariz); pixel(nariz); pixel(nariz); pixel(cara); pixel(cara); pixel(cara); pixel(melenaclara); pixel(melenaclara); pixel(melena) }
        Row{ pixel(melena); pixel(melena); pixel(melenaclara); pixel(cara); pixel(cara); pixel(boca); pixel(boca); pixel(negro); pixel(negro); pixel(boca); pixel(boca); pixel(cara); pixel(cara); pixel(melenaclara); pixel(melena); pixel(melena) }
        Row{ pixel(melena); pixel(melena); pixel(melenaclara); pixel(cara); pixel(boca); pixel(boca); pixel(negro); pixel(boca); pixel(boca); pixel(negro); pixel(boca); pixel(boca); pixel(cara); pixel(melenaclara); pixel(melena); pixel(melena) }
        Row{ pixel(fondo); pixel(melena); pixel(melena); pixel(melenaclara); pixel(cara); pixel(cara); pixel(boca); pixel(boca); pixel(boca); pixel(boca); pixel(cara); pixel(cara); pixel(melenaclara); pixel(melena); pixel(melena); pixel(fondo) }
        Row{ pixel(fondo); pixel(melena); pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(cara); pixel(cara); pixel(boca); pixel(boca); pixel(cara); pixel(cara); pixel(melenaclara); pixel(melenaclara); pixel(melena); pixel(melena); pixel(fondo) }
        Row{ pixel(fondo); pixel(fondo); pixel(melena); pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(cara); pixel(cara); pixel(cara); pixel(cara); pixel(melenaclara); pixel(melenaclara); pixel(melena); pixel(melena); pixel(fondo); pixel(fondo) }
        Row{ pixel(fondo); pixel(fondo); pixel(fondo); pixel(melena); pixel(melena); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melenaclara); pixel(melena); pixel(melena); pixel(fondo); pixel(fondo); pixel(fondo) }
        Row{ pixel(fondo); pixel(fondo); pixel(fondo); pixel(fondo); pixel(melena); pixel(melena); pixel(melena); pixel(melena); pixel(melena); pixel(melena); pixel(melena); pixel(melena); pixel(fondo); pixel(fondo); pixel(fondo); pixel(fondo) }

    }
}

@Preview
@Composable
fun showPixel(){
    Leon(modifier = Modifier)
}