package com.korniykom.getblockjson_rpc.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class BlockResult(
    val blockHeight: Long,
    val blockTime: Long,
    val blockhash: String,
//    val parentSlot: Long,
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
//    val meta: TransactionMeta,
    val transaction: TransactionDetails,
//    val version: String?
)
@Serializable
data class TransactionMeta(
    val computeUnitsConsumed: Long,
    val err: String?,
    val fee: Long,
    val innerInstructions: List<String>,
    val loadedAddresses: LoadedAddresses,
    val logMessages: List<String>,
    val postBalances: List<Long>,
    val preBalances: List<Long>,
    val postTokenBalances: List<Long>,
    val preTokenBalances: List<Long>,
    val rewards: List<String>,
    val status: Status
)
@Serializable
data class LoadedAddresses(
    val readonly: List<String>,
    val writable: List<String>
)
@Serializable
data class TransactionDetails(
    val message: Message,
    val signatures: List<String>
)
@Serializable
data class Status(
    val Ok: String?
)
@Serializable
data class Message(
//    val accountKeys: List<String>,
//    val header: MessageHeader,
//    val instructions: List<Instruction>,
    val recentBlockhash: String,
//    val addressTableLookups: List<String>
)
@Serializable
data class MessageHeader(
    val numReadonlySignedAccounts: Int,
    val numReadonlyUnsignedAccounts: Int,
    val numRequiredSignatures: Int
)
@Serializable
data class Instruction(
    val accounts: List<Int>,
    val data: String,
    val programIdIndex: Int,
    val stackHeight: Int?
)