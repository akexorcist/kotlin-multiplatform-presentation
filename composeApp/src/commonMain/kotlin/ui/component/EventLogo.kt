package ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.ic_event_logo
import org.jetbrains.compose.resources.vectorResource
import ui.theme.ContentColor

@Composable
fun EventLogo(
    width: Dp = 200.dp,
    tintColor: ContentColor? = null,
) {
    Image(
        modifier = Modifier.width(width),
        imageVector = vectorResource(Res.drawable.ic_event_logo),
        contentDescription = "Event logo",
        colorFilter = tintColor?.let { ColorFilter.tint(it.color, blendMode = BlendMode.SrcIn) }
    )
}
