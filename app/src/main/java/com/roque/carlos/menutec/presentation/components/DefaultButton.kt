package com.roque.carlos.menutec.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(
    modifier: Modifier,
    value: String,
    onValueChange:(value:String)->Unit,
    label:String,
    painterResource: Painter,
    keyboardType: KeyboardType = KeyboardType.Text
){
    Button(
        modifier = modifier,
        onClick = {  }) 
    {

        Text(
            text = "Iniciar sesion",
            color = Color.White,
            fontSize = 18.sp
        )

    }
}