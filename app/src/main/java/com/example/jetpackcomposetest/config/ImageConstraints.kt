package com.example.jetpackcomposetest.config

import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.data.model.ImageModel


object ImageConstraints {
    val icAppLogo : ImageModel = ImageModel(image = R.drawable.ic_app_logo, description = R.string.image_description_ic_app_logo);
    val icMetaLogo : ImageModel = ImageModel(image = R.drawable.ic_meta, description = R.string.image_description_ic_meta);
}