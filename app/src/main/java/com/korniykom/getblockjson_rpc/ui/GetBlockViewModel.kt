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

class GetBlockViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GetBlockUiState())
    val uiState: StateFlow<GetBlockUiState> = _uiState.asStateFlow()
    private val rpcRepository: RpcRepository = RpcRepository()
    private val updateTime: Long = 60_000
    private val blockListAmount = 3;

    init {
        fetchHighestSlot()
        fetchSupply()
        fetchEpoch()
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
                delay(updateTime)
            }
        }
    }
    private fun fetchEpoch() {
        viewModelScope.launch {
            while (true) {
                try {
                    val response = rpcRepository.getEpoch()
                    val epoch = response.result.epoch
                    val absoluteSlot = response.result.absoluteSlot
                    val slotIndex = response.result.slotIndex
                    val slotInEpoch = response.result.slotsInEpoch

                    val newSlotRangeStart = absoluteSlot - slotIndex
                    val newSlotRangeEnd = newSlotRangeStart + slotInEpoch - 1

                    _uiState.update { currentState ->
                        currentState.copy(
                            epoch = epoch,
                            slotRangeStart = newSlotRangeStart,
                            slotRangeEnd = newSlotRangeEnd,
                            timeRemain = calculateTimeRemain(newSlotRangeEnd, absoluteSlot)
                        )
                    }
                    fetchLastBlocks(_uiState.value.slotRangeStart,_uiState.value.slotRangeEnd, epoch)
                } catch (e: Exception) {
                    Log.e("RPC", "Error fetching epoch: ${e.message}")
                }
                delay(updateTime)
            }
        }
    }

    private fun fetchLastBlocks(startSlot: Long, endSlot: Long, epoch: Int) {
        viewModelScope.launch {
            while(true) {
                try {
                    val lastBlocks = rpcRepository.getBlocks(startSlot, endSlot).takeLast(blockListAmount)
                    val updatedListOfBlocks = lastBlocks.map { block ->
                        val blockInfo = rpcRepository.getBlock(block)
                        BlockModel(
                            time = blockInfo.result.blockTime,
                            block = block,
                            signature = blockInfo.result.blockhash,
                            epoch = epoch,
                            rewardLamports = blockInfo.result.rewards[0].lamports,
                            previousBlockHash = blockInfo.result.previousBlockhash
                        )
                    }
                    _uiState.update { currentState ->
                        currentState.copy(
                            listOfBlocks = updatedListOfBlocks
                        )
                    }
                } catch (e: Exception) {
                    Log.e("RPC", "Fetch last block error ${e.message}", e)
                }
                delay(updateTime)

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
    fun setCurrentBlock(block: BlockModel) {
        _uiState.update { currentState ->
            currentState.copy(
                currentBlock = block
            )
        }
    }
    private fun fetchHighestSlot() {
        viewModelScope.launch {
            while(true) {
                val highestSlot = rpcRepository.getHighestSlot()
                Log.d("RPC", "highestSlot $highestSlot")
                _uiState.update { currentState ->
                    currentState.copy(
                        highestSlot = highestSlot
                    )
                }
                delay(updateTime)
            }
        }
    }




}