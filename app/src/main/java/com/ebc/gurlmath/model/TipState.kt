package com.ebc.gurlmath.model

data class TipState (
    val tip: Double = 0.0,
    val subtotal: Double = 0.0,
    val total: Double =0.0,
    val price: String = "",
    val tipPercent: Int = 0,
    val onlyTip: Double = 0.0,

)