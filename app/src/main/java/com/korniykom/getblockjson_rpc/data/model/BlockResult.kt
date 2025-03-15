package com.korniykom.getblockjson_rpc.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BlockResult(
    val blockHeight: Long,
    val blockTime: Long,
    val blockhash: String,
    val previousBlockhash: String,
    val rewards: List<Reward>,
    val transactions: List<Transaction>
)

@Serializable
data class Reward(
    val commission: Long?,
    val lamports: Long,
    val postBalance: Long,
    val pubkey: String,
    val rewardType: String
)

@Serializable
data class Transaction(
    val transaction: TransactionDetails,
)

@Serializable
data class TransactionDetails(
    val message: Message,
    val signatures: List<String>
)

@Serializable
data class Message(
    val recentBlockhash: String,
)