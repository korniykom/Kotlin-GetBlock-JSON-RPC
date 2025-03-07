package com.korniykom.getblockjson_rpc.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class RpcRequest(
    val jsonrpc: String,
    val method: String,
    val params: JsonArray,
    val id: String
)

@Serializable
data class RpcResponse<T>(
    val jsonrpc: String,
    val result: T,
    val id: String
)
