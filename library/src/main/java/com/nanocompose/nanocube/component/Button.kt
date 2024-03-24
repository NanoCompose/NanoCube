package com.nanocompose.nanocube.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nanocompose.nanocube.helper.ThemePreviews
import com.nanocompose.nanocube.ui.theme.NanoCubeTheme
import com.nanocompose.nanocube.ui.theme.SelectedButtonBackground
import com.nanocompose.nanocube.ui.theme.SelectedColor
import com.nanocompose.nanocube.ui.theme.UnSelectedColor

@Composable
fun NanoCubeButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: String
) {
    Row (
        modifier = Modifier
            .padding(4.dp)
            .height(40.dp)
            .background(
                color = SelectedButtonBackground,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .clip(shape = RoundedCornerShape(size = 20.dp))
            .clickable {
                if (enabled) {
                    onClick()
                }
            }
        ,
        verticalAlignment = Alignment.CenterVertically
        ,

        ) {

        Text(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            text = text,
            color = if (enabled) {
                SelectedColor
            } else {
                UnSelectedColor
            },
        )
    }
}

@Composable
fun NanoCubeIconButton(
    icon: ImageVector,
    tint: Color,
    onClick: () -> Unit
) {
    Box(modifier = Modifier
        .padding(4.dp)

        .background(
            color = SelectedButtonBackground,
            shape = RoundedCornerShape(size = 4.dp)
        )
        .padding(4.dp)
        .clip(shape = RoundedCornerShape(size = 4.dp))
        .clickable {
            onClick()
        }
    ) {
        Image(
            imageVector = icon,
            contentDescription = null,
            colorFilter = ColorFilter.tint(tint)
        )
    }
}

@Preview
@Composable
fun ButtonPreview() {
    NanoCubeTheme {
        NanoCubeButton(
            onClick = {},
            text = "Custom Button Sample"
        )
    }
}

@ThemePreviews
@Composable
fun IconButtonPreview() {
    NanoCubeTheme {
        NanoCubeIconButton(
            Icons.Filled.Star,
            Color.Red
        ) {}
    }
}