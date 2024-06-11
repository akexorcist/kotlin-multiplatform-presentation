package com.akexorcist.kotlin.multiplatform.ui.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.akexorcist.kotlin.multiplatform.ui.theme.TextColor

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.SemiBold,
    alignment: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.h2.fontSize,
        color = TextColor.Default.color,
        fontStyle = MaterialTheme.typography.h2.fontStyle,
        fontWeight = fontWeight,
        letterSpacing = MaterialTheme.typography.h2.letterSpacing,
        lineHeight = MaterialTheme.typography.h2.lineHeight,
        textAlign = alignment,
    )
}

@Composable
fun LargeContentText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    alignment: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.h3.fontSize,
        color = TextColor.Default.color,
        fontStyle = MaterialTheme.typography.h3.fontStyle,
        fontWeight = fontWeight,
        letterSpacing = MaterialTheme.typography.h3.letterSpacing,
        lineHeight = MaterialTheme.typography.h3.lineHeight,
        textAlign = alignment,
    )
}

@Composable
fun ContentText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    alignment: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.h4.fontSize,
        color = TextColor.Default.color,
        fontStyle = MaterialTheme.typography.h4.fontStyle,
        fontWeight = fontWeight,
        letterSpacing = MaterialTheme.typography.h4.letterSpacing,
        lineHeight = MaterialTheme.typography.h4.lineHeight,
        textAlign = alignment,
    )
}

@Composable
fun SmallContentText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    alignment: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = MaterialTheme.typography.h5.fontSize,
        color = TextColor.Default.color,
        fontStyle = MaterialTheme.typography.h5.fontStyle,
        fontWeight = fontWeight,
        letterSpacing = MaterialTheme.typography.h5.letterSpacing,
        lineHeight = 32.sp,
        textAlign = alignment,
    )
}

@Composable
fun HighlightText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.SemiBold,
    alignment: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 240.sp,
        color = TextColor.Blue.color,
        fontStyle = MaterialTheme.typography.h1.fontStyle,
        fontWeight = fontWeight,
        letterSpacing = (-2).sp,
        lineHeight = 260.sp,
        textAlign = alignment,
    )
}