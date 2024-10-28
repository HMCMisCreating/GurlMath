package com.ebc.gurlmath.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun SliderPercentual(){
    val range = 0f..100f
    var percentOption by remember { mutableStateOf(0f)}


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.height(100.dp)){
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Slider(
            value = percentOption,
            valueRange = range,
            onValueChange = { percentOption = it},
            modifier = Modifier.weight(0.8f)
                .padding(16.dp)
        )
        Text(text= percentOption.toInt().toString(),
            modifier = Modifier.weight(0.2f))

    }
}