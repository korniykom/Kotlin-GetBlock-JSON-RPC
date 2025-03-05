package com.korniykom.getblockjson_rpc.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.korniykom.getblockjson_rpc.ui.components.Card
import com.korniykom.getblockjson_rpc.ui.components.Header
import com.korniykom.getblockjson_rpc.ui.theme.BackgroundColor

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        item {
            Header()
        }
        item {
            Card(title = "SOL Supply")
        }
        item {
            Card(title = "Current Epoch")
        }
    }
}