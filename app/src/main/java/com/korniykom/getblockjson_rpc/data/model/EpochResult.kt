package com.korniykom.getblockjson_rpc.data.model

import kotlinx.serialization.Serializable

@Serializable
data class EpochResult(
    val absoluteSlot: Long,
    val blockHeight: Long,
    val epoch: Int,
    val slotIndex: Int,
    val slotsInEpoch: Int,
    val transactionCount: Long
)
