package com.akexorcist.kotlin.multiplatform.ui.component.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.akexorcist.kotlin.multiplatform.ui.component.*
import com.akexorcist.kotlin.multiplatform.ui.theme.BackgroundColor

@Composable
fun MultipleIconContentTemplate(
    contents: List<Triple<String, String, @Composable () -> Unit>>,
    tag: TagData,
) {
    Row(
        modifier = Modifier.background(BackgroundColor.White.color),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(64.dp)
        ) {
            Tag(data = tag)
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                horizontalArrangement = Arrangement.Center,
            ) {
                contents.forEachIndexed { index, (subtitle, content, image) ->
                    Column(modifier = Modifier.width(420.dp)) {
                        image()
                        Spacer(modifier = Modifier.height(16.dp))
                        LargeContentText(
                            modifier = Modifier.wrapContentHeight(),
                            text = subtitle,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        ContentText(
                            modifier = Modifier.fillMaxWidth(),
                            text = content,
                        )
                    }
                    if (index != contents.lastIndex) {
                        Spacer(modifier = Modifier.width(96.dp))
                    }
                }
            }
        }
    }
}