package com.example.jetpackcomposetest.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.jetpackcomposetest.data.model.ImageModel

@Composable
fun UiImageView(imageModel: ImageModel, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = imageModel.image),
        contentDescription = stringResource(imageModel.description),
        modifier = modifier
    )
}