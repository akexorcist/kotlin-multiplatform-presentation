package ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.snipme.highlights.Highlights
import dev.snipme.highlights.model.SyntaxLanguage
import dev.snipme.highlights.model.SyntaxThemes
import ui.component.CodeView
import ui.theme.BackgroundColor

@Composable
fun CodeWithCustomContent(
    code: String,
    fontSize: TextUnit = 48.sp,
    custom: @Composable () -> Unit,
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
    Row(
        modifier = Modifier.background(BackgroundColor.Code.color)
    ) {
        Box(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .padding(64.dp),
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
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight(),
        ) {
            custom()
        }
    }
}
