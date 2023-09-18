package com.programtest.tryj.presentation.nav

sealed class Route(val route:String){
    object OnBoardingScreen : Route(route = "onBoardingScreen")

    object HomeScreen : Route(route = "homeScreen")
    object DetailsScreen : Route(route = "detailsScreen")

    object AppStartNavigation : Route(route = "appStartNavigation")

    object AppNavigation : Route(route = "appNavigation")

    object AppNavigatorScreen : Route(route = "appNavigator")

    object ChartScreen: Route (route = "chartScreen")
    object BankingScreen:Route(route = "bankingScreen")
}
