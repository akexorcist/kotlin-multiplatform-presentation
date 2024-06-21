package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import dev.snipme.highlights.Highlights
import dev.snipme.highlights.model.SyntaxLanguage
import dev.snipme.highlights.model.SyntaxThemes
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.akexorcist.kotlin.multiplatform.ui.component.CodeView
import com.akexorcist.kotlin.multiplatform.ui.component.HorizontalScreenPadding
import com.akexorcist.kotlin.multiplatform.ui.component.VerticalScreenPadding
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor
import com.akexorcist.kotlin.multiplatform.ui.theme.scaled

@Composable
fun CodeTemplate(
    code: String,
    fontSize: TextUnit = 48.sp,
) {
    val highlights = remember {
        mutableStateOf(
            Highlights.Builder(
                code = code,
                language = SyntaxLanguage.KOTLIN,
                theme = SyntaxThemes.darcula(true),
            ).build()
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor.Code.color)
            .padding(
                vertical = VerticalScreenPadding.scaled(),
                horizontal = HorizontalScreenPadding.scaled(),
            ),
        contentAlignment = Alignment.CenterStart,
    ) {
        CompositionLocalProvider(
            values = arrayOf(
                LocalTextStyle provides TextStyle.Default.copy(
                    fontSize = fontSize,
                    color = Color(highlights.value.getTheme().code).copy(alpha = 1f),
                    fontWeight = FontWeight.Light,
                )
            )
        ) {
            CodeView(
                modifier = Modifier.fillMaxWidth(),
                highlights = highlights.value,
            )
        }
    }
}

@Preview
@Composable
fun CodeTemplatePreview() {
    MaterialTheme {
        CodeTemplate("fun main() {}")
    }
}
