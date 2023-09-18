package com.programtest.tryj.presentation.app_navigator

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.programtest.tryj.R
import com.programtest.tryj.domain.model.promo.PromosItem
import com.programtest.tryj.presentation.app_navigator.components.AppBottomNavigation
import com.programtest.tryj.presentation.app_navigator.components.BottomNavigationItem
import com.programtest.tryj.presentation.banking.BankingScreen
import com.programtest.tryj.presentation.chart.ChartScreen
import com.programtest.tryj.presentation.details.DetailsScreen
import com.programtest.tryj.presentation.home.HomeScreen
import com.programtest.tryj.presentation.home.HomeViewModel
import com.programtest.tryj.presentation.nav.Route


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.ChartScreen.route -> 1
        Route.HomeScreen.route -> 2
        else -> 0
    }

    //Hide the bottom navigation when the user is in the details screen
    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.route ||
                backStackState?.destination?.route == Route.ChartScreen.route ||
                backStackState?.destination?.route == Route.HomeScreen.route
    }


    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        if (isBottomBarVisible) {
            AppBottomNavigation(
                items = bottomNavigationItems,
                selectedItem = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Route.HomeScreen.route
                        )

                        1 -> navigateToTab(
                            navController = navController,
                            route = Route.ChartScreen.route
                        )

                        2 -> navigateToTab(
                            navController = navController,
                            route = Route.BankingScreen.route
                        )
                    }
                }
            )
        }
    }) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) { backStackEntry ->
                val viewModel: HomeViewModel = hiltViewModel()
                viewModel.getPromoState()
                val promos = viewModel.state.value.promoList
                Log.d("promohlist", "awww" + viewModel.res.toString())
                Log.d("promohlist", "hei" + promos.toString())
//                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    promos = promos,
                    navigateToDetails = { promos ->
                        navigateToDetails(
                            navController = navController,
                            promos = promos
                        )
                    }
                )
            }
            composable(route = Route.ChartScreen.route) { backStackEntry ->
                ChartScreen()
            }
            composable(route = Route.BankingScreen.route){backStackEntry ->
                BankingScreen()
            }
            composable(route = Route.DetailsScreen.route) {
                navController.previousBackStackEntry?.savedStateHandle?.get<PromosItem?>("id")
                    ?.let { promos ->
                        DetailsScreen(
                            promo = promos,
                            event = {},
                            navigateUp = { navController.navigateUp() }
                        )
                    }

            }
        }
    }
}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.HomeScreen.route
        )
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}

private fun navigateToDetails(navController: NavController, promos: PromosItem) {
    navController.currentBackStackEntry?.savedStateHandle?.set("id", promos)
    navController.navigate(
        route = Route.DetailsScreen.route
    )
}

