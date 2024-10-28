package com.ebc.gurlmath.view.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ebc.gurlmath.enumerators.ViewID
import com.ebc.gurlmath.view.components.onboarding.MainOnboarding
import com.ebc.gurlmath.view.components.splash.SplashScreen
import com.ebc.gurlmath.view.mathwizard.SelectDescScreen
import com.ebc.gurlmath.view.mathwizard.SelectTipScreen
import com.ebc.gurlmath.view.mathwizard.StartScreen
import com.ebc.gurlmath.viewmodel.DescViewModel
import com.ebc.gurlmath.viewmodel.TipViewModel

// Crear el nav manager
@Composable
fun NavigationManager(tipViewModel: TipViewModel, descViewModel: DescViewModel) {
    val navController = rememberNavController()

    Scaffold(

        bottomBar = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text (text= "Gurl Math 1.0")
            }
        }

    ) {
        NavHost(
            navController = navController,
            startDestination = ViewID.Splash.id,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable(ViewID.Splash.id) {
                SplashScreen(navController)
            }
            composable(ViewID.Home.id) {
                MainOnboarding(navController)
            }
            composable (ViewID.Start.id) {
                StartScreen(navController)
            }
            composable (ViewID.Tip.id) {
                SelectTipScreen(navController, tipViewModel )
            }
            composable (ViewID.Discount.id) {
                SelectDescScreen(navController, descViewModel)
            }

        }
    }
}
