package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.korniykom.getblockjson_rpc.ui.theme.LinkBlue
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_EXTRASMALL
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_SMALL

@Composable
fun BlockElement(
    modifier: Modifier = Modifier,
    signature: String = "2gQG1kCadycTErPRUvnYuWWihx6RE3QTAjuovciYAoiU8DGsDhPLYJLgXwaGMbhJgz5moAPA7E4NZUZJguAMwtJq\n",
    time: Long = -1,
    block: String = "325884797"
) {
    Row(
        modifier = modifier
            .padding(bottom = PADDING_SMALL)
    ) {
        Text(
            modifier = modifier
                .weight(4.0f),
            text = signature,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
            color = LinkBlue,
            )
        Text(
            modifier = modifier
                .weight(3.0f),
            text = calculateTime(time),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )
        Text(
            modifier = modifier
                .weight(3f),
            text = block,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
            color = LinkBlue,
        )
    }
}

fun calculateTime(givenTime: Long): String {
    val currentTime = System.currentTimeMillis() / 1000
    val timeDifference = currentTime - givenTime
    return when {
        timeDifference < 60 -> "$timeDifference seconds ago"
        timeDifference < 3600 -> "${timeDifference / 60} minutes ago"
        timeDifference < 86400 -> "${timeDifference / 3600} hours ago"
        else -> "A long time ago..."
    }
}