package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
        Text(
            text = "Explore Solana Blockchain",
            style = MaterialTheme.typography.titleLarge,
        )
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text("Search transactions, blocks, programs and tokens")
            }
        ) {}
    }
}
