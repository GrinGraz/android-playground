package com.example.androidplayground.designsystem.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

enum class TextStyleType {
    HEADLINE_LARGE,
    HEADLINE_MEDIUM,
    TITLE_LARGE,
    TITLE_MEDIUM,
    BODY_LARGE,
    BODY_MEDIUM,
    LABEL_LARGE,
    LABEL_MEDIUM,
    LABEL_SMALL
}

@Composable
fun StyledText(
    text: String,
    type: TextStyleType,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign? = null
) {
    val style = when (type) {
        TextStyleType.HEADLINE_LARGE -> MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold
        )
        TextStyleType.HEADLINE_MEDIUM -> MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold
        )
        TextStyleType.TITLE_LARGE -> MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold
        )
        TextStyleType.TITLE_MEDIUM -> MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        TextStyleType.BODY_LARGE -> MaterialTheme.typography.bodyLarge.copy(
            fontSize = 16.sp
        )
        TextStyleType.BODY_MEDIUM -> MaterialTheme.typography.bodyMedium
        TextStyleType.LABEL_LARGE -> MaterialTheme.typography.labelLarge.copy(
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp
        )
        TextStyleType.LABEL_MEDIUM -> MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
        TextStyleType.LABEL_SMALL -> MaterialTheme.typography.labelSmall.copy(
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp
        )
    }

    val finalColor = if (color == Color.Unspecified) {
        when (type) {
            TextStyleType.HEADLINE_LARGE,
            TextStyleType.HEADLINE_MEDIUM,
            TextStyleType.TITLE_LARGE -> MaterialTheme.colorScheme.onSurface

            TextStyleType.BODY_MEDIUM -> MaterialTheme.colorScheme.onSurfaceVariant

            else -> MaterialTheme.colorScheme.onSurface
        }
    } else {
        color
    }

    Text(
        text = text,
        style = style,
        color = finalColor,
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Preview
@Composable
fun Preview() {
    StyledText(
        text = "Texto",
        type = TextStyleType.BODY_MEDIUM,
        modifier = Modifier,
        maxLines = 3,
    )
}