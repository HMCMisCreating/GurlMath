package com.ebc.gurlmath.view.mathwizard



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebc.gurlmath.R
import com.ebc.gurlmath.enumerators.ViewID
import com.ebc.gurlmath.enumerators.ViewModelID
import com.ebc.gurlmath.staticdata.DataSource
import com.ebc.gurlmath.staticdata.DataSource.descOptions
import com.ebc.gurlmath.view.components.CustomSpacer
import com.ebc.gurlmath.viewmodel.DescViewModel




@Composable
fun SelectDescScreen(navController: NavController,
                    descViewModel: DescViewModel
) {
    var selectedOption by remember { mutableStateOf("Elige el descuento")}
    val descOptions = DataSource.descOptions.map {key -> stringResource(key)}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //En esta columna vamos a albergar las opciones de descuentos
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            CustomSpacer(height = 16.dp)
            TextField(
                value = descViewModel.state.price,
                onValueChange = { instructions ->
                    descViewModel.onValue(instructions, ViewModelID.Price.id)
                },
                label = { Text(stringResource(R.string.priceNoDesc)) },
                maxLines = Int.MAX_VALUE,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            )
            CustomSpacer(height = 16.dp)
           descOptions.forEach{ desc ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    RadioButton(
                        selected = (selectedOption == desc),
                        onClick = {selectedOption = desc}
                    )
                    Text(text= desc)
                }

            }

            //aca esta el total calculado
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = stringResource(
                    R.string.total,
                    descViewModel.state.total
                ),
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

        }

    }//bottom container
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        OutlinedButton(
            modifier = Modifier.weight(1F),
            onClick = {
                descViewModel.reset()
                navController.popBackStack(ViewID.Start.id, false)
            }
        ) {
            Text(stringResource(R.string.back)) }
    }
}

