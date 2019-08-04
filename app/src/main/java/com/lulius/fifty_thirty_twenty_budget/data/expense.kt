package com.lulius.fifty_thirty_twenty_budget.data

data class Expense(
    var name: String,
    var price: Double,
    var category: String // Should be ENUM of categories
)