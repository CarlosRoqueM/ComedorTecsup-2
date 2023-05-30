package com.roque.carlos.menutec.presentation.views.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roque.carlos.menutec.R
import com.roque.carlos.menutec.presentation.views.auth.register.RegisterState
import com.roque.carlos.menutec.presentation.views.auth.register.RegisterViewModel


@Composable
fun RegisterContent(paddingValues: PaddingValues, vm:RegisterViewModel = hiltViewModel()){

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if (vm.errorMessage != ""){
            Toast.makeText(context,vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.imagen_registro),
            contentDescription = "Imagen",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f,0.5f,0.5f,1f) })
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .height(100.dp),
                painter = painterResource(id = R.drawable.tecsup2) ,
                contentDescription = "Logo tecsup"
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                text = "Ingresa tu informacion" 
            )
            Spacer(modifier = Modifier.weight(0.1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                ),
                backgroundColor = Color.Transparent

            ) {
                Column(modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())) {
                    Text(
                        modifier = Modifier.padding(vertical = 20.dp),
                        text = "Registrarte",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        value = state.name,
                        onValueChange = {text ->
                            vm.onNameInput(text)
                        },
                        label = {
                            Text(
                                text = "Nombres",
                                color = Color.White,
                                fontSize = 15.sp,

                            )
                        },textStyle = TextStyle(color = Color.White),

                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.usuario),
                                contentDescription = "logo_nombre"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        value = state.lastname,
                        onValueChange = {text ->
                            vm.onLastnameInput(text)},
                        label = {

                            Text(
                                text = "Apellidos",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        },textStyle = TextStyle(color = Color.White),
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.usuario),
                                contentDescription = "logo_apellidos"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        value = state.email,
                        onValueChange = {text ->
                            vm.onEmailInput(text)},
                        label = {
                            Text(
                                text = "Correo electronico",
                                color = Color.White,
                                fontSize = 15.sp,
                            )
                        },textStyle = TextStyle(color = Color.White),
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.gmail),
                                contentDescription = "gmail_logo"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        value = state.phone,
                        onValueChange = {text ->
                            vm.onPhoneInput(text)},
                        label = {
                            Text(
                                text = "Telefono",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        },textStyle = TextStyle(color = Color.White),
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.llamada),
                                contentDescription = "logo_telefono"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        value = state.password,
                        onValueChange = {text ->
                            vm.onPasswordInput(text)},
                        label = {
                            Text(
                                text = "Contraseña",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        },textStyle = TextStyle(color = Color.White),
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.clave),
                                contentDescription = "logo_contraseña"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.confirmPassword,
                        onValueChange = {text ->
                            vm.onConfirmPasswordInput(text)},
                        label = {
                            Text(
                                text = "Confirmar contraseña",
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        },textStyle = TextStyle(color = Color.White),
                        leadingIcon = {
                            Image(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(15.dp)
                                ,
                                painter = painterResource(id = R.drawable.clave),
                                contentDescription = "logo_contraseña"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { vm.validateFrom()  }) {
                        Text(
                            text = "Confirmar",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}