package com.roque.carlos.menutec.presentation.views.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roque.carlos.menutec.R

@Composable
fun LoginContent(paddingValues: PaddingValues){
    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.comedor),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f,0.5f,0.5f,1f) })
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                ,
                painter = painterResource(id = R.drawable.tecsup_icocno),
                contentDescription = "Logo"
            )
            Text(
                modifier = Modifier.padding(bottom = 7.dp),
                text = "Comedor Tecsup",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.Transparent
            ) {
                Column (modifier = Modifier.padding(20.dp)){

                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Ingresar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(
                                text = "Correo electronico",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        },
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.gmail),
                                contentDescription = "gmail_logo"
                            )
                        }
                    )
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(
                                text = "Contraseña",
                                color = Color.White,
                                fontSize = 15.sp

                            )
                        },
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.clave),
                                contentDescription = "clave_logo"
                            )
                        }
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {  }) {
                        Text(
                            text = "Iniciar sesion",
                            color = Color.White,
                            fontSize = 18.sp
                        )

                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "No tienes una cuenta? ",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Registrate",
                            color = Color.Blue,
                            fontSize = 18.sp
                        )
                    }
                }
            }

        }
    }
}