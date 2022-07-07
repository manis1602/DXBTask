package com.manikandan.dxbtask.home_screen.util

import com.manikandan.dxbtask.R

data class SubNavigationDetail(
    val leadingIcon: Int,
    val title: String,
    val isDarkBackground: Boolean
){
    companion object{
        fun getAllDetails():List<SubNavigationDetail>{
            return listOf(
                SubNavigationDetail(leadingIcon = R.drawable.noun_order_filled, title = "Orders", isDarkBackground = false),
                SubNavigationDetail(leadingIcon = R.drawable.noun_workflow, title = "How it Works", isDarkBackground = true),
                SubNavigationDetail(leadingIcon = R.drawable.noun_chat_filled, title = "About us", isDarkBackground = false),
                SubNavigationDetail(leadingIcon = R.drawable.noun_contact, title = "Contact us", isDarkBackground = true),
            )
        }
    }
}
