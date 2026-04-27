package com.example.jetpackcomposetest.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.config.ImageModelConstraints
import com.example.jetpackcomposetest.navigation.Routes
import com.example.jetpackcomposetest.ui.screens.splash.viewmodel.SplashViewModel
import com.example.jetpackcomposetest.ui.theme.FacebookBg
import com.example.jetpackcomposetest.ui.theme.FacebookBlueDark
import com.example.jetpackcomposetest.ui.theme.FacebookTextSecondary
import com.example.jetpackcomposetest.ui.widgets.UiImageView
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navHostController: NavHostController) {
    val viewModel: SplashViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        delay(2000L)
        val destination = if (viewModel.isLoggedIn()) Routes.Home.route else Routes.Login.route

        navHostController.navigate(destination) {
            popUpTo(Routes.Splash.route) {
                inclusive = true
            }
        }

    }

    Scaffold { innerPadding->
        Box(
            modifier = Modifier.background(color = FacebookBg).padding(innerPadding)
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 15.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(R.string.from), color = FacebookTextSecondary)
                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    UiImageView(
                        ImageModelConstraints.icMetaLogo, modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(stringResource(R.string.meta), color = FacebookBlueDark)
                }
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UiImageView(
                    ImageModelConstraints.icAppLogo, modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewSplashScreen() {
    SplashScreen(navHostController = rememberNavController())
}