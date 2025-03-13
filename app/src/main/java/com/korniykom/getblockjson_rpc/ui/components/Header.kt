package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.korniykom.getblockjson_rpc.ui.theme.GetBlockJSONRPCTheme
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_LARGE
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_MEDIUM
import com.korniykom.getblockjson_rpc.ui.theme.PADDING_SMALL

@Composable
fun Header(modifier: Modifier = Modifier) {
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
            SearchSection()
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

