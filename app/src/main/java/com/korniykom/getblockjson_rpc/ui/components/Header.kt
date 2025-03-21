package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.korniykom.getblockjson_rpc.ui.GetBlockViewModel
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_MEDIUM
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_SMALL

@Composable
fun Header(
    modifier: Modifier = Modifier,
    viewModel: GetBlockViewModel,
    onSearchClicked: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xffd43bd4),
                        Color(0xff3071ab),
                        Color(0xff00e8b5)
                    )
                )
            )
    ) {
        Column(modifier = modifier.padding(PADDING_MEDIUM)) {
            TopRow()
            SearchSection(
                viewModel = viewModel,
                onSearchClicked = onSearchClicked
            )
        }
    }
}

@Composable
fun TopRow(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = PADDING_SMALL),
    ) {
        LogoWord()
        LogoImage(
            modifier = modifier
                .size(60.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

