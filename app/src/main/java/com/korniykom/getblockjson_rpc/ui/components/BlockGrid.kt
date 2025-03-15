package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.korniykom.getblockjson_rpc.ui.BlockModel
import com.korniykom.getblockjson_rpc.ui.theme.DarkGrey


@Composable
fun BlockGrid(
    modifier: Modifier = Modifier,
    blockDetails: BlockModel
) {
    //API doesn't provide method to fetch SOL price, so it is what it is for now
    val solPrice = 100
    val calculatedReward = calculateReward(blockDetails.rewardLamports, solPrice = solPrice)
    val rewardSol = calculatedReward.first
    val rewardUsd = calculatedReward.second
    Column (modifier = modifier) {
        Row {
            Text(
                text = "Block",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = blockDetails.block.toString(),
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Timestamp",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = calculateTime(blockDetails.time),
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Block Hash",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = blockDetails.signature,
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Epoch",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = blockDetails.epoch.toString(),
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Reward",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = "$rewardSol ($${String.format("%.2f",rewardUsd)})",
                modifier = modifier
                    .weight(3.0f)
            )
        }
        Row {
            Text(
                text = "Previous Block Hash",
                color = DarkGrey,
                modifier = modifier
                    .weight(2.0f)
            )
            Text(
                text = blockDetails.previousBlockHash,
                modifier = modifier
                    .weight(3.0f)
            )
        }
    }
}

private fun calculateReward(lamports: Long, solPrice: Int): Pair<Double, Double> {
    val rewardSol = lamports / 1_000_000_000.0
    val rewardUsd = rewardSol * solPrice
    return Pair(rewardSol, rewardUsd)
}