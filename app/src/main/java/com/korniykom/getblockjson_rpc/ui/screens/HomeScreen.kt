package com.korniykom.getblockjson_rpc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.korniykom.getblockjson_rpc.ui.BlockModel
import com.korniykom.getblockjson_rpc.ui.GetBlockViewModel
import com.korniykom.getblockjson_rpc.ui.components.BlockList
import com.korniykom.getblockjson_rpc.ui.components.Header
import com.korniykom.getblockjson_rpc.ui.components.InfoCard
import com.korniykom.getblockjson_rpc.ui.theme.BackgroundColor

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: GetBlockViewModel = viewModel(),
    onBlockClicked: (BlockModel) -> Unit = {},
    onSearchClicked: () -> Unit = {}
) {
    val uiState by homeViewModel.uiState.collectAsState()
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        item {
            Header(
                viewModel = homeViewModel,
                onSearchClicked = onSearchClicked
            )
        }
        item {
            InfoCard(
                title = "SOL Supply",
                subTitle = uiState.solSupply.toString(),
                firstSectionTitle = "Circulating Supply",
                firstSectionSubtitle = "${uiState.circulatingSupply} (${String.format("%.1f", uiState.percentOfCirculatingSupply)})%",
                secondSectionTitle = "Non-circulating Supply",
                secondSectionSubtitle = "${uiState.nonCirculatingSupply} (${String.format("%.1f", uiState.percentOfNonCirculatingSupply)})%",
            )
        }
        item {
            InfoCard(
                title = "Current Epoch",
                subTitle = uiState.epoch.toString(),
                firstSectionTitle = "Slot Range",
                firstSectionSubtitle = "${uiState.slotRangeStart} to ${uiState.slotRangeEnd}",
                secondSectionTitle = "Time remain",
                secondSectionSubtitle = uiState.timeRemain.toString()
            )
        }
        item {
            BlockList(
                blockList = uiState.listOfBlocks,
                onBlockClicked = onBlockClicked
            )
        }
    }
}