package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.korniykom.getblockjson_rpc.ui.BlockModel
import com.korniykom.getblockjson_rpc.ui.theme.DarkGrey
import com.korniykom.getblockjson_rpc.ui.theme.ELEVATION_SMALL
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_MEDIUM
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_SMALL

@Composable
fun BlockList(
    modifier: Modifier = Modifier,
    blockList: List<BlockModel>,
    onBlockClicked: (BlockModel) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(PADDING_MEDIUM),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            ELEVATION_SMALL
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(PADDING_MEDIUM)
        ) {
            ListHeader()
            blockList.map { block ->
                Card(
                    modifier = modifier,
                    onClick = { onBlockClicked(block) },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    BlockElement(
                        signature = block.signature,
                        time = block.time,
                        block = block.block.toString(),
                    )
                }
            }
        }
    }
}

@Composable
fun ListHeader(
    modifier: Modifier = Modifier
) {
    Column {
        Row {
            Text(
                modifier = modifier
                    .weight(4.0f),
                text = "Signature",
                fontWeight = FontWeight.Bold,
                color = DarkGrey
            )
            Text(
                modifier = modifier
                    .weight(3.0f),
                text = "Time",
                fontWeight = FontWeight.Bold,
                color = DarkGrey
            )
            Text(
                modifier = modifier
                    .weight(3.0f),
                text = "Block",
                fontWeight = FontWeight.Bold,
                color = DarkGrey
            )
        }
        HorizontalDivider(
            modifier = modifier
                .padding(vertical = PADDING_SMALL)
                .fillMaxWidth()
        )
    }
}

