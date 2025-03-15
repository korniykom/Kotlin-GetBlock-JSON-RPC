package com.korniykom.getblockjson_rpc.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SupplyResult(
    val context: Context,
    val value: Value
)

@Serializable
data class Context(
    val apiVersion: String,
    val slot: Long
)

@Serializable
data class Value(
    val circulating: Long,
    val nonCirculating: Long
)