package com.roque.carlos.menutec.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.KeyboardType




@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange:(value:String)->Unit,
    label:String,
    painterResource: Painter,
    keyboardType: KeyboardType = KeyboardType.Text
){
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = {text ->
            onValueChange(text) },
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Image(
                painter = painterResource,
                contentDescription = "",
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}