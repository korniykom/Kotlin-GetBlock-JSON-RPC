package com.korniykom.getblockjson_rpc.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.korniykom.getblockjson_rpc.R
import com.korniykom.getblockjson_rpc.ui.theme.GetBlockJSONRPCTheme

@Composable
fun LogoWord(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painterResource(R.drawable.solana_logo_word),
            contentDescription = "Solana Logo",
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun LogoWordPreview() {
    GetBlockJSONRPCTheme {
        LogoWord()
    }
}