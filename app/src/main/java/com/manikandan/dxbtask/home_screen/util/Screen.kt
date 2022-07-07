package com.manikandan.dxbtask.home_screen.util

import com.manikandan.dxbtask.R

sealed class Screen(
    val title: String,
    val icon: Int,
    val selectedIcon: Int
){
    object Home: Screen(title = "Home", icon = R.drawable.noun_home, selectedIcon = R.drawable.noun_home_filled)
    object Orders: Screen(title = "Orders", icon = R.drawable.noun_history, selectedIcon = R.drawable.noun_history_filled)
    object Notifications: Screen(title = "Notifications", icon = R.drawable.noun_notification, selectedIcon = R.drawable.noun_notification_filled)
    object MyAccount: Screen(title = "My Account", icon = R.drawable.noun_account, selectedIcon = R.drawable.noun_account_filled)
}
