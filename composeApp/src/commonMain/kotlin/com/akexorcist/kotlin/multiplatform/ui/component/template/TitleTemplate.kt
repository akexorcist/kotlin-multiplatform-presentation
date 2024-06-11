package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.component.DefaultScreenPadding
import com.akexorcist.kotlin.multiplatform.ui.component.EventLogo
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.ThemeColors
import kotlinmultiplatform.composeapp.generated.resources.Res
import kotlinmultiplatform.composeapp.generated.resources.background_decoration
import org.jetbrains.compose.resources.painterResource

@Composable
fun TitleTemplate(
    title: String,
    name: String,
    position: String,
) {
    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor.GrayEvent.color)
                .padding(DefaultScreenPadding)
        ) {
            EventLogo()
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.weight(3f),
                        text = title,
                        fontSize = MaterialTheme.typography.h1.fontSize,
                        color = ThemeColors.TextPrimary,
                        fontStyle = MaterialTheme.typography.h1.fontStyle,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = MaterialTheme.typography.h1.letterSpacing,
                        lineHeight = MaterialTheme.typography.h1.lineHeight,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(72.dp))
                Text(
                    modifier = Modifier.offset(x = 4.dp),
                    text = name,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    color = ThemeColors.TextPrimary,
                    fontStyle = MaterialTheme.typography.h4.fontStyle,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = MaterialTheme.typography.h4.letterSpacing,
                    lineHeight = MaterialTheme.typography.h4.lineHeight,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier.offset(x = 4.dp),
                    text = position,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    color = ThemeColors.TextPrimary,
                    fontStyle = MaterialTheme.typography.h4.fontStyle,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = MaterialTheme.typography.h4.letterSpacing,
                    lineHeight = MaterialTheme.typography.h4.lineHeight,
                )
            }
        }
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .align(Alignment.CenterEnd),
            painter = painterResource(Res.drawable.background_decoration),
            contentDescription = "background_decoration",
            contentScale = ContentScale.FillHeight,
        )
    }
}
