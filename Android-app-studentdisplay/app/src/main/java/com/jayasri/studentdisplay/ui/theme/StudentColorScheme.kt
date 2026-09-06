package com.jayasri.studentdisplay.ui.theme
import androidx.compose.ui.graphics.Color
data class StudentColorScheme(
    val idTextColor: Color = Gray500,
    val nameTextColor: Color = Pink500,
    val departTextColor: Color = Pink900,
    val borderColor: Color = Pink300,
    val cgbaBgColor: Color = Pink300,
    val livingTypeBgColor: Color = Pink800,
    val livingTextColor: Color = Gray100,
    val infoBgColor: Color = Gray100,
    val cgpaTextColor:Color=Gray900
)

val GirlColorScheme = StudentColorScheme()

val BoyColorScheme = StudentColorScheme().copy(
    borderColor = Blue300,
    nameTextColor = Blue500,
    departTextColor = Blue900,
    livingTypeBgColor = Blue800,
    cgbaBgColor = Blue300
)

