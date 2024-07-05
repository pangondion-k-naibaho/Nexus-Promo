package com.nexuspromo.client.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class Extension {
    companion object{
        @Composable
        fun TextWithIcon(input: String, iconResId: Int, modifier: Modifier) {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = "Icon",
                    tint = Color.Red // Warna ikon bisa disesuaikan atau dijadikan parameter tambahan
                )
                Spacer(modifier = Modifier.width(8.dp)) // Spacer for padding
                Text(text = input, color = Color.Black) // Contoh teks bisa diganti atau dijadikan parameter tambahan
            }
        }

        @Composable
        fun UrlImage(
            url: String,
            modifier: Modifier = Modifier,
            contentDescription: String? = null,
            contentScale: ContentScale = ContentScale.Fit
        ) {
            val painter: Painter = rememberImagePainter(data = url)

            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale
            )
        }
    }
}