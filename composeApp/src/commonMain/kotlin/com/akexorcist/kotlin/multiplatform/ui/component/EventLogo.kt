package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.akexorcist.kotlin.multiplatform.ui.theme.ThemeColors
import com.akexorcist.kotlin.multiplatform.ui.theme.scaledDp
import kotlinmultiplatform.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.vectorResource
import kotlinmultiplatform.composeapp.generated.resources.ic_event_logo_black
import kotlinmultiplatform.composeapp.generated.resources.ic_event_logo_white

enum class EventLogoColor {
    Black, White,
}

@Composable
fun EventLogo(
    modifier: Modifier = Modifier,
    color: EventLogoColor = EventLogoColor.Black,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.width(300.scaledDp()),
            imageVector = vectorResource(
                when (color) {
                    EventLogoColor.Black -> Res.drawable.ic_event_logo_black
                    EventLogoColor.White -> Res.drawable.ic_event_logo_white
                }
            ),
            contentDescription = "Event logo",
        )
        Text(
            text = "Bangkok",
            fontSize = MaterialTheme.typography.body1.fontSize,
            color = ThemeColors.TextPrimary,
            fontStyle = MaterialTheme.typography.body1.fontStyle,
            fontWeight = FontWeight.Medium,
            letterSpacing = MaterialTheme.typography.body1.letterSpacing,
            lineHeight = MaterialTheme.typography.body1.lineHeight,
        )
    }
}
