package com.ebc.gurlmath.view.mathwizard


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebc.gurlmath.R
import com.ebc.gurlmath.enumerators.ViewID
import com.ebc.gurlmath.enumerators.ViewModelID
import com.ebc.gurlmath.staticdata.DataSource
import com.ebc.gurlmath.view.components.CustomSpacer
import com.ebc.gurlmath.view.components.SliderPercentual
import com.ebc.gurlmath.view.components.TitleMedium
import com.ebc.gurlmath.viewmodel.TipViewModel
import kotlinx.coroutines.selects.select

@Composable
fun SelectTipScreen (navController: NavController,
                     tipViewModel: TipViewModel)
{
    var selectedOption by remember { mutableStateOf("Elige la propina")}
    val tipOptions = DataSource.tipKeys.map {key -> stringResource(key)}

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = Modifier.padding(16.dp)
        ){
        CustomSpacer(height = 16.dp)
        TextField(
            value = tipViewModel.state.price,
            onValueChange = { instructions ->
                tipViewModel.onValue(instructions, ViewModelID.Price.id)
            },
            label = { Text(stringResource(R.string.priceNoTip)) },
            maxLines = Int.MAX_VALUE,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(16.dp)
        )
            CustomSpacer(height = 16.dp)
            tipOptions.forEach{ tip ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.selectable(
                        selected = tipViewModel.state.tipPercent.toString() == tip,
                        onClick = {
                            tipViewModel.onValue(tip, ViewModelID.Tip.id)
                        }
                    )
                ){
                    RadioButton(
                        selected = tipViewModel.state.tipPercent.toString() == tip,
                        onClick = {
                            tipViewModel.onValue(tip, ViewModelID.Tip.id)
                        }
                    )
                    Text(text= tip)
                }
            }
            CustomSpacer(height = 16.dp)
            //Slider si llegara a funcionar:
            //SliderPercentual()


            //aca esta el total calculado
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = stringResource(
                    R.string.total,
                    tipViewModel.state.total
                ),
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        OutlinedButton(
            modifier = Modifier.weight(1F),
            onClick = {
                tipViewModel.reset()
                navController.popBackStack(ViewID.Start.id, false)
            }
        ) {
            Text(stringResource(R.string.back))
        }
    }

    }




