package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import dev.snipme.highlights.Highlights
import dev.snipme.highlights.model.BoldHighlight
import dev.snipme.highlights.model.ColorHighlight

@Composable
fun CodeView(
    modifier: Modifier = Modifier,
    highlights: Highlights,
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            append(highlights.getCode())

            highlights.getHighlights()
                .filterIsInstance<ColorHighlight>()
                .forEach {
                    addStyle(
                        SpanStyle(color = Color(it.rgb).copy(alpha = 1f)),
                        start = it.location.start,
                        end = it.location.end,
                    )
                }

            highlights.getHighlights()
                .filterIsInstance<BoldHighlight>()
                .forEach {
                    addStyle(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = it.location.start,
                        end = it.location.end,
                    )
                }
        }
    )
}
