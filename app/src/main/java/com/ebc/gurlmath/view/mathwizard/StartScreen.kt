package com.ebc.gurlmath.view.mathwizard


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebc.gurlmath.R
import com.ebc.gurlmath.enumerators.ViewID
import com.ebc.gurlmath.view.components.CustomSpacer
import com.ebc.gurlmath.view.components.TitleMedium


@Composable
fun StartScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            CustomSpacer(height = 100.dp)
            Image(
                painter = painterResource(R.drawable.money),
                contentDescription = stringResource(R.string.sample_bill),
                modifier = Modifier.width(300.dp)
            )
            CustomSpacer(height = 16.dp)
            TitleMedium(stringResource(R.string.what_now))
            CustomSpacer(height = 16.dp)

        }
        //aca van las opciones de que hacer ahora

        Button(
            onClick = {
                navController.navigate(ViewID.Tip.id)
                          },
            modifier = Modifier.fillMaxWidth()
                ) {
            Text ( stringResource(R.string.calculate_tip))
                }
        Button(
            onClick = {
                navController.navigate(ViewID.Discount.id)
                },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text ( stringResource(R.string.calculate_desc))
            }
        }
    }

