package com.ebc.gurlmath.view.components.onboarding


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ebc.gurlmath.R
import com.ebc.gurlmath.enumerators.ViewID
import com.ebc.gurlmath.staticdata.OnboardingData
import com.ebc.gurlmath.view.components.CustomSpacer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MainOnboarding(navController: NavController) {
    val items = ArrayList<OnboardingData>()

    items.add(
        OnboardingData(
            R.raw.page1,
            "¡Hola!",
            "Que alegría verte por aquí, GurlMath te ayudará a calcular el costo final de cosas."
        )
    )

    items.add(
        OnboardingData(
            R.raw.page2,
            "¡Bienvenido!",
            "Aquí encontrarás una calculadora de propina y una de precio después de descuentos."
        )
    )

    items.add(
        OnboardingData(
            R.raw.page3,
            "¡A calcular!",
            "¡Manos a la obra! Descubre el precio real de las cosas antes de pagar."
        )
    )

    val pagerState = rememberPagerState(
        pageCount = { items.size },
        initialPage = 0,
        initialPageOffsetFraction = 0f
    )

    Column(
        modifier = Modifier
            .padding(top = 100.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(state = pagerState) {

            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(items[it].image)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .size(200.dp)
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterHorizontally)
                )
                Text(
                    text = items[it].title,
                    modifier = Modifier.padding(top = 50.dp),
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = items[it].desc,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

            }
        }
//Aca se hacen los puntitos que indican en que pag estas del HorizPager:
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 60.dp) //pa que no este pegado al pager
        ) {
            repeat(items.size) { //ciclo de kotlin! repeat
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .height(10.dp)
                        .width(25.dp) // 10 circulo
                        .clip(CircleShape) //esto redondea el box
                        .background(if (it == pagerState.currentPage) Color.Magenta else Color.Gray)
                )
            }
        }

        CustomSpacer(height = 50.dp)

        Box {
            Row {
                if (pagerState.currentPage == items.size - 1) {
                    Button(onClick = {
                        navController.navigate(ViewID.Start.id)
                    }) {
                        Text(text = "Entrar")
                    }
                }
            }
        }
    }
}