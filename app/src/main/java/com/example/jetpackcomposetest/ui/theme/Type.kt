package com.example.jetpackcomposetest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetest.R

val FacebookFonts = FontFamily(
    Font(R.font.googlesans_ragular, FontWeight.Normal),
    Font(R.font.googlesans_semibold, FontWeight.Bold)
)
val FacebookTypography = Typography(
    headlineMedium = TextStyle(fontFamily = FacebookFonts, fontWeight = FontWeight.Bold,   fontSize = 20.sp),
    titleMedium    = TextStyle(fontFamily = FacebookFonts,fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
    bodyMedium     = TextStyle(fontFamily = FacebookFonts, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    labelSmall     = TextStyle(fontFamily = FacebookFonts,fontWeight = FontWeight.Normal, fontSize = 12.sp,
        color = FacebookTextSecondary)
)

