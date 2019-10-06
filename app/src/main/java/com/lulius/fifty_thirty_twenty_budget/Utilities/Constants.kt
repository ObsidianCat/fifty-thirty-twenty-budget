package com.lulius.fifty_thirty_twenty_budget.Utilities

import androidx.navigation.navOptions
import com.lulius.fifty_thirty_twenty_budget.R

val DEFAULT_CATEGORIES = setOf("Bills & Services", "Shopping", "Entertaiment", "Eating Out", "Lifestyle","Transport", "Groceries",  "General")

enum class expenseType(val type: String) {
    NEED("Need"),
    WANT("Want")
}

val transitionOptions = navOptions {
    anim {
        enter = R.anim.slide_in_right
        exit = R.anim.slide_out_left
        popEnter = R.anim.slide_in_left
        popExit = R.anim.slide_out_right
    }
}