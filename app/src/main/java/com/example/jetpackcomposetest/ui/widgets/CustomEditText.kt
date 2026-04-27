package com.example.jetpackcomposetest.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetest.ui.theme.FacebookSurface
import com.example.jetpackcomposetest.ui.theme.FacebookTextPrimary
import com.example.jetpackcomposetest.ui.theme.FacebookTextSecondary
import com.example.jetpackcomposetest.ui.theme.FacebookTypography

@Composable
fun CustomEditText(textController:String,label:String,modifier: Modifier = Modifier,onChanged:(String)->Unit) {
    TextField(
        value = textController,
        onValueChange = {
            onChanged(it)
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(text = label, style = TextStyle(fontFamily = FacebookTypography.bodyMedium.fontFamily), color = FacebookTextSecondary)
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(FacebookTextPrimary),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewCustomEditText() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        CustomEditText(
            textController = "",
            label = "User Name",
            onChanged = {}
        )
    }
}