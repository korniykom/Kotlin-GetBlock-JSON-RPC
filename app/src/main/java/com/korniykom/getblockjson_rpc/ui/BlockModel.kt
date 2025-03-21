package com.korniykom.getblockjson_rpc.ui

data class BlockModel(
    val block: Long,
    val signature: String,
    val time: Long,
    val epoch: Int,
    val rewardLamports: Long,
    val previousBlockHash: String
)

