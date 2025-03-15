package com.korniykom.getblockjson_rpc.ui

data class GetBlockUiState(
    val epoch: Int = -1,
    val slotRangeStart: Long = -1,
    val slotRangeEnd: Long = -1,
    val timeRemain: String = "Near to infinity",
    val solSupply: Long = -1,
    val circulatingSupply: Long = -1,
    val percentOfCirculatingSupply: Double = 0.0,
    val nonCirculatingSupply: Long = -1,
    val percentOfNonCirculatingSupply: Double = 0.0,
    val listOfBlocks: List<BlockModel> = listOf(),
    val currentBlock: BlockModel = BlockModel(
        block = -1,
        signature = "gibrish",
        time = -1,
        epoch = -1,
        rewardLamports = -1,
        previousBlockHash = "Non existent"
    ),
    val highestSlot: Long = 0
    )