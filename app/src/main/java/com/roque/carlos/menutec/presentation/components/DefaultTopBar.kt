package com.roque.carlos.menutec.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.roque.carlos.menutec.R

@Composable
fun DefaultTopBar(
    title: String,
    upAvailable:Boolean = false,
    navController:NavHostController? = null
){
    TopAppBar(
        title = {
            Text(
                text = "Registro",
                fontSize = 19.sp
            )
        },
        backgroundColor = Color.Transparent,
        navigationIcon = {
            if (upAvailable){
                IconButton(onClick = { navController?.popBackStack() }) {
                    Image(
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                        ,
                        painter = painterResource(id = R.drawable.retroceder),
                        contentDescription = ""
                    )
                }
            }
        }
    )
}