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
                    val epoch = response.result.epoch
                    val absoluteSlot = response.result.absoluteSlot
                    val slotIndex = response.result.slotIndex
                    val slotInEpoch = response.result.slotsInEpoch
                    _uiState.update { currentState ->
                        currentState.copy(
                            epoch = epoch,
                            slotRangeStart = absoluteSlot - slotIndex,
                            slotRangeEnd = absoluteSlot - slotIndex + slotInEpoch - 1,
                            timeRemain = calculateTimeRemain(absoluteSlot - slotIndex + slotInEpoch - 1, absoluteSlot)
                        )
                    }
                } catch (e: Exception) {
                    Log.e("RPC", "Error fetching epoch: ${e.message}")
                }
                delay(60_000)
            }
        }
    }
    private fun calculateTimeRemain(endSLot: Long, currentSlot: Long): String {
        val remainingSlots = endSLot - currentSlot
        val remainingSeconds = (remainingSlots * 0.4).toLong()

        val days = remainingSeconds / (24 * 3600)
        val hours = (remainingSeconds % (24 * 3600)) / 3600
        val minutes = (remainingSeconds % 3600) / 60
        val seconds = remainingSeconds % 60

        return "${days}d ${hours}h ${minutes}m ${seconds}s"
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
                    Log.e("RPC", "Error fetching supply: ${e.message}")
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