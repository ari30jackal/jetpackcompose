package com.programtest.tryj.presentation.nav

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.programtest.tryj.presentation.app_navigator.AppNavigator
import com.programtest.tryj.presentation.home.HomeViewModel
import com.programtest.tryj.presentation.onboarding.OnBoardingViewModel
import com.programtest.tryj.presentation.onboarding.OnBoardingScreen

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.AppNavigation.route,
            startDestination = Route.AppNavigatorScreen.route
        ) {
            composable(route = Route.AppNavigatorScreen.route) {
                AppNavigator()
                val viewModel: HomeViewModel = hiltViewModel()
                viewModel.getPromoState()

            }
        }
    }
}