package com.ebc.gurlmath.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ebc.gurlmath.enumerators.ViewModelID
import com.ebc.gurlmath.model.DescState

class DescViewModel: ViewModel() {
    var state by mutableStateOf(DescState())
        private set

    //Que va a pasar cuando view solicite un cambioo
    fun onValue(value:String, textId: String) {
        when (textId) {
            ViewModelID.Price.id -> {
                state = state.copy(price = value)
                calculateDiscountFinalAmount()
            }
            ViewModelID.Discount.id -> state = state.copy(discount = value.toInt())


        }
    }

    //fx de desc
    private fun calculateDiscountFinalAmount() {
        val price = state.price.toDouble()
        val discount = state.discount.toDouble()
        val onlyDiscount = price * (discount/100)
        val total = price - onlyDiscount

        state = state.copy(total = total)
    }


    //Fx para hacer un reset a la orden e iniciar de nuevo
    fun reset() {
        state = DescState()
    }
}
