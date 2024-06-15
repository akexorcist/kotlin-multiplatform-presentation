package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.ThemeColors

@Composable
fun SectionTitleTemplate(
    title: String,
    description: String?,
    tag: TagData,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor.GrayEvent.color)
            .padding(
                vertical = VerticalScreenPadding,
                horizontal = HorizontalScreenPadding,
            ),
    ) {
        EventLogo(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(y = (-48).dp)
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().weight(2f),
                contentAlignment = Alignment.BottomStart,
            ) {
                Tag(data = tag)
            }
            Spacer(modifier = Modifier.height(72.dp))
            Row(
                modifier = Modifier
                    .weight(5f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DoubleFrame(modifier = Modifier.weight(5f)) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                horizontal = 64.dp,
                                vertical = 48.dp,
                            ),
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = title,
                            fontSize = MaterialTheme.typography.h1.fontSize,
                            color = ThemeColors.TextPrimary,
                            fontStyle = MaterialTheme.typography.h1.fontStyle,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = MaterialTheme.typography.h1.letterSpacing,
                            lineHeight = MaterialTheme.typography.h1.lineHeight,
                        )

                        description?.let {
                            Spacer(modifier = Modifier.height(72.dp))
                            ContentText(text = description)
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }
    }
}
