package com.korniykom.getblockjson_rpc.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.korniykom.getblockjson_rpc.ui.GetBlockViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.korniykom.getblockjson_rpc.ui.components.BlockGrid
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_EXTRASMALL
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_LARGE
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_MEDIUM

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
            text = uiState.currentBlock.block.toString()
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
