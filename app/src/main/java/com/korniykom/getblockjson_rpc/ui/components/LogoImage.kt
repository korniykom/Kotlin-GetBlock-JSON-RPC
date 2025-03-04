package com.korniykom.getblockjson_rpc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.korniykom.getblockjson_rpc.R
import com.korniykom.getblockjson_rpc.ui.theme.GetBlockJSONRPCTheme

@Composable
fun LogoImage(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xffeaeaea))
    ) {
        Image(
            painter = painterResource(R.drawable.solana_sol_logo),
            contentDescription = "Solana logo",
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun LogoImagePreview() {
    GetBlockJSONRPCTheme {
        LogoImage()
    }
}