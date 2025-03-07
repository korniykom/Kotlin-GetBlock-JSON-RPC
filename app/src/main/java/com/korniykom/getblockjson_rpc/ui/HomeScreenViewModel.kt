package com.korniykom.getblockjson_rpc.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korniykom.getblockjson_rpc.data.repository.RpcRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
    private val rpcRepository: RpcRepository = RpcRepository()

    private fun fetchEpoch() {
        viewModelScope.launch {
            while(true) {
                try {
                    val response = rpcRepository.getEpoch()
                    _uiState.update { currentState ->
                        currentState.copy(
                            epoch = response.result.epoch,
                            slotRangeStart = response.result.absoluteSlot - response.result.slotIndex,
                            slotRangeEnd = response.result.absoluteSlot - response.result.slotIndex + response.result.slotsInEpoch - 1
                        )
                    }
                } catch (e: Exception) {
                    Log.e("RPC", "Error fetching epoch: ${e.message}")
                }
                delay(60_000)
            }
        }
    }
    private fun fetchSupply() {
        viewModelScope.launch {
            while(true) {
                try {
                    val response = rpcRepository.getSupply()
                    val circulating = response.result.value.circulating
                    val nonCirculating = response.result.value.nonCirculating
                    val total = circulating + nonCirculating
                    _uiState.update { currentState ->
                        currentState.copy(
                            solSupply = response.result.value.circulating + response.result.value.nonCirculating,
                            circulatingSupply = circulating,
                            nonCirculatingSupply = nonCirculating,
                            percentOfCirculatingSupply = ((circulating.toDouble() / total) * 100),
                            percentOfNonCirculatingSupply = ((nonCirculating.toDouble() / total) * 100)

                        )
                    }
                } catch (e: Exception) {
                    Log.e("RPC", "Error fetching epoch: ${e.message}")
                }
                delay(60_000)
            }
        }
    }
    init {
        fetchEpoch()
        fetchSupply()
    }
}