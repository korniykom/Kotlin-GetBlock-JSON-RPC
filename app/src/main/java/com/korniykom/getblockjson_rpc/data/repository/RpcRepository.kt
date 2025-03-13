package com.korniykom.getblockjson_rpc.data.repository

import android.util.Log
import com.korniykom.getblockjson_rpc.data.model.BlockResult
import com.korniykom.getblockjson_rpc.data.model.EpochResult
import com.korniykom.getblockjson_rpc.data.model.RpcRequest
import com.korniykom.getblockjson_rpc.data.model.RpcResponse
import com.korniykom.getblockjson_rpc.data.model.SupplyResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

class RpcRepository {
    companion object {
        private const val URL = "https://go.getblock.io/461017ec75194b34a7b1436e4270aae0"
    }
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = Logger.DEFAULT
        }
    }
    suspend fun getEpoch(): RpcResponse<EpochResult> {
        val requestBody = RpcRequest(
            method = "getEpochInfo",
            id = "getblock.io",
            jsonrpc = "2.0"
        )
        val response = client.post(URL) {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }.body<RpcResponse<EpochResult>>()
        return response
    }
    suspend fun getSupply(): RpcResponse<SupplyResult> {
        val requestBody = RpcRequest(
            method = "getSupply",
            id = "getblock.io",
            jsonrpc = "2.0"
        )
        val response = client.post(URL) {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }.body<RpcResponse<SupplyResult>>()
        return response
    }
    suspend fun getBlock(blockNumber:Long) : RpcResponse<BlockResult> {
        val requestBody = RpcRequest(
            method = "getBlock",
            id = "getblock.io",
            jsonrpc = "2.0",
            params = listOf(Json.encodeToJsonElement(blockNumber) , Json.encodeToJsonElement(mapOf("maxSupportedTransactionVersion" to 0)))
        )
        Log.d("RPC", "requestbody : $requestBody")
        val response = client.post(URL) {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }.body<RpcResponse<BlockResult>>()
        Log.d("RPC", "get block response $response")
        return response
    }
    suspend fun getBlocks(startSlot: Long, endSlot:Long? = null): List<Long> {
        val requestBody = RpcRequest(
            method = "getBlocks",
            id = "getblock.io",
            jsonrpc = "2.0",
            params = listOf(Json.encodeToJsonElement(startSlot), Json.encodeToJsonElement(endSlot))
        )
        val response = client.post(URL) {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }.body<RpcResponse<List<Long>>>()
        return response.result
    }
    suspend fun getHighestSlot(): Long {
        val requestBody = RpcRequest(
            method = "getSlot",
            id = "getblock.io",
            jsonrpc = "2.0",
        )
        val response = client.post(URL) {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }.body<RpcResponse<Long>>()
        return response.result
    }
}
