package com.example.jetpackcomposetest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposetest.config.ImageModelConstraints
import com.example.jetpackcomposetest.data.model.ImageModel
import com.example.jetpackcomposetest.ui.theme.FacebookBg
import com.example.jetpackcomposetest.ui.theme.FacebookBlueDark
import com.example.jetpackcomposetest.ui.theme.FacebookSurface
import com.example.jetpackcomposetest.ui.theme.FacebookTextPrimary
import com.example.jetpackcomposetest.ui.theme.FacebookTextWhite
import com.example.jetpackcomposetest.ui.theme.FacebookTypography
import com.example.jetpackcomposetest.ui.widgets.CustomEditText
import com.example.jetpackcomposetest.ui.widgets.UiImageView

@Composable
fun LoginScreen(navHostController: NavHostController) {

    var userNameController : String by remember{
        mutableStateOf("")
    }
    var passwordController : String by remember{
        mutableStateOf("")
    }

    Scaffold { innerPadding->
        Box(modifier = Modifier
            .background(color = FacebookBg)
            .padding(innerPadding)
            .fillMaxSize()){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                UiImageView(ImageModelConstraints.icAppLogo, modifier = Modifier.width(50.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text("facebook", modifier = Modifier.fillMaxWidth().background(color = FacebookBg),
                    style = FacebookTypography.headlineLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = FacebookBlueDark
                    )
                Spacer(modifier = Modifier.height(30.dp))
                Column(modifier = Modifier.fillMaxWidth().padding(20.dp)){
                    CustomEditText(textController = userNameController, label = "User name / mobile No") {
                        userNameController = it
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomEditText(textController = passwordController, label = "Password") {
                        passwordController = it
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Box(modifier = Modifier.fillMaxWidth().height(50.dp).background(FacebookBlueDark, shape = RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center){
                        Text("Log In", style = FacebookTypography.titleMedium, color = FacebookTextWhite,)
                        CircularProgressIndicator(modifier = Modifier.padding(10.dp))
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))

                Text("Forgot password?", style = FacebookTypography.headlineMedium, color = FacebookBlueDark)






            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(navHostController = rememberNavController())
}