package com.korniykom.getblockjson_rpc.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.korniykom.getblockjson_rpc.ui.GetBlockViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    viewModel: GetBlockViewModel,
    onSearchClicked: () -> Unit = {}
    ) {
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(
            text = "Explore Solana Blockchain",
            style = MaterialTheme.typography.titleLarge,
        )
        SearchBar(
            modifier = modifier.fillMaxSize(),
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearch = {
                val slot = searchQuery.toLongOrNull()
                if(slot != null && slot in viewModel.uiState.value.slotRangeStart..viewModel.uiState.value.highestSlot) {
                    viewModel.fetchBlock(slot)
                    onSearchClicked()

                } else {
                    Toast.makeText(context, "Wrong input", Toast.LENGTH_LONG).show()
                }
            },
            active = false,
            onActiveChange = {},
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text("Search transactions, blocks, programs and tokens")
            }
        ) {}
    }
}
