package com.korniykom.getblockjson_rpc.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RpcRequest(
    val jsonrpc: String = "2.0",
    val method: String,
    val id: String = "getblock.io"
)

@Serializable
data class RpcResponse<T>(
    val jsonrpc: String,
    val result: T,
    val id: Int,
)

@Serializable
data class EpochResult(
    val absoluteSlot: Long,
    val blockHeight: Long,
    val epoch: Long,
    val slotIndex: Long,
    val slotsInEpoch: Long,
    val transactionCount: Long,
)