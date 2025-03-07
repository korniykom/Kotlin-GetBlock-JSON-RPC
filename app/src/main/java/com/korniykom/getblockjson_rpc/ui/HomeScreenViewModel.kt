package com.korniykom.getblockjson_rpc.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korniykom.getblockjson_rpc.data.repository.RpcRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()
    private val rpcRepository: RpcRepository = RpcRepository()

    fun fetchEpoch() {
        viewModelScope.launch {
            try {
                val response = rpcRepository.getEpoch()
                _uiState.update { currentState ->
                    currentState.copy(
                        epoch = response.result.epoch
                    )
                }
            } catch (e: Exception) {
                Log.e("RPC", "Error fetching epoch: ${e.message}")
            }
        }
    }
    fun fetchSupply() {
        viewModelScope.launch {
            try {
                val response = rpcRepository.getSupply()
                _uiState.update { currentState ->
                    currentState.copy(
                        solSupply = response.result.value.circulating + response.result.value.nonCirculating,
                        circulatingSupply = response.result.value.circulating,
                        nonCirculatingSupply = response.result.value.nonCirculating
                    )
                }
            } catch (e: Exception) {
                Log.e("RPC", "Error fetching epoch: ${e.message}")
            }
        }
    }
    init {
        fetchEpoch()
        fetchSupply()
    }
}