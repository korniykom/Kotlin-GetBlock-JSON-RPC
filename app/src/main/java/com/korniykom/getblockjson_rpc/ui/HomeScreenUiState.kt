package com.korniykom.getblockjson_rpc.ui

data class HomeScreenUiState(
    val epoch: Int = -1,
    val solSupply: Long = -1,
    val circulatingSupply: Long = -1,
    val nonCirculatingSupply: Long = -1
)