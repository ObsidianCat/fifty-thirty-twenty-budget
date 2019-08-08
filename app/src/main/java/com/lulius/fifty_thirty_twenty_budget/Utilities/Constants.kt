package com.lulius.fifty_thirty_twenty_budget.Utilities

val DEFAULT_CATEGORIES = setOf("Bills & Services", "Shopping", "Entertaiment", "Eating Out", "Lifestyle","Transport", "Groceries",  "General")

enum class expenseType(val type: String) {
    NEED("Need"),
    WANT("Want")
}