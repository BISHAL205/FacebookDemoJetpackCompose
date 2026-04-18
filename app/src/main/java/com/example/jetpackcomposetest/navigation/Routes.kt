package com.example.jetpackcomposetest.navigation

sealed class Routes(val route: String) {
    object Splash  : Routes("splash")
    object Login   : Routes("login")
    object Home    : Routes("home")

    sealed class Tab(route: String) : Routes(route) {
        object Feed     : Tab("tab/feed")
        object Friends  : Tab("tab/friends")
        object Watch    : Tab("tab/watch")
        object Notify   : Tab("tab/notify")
        object Menu     : Tab("tab/menu")
    }

}