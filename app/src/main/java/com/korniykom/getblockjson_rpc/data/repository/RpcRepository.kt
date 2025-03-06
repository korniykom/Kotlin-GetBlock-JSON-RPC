package com.korniykom.getblockjson_rpc.data.repository

import android.util.Log
import com.korniykom.getblockjson_rpc.data.model.EpochResult
import com.korniykom.getblockjson_rpc.data.model.RpcRequest
import com.korniykom.getblockjson_rpc.data.model.RpcResponse
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

class RpcRepository {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json)
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = Logger.DEFAULT
        }
    }

    suspend fun getEpoch(): RpcResponse<EpochResult> {
        val response = client.post("https://go.getblock.io/461017ec75194b34a7b1436e4270aae0") {
            contentType(ContentType.Application.Json)
            setBody(RpcRequest(method = "getEpochInfo"))
        }.body<RpcResponse<EpochResult>>()

        Log.d("RPC", "Response: $response")

        return response
    }
}

