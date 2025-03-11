package com.korniykom.getblockjson_rpc.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.korniykom.getblockjson_rpc.R
import com.korniykom.getblockjson_rpc.ui.BlockModel
import com.korniykom.getblockjson_rpc.ui.GetBlockViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.korniykom.getblockjson_rpc.ui.components.calculateTime
import com.korniykom.getblockjson_rpc.ui.theme.DarkGrey
import com.korniykom.getblockjson_rpc.ui.theme.Grey
import com.korniykom.getblockjson_rpc.ui.theme.LightGrey
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_EXTRASMALL
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_LARGE
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_MEDIUM
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_SMALL

@Composable
fun BlockScreen(
    modifier: Modifier = Modifier,
    viewModel: GetBlockViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = modifier
            .padding(PADDING_MEDIUM)
    ) {
        Text(
            modifier = modifier
                .padding(vertical = PADDING_LARGE),
            text = "Block Details",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            fontSize = 28.sp
        )
        Text(
            modifier = modifier
                .padding(bottom = PADDING_LARGE),
            text = uiState.currentBlock.signature
        )
        Text(
            modifier = modifier
                .padding(PADDING_EXTRASMALL),
            text = "Overview",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        BlockGrid(
            modifier = modifier
                .fillMaxWidth()
                .padding(PADDING_EXTRASMALL),
            blockDetails = uiState.currentBlock
        )
    }
}

@Composable
fun BlockGrid(
    modifier: Modifier = Modifier,
    blockDetails: BlockModel
) {
    Column (modifier = modifier) {
        Row {
            Text(
                text = "Block",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = blockDetails.block.toString(),
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Timestamp",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = calculateTime(blockDetails.time),
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = blockDetails.signature,
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = ";lkasdhjfkujsagdfiuhasdiufnaisudfiuhasdfiuogashdf",
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Epoch",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = "123",
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Leader",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = "Whatever whenever whoever",
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Reward",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = "0.000636 ($5.783)",
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Transactions",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = "Total 2.5325 transactions",
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Previous Block Hash",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = "032978465iou234hgiusrt 9-87345",
                modifier = modifier
                    .weight(3.0f)
            )
        }
    }
}

