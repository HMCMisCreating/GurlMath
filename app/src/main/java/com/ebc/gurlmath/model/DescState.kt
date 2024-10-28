package com.ebc.gurlmath.model

data class DescState (
    val discount: Int = 0,
    val price: String = "",
    val total: Double = 0.0,
    val subtotal: Double = 0.0,
    val onlyDiscount: Double = 0.0,
)