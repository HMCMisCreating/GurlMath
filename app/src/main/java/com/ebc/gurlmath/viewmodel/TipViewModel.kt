package com.ebc.gurlmath.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ebc.gurlmath.enumerators.ViewModelID
import com.ebc.gurlmath.model.TipState

class TipViewModel: ViewModel() {
    var state by mutableStateOf(TipState())
        private set

    fun onValue(value:String, textId:String) {
        when (textId) {
            ViewModelID.Tip.id -> {
                state = state.copy(tip = value.toDouble())
                calculateTipTotalAmount()
            }
            ViewModelID.Price.id -> {
                state = state.copy(price = value)
                calculateTipTotalAmount()
            }
        }
    }


    //fx de tip
    private fun calculateTipTotalAmount() {
        val price = state.price.toDouble()
        val tipPercent = state.tipPercent
        val onlyTip = price * (tipPercent/100)
        val total = price + onlyTip

        state = state.copy(total = total)
    }



    //Fx para hacer un reset a la orden e iniciar de nuevo
    fun reset() {
        state = TipState()
    }
}
