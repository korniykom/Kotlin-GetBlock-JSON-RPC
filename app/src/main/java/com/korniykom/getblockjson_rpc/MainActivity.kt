package com.korniykom.getblockjson_rpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.korniykom.getblockjson_rpc.ui.GetBlockViewModel
import com.korniykom.getblockjson_rpc.ui.screens.BlockScreen
import com.korniykom.getblockjson_rpc.ui.screens.HomeScreen
import com.korniykom.getblockjson_rpc.ui.theme.GetBlockJSONRPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GetBlockJSONRPCTheme {
                GetBlockApp()
            }
        }
    }
}


enum class GetBlockScreen(@StringRes val title: Int) {
    HomeScreen(title = R.string.home_screen),
    BlockScreen(title = R.string.block_screen)
}

@Composable
fun GetBlockApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = GetBlockScreen.valueOf(
        backStackEntry?.destination?.route ?: GetBlockScreen.HomeScreen.name
    )
    val viewmodel:GetBlockViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = GetBlockScreen.HomeScreen.name
    ) {
        composable(route = GetBlockScreen.HomeScreen.name) {
            HomeScreen(
                homeViewModel = viewmodel,
                onBlockClicked = {
                    navController.navigate(GetBlockScreen.BlockScreen.name)
                    viewmodel.setCurrentBlock(it)
                },
                onSearchClicked = {
                    navController.navigate(GetBlockScreen.BlockScreen.name)
                }
            )
        }

        composable(route = GetBlockScreen.BlockScreen.name) {
            BlockScreen(viewModel = viewmodel)
        }
    }
}
