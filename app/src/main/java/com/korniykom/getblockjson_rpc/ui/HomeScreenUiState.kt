package com.korniykom.getblockjson_rpc.ui

data class HomeScreenUiState(
    val epoch: Int = -1,
    val slotRangeStart: Long = -1,
    val slotRangeEnd: Long = -1,
    val solSupply: Long = -1,
    val circulatingSupply: Long = -1,
    val percentOfCirculatingSupply: Double = 0.0,
    val nonCirculatingSupply: Long = -1,
    val percentOfNonCirculatingSupply: Double = 0.0,
    )