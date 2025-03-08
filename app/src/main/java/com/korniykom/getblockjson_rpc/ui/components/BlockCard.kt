package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BlockCard(
    signature: String = "",
    time: String = "",
    block: String = ""
) {
    Row {
        Text(signature)
        Text(time)
        Text(block)
    }
}