package com.roque.carlos.menutec.presentation.views.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.roque.carlos.menutec.R
import com.roque.carlos.menutec.presentation.navigation.screen.AuthScreen
import com.roque.carlos.menutec.presentation.views.auth.login.LoginViewModel


@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()){

    val  state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if (vm.errorMessage != ""){
            Toast.makeText(context,vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

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
                painter = painterResource(id = R.drawable.tecsup2),
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
                Column (modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())){

                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Ingresar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        value = state.email,
                        onValueChange = {text ->
                                        vm.onEmailInput(text)
                        },
                        label = {
                            Text(
                                text = "Correo electronico",
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
                                painter = painterResource(id = R.drawable.gmail),
                                contentDescription = "gmail_logo"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        value = state.password,
                        onValueChange = {text ->
                                        vm.onPasswordInput(text)
                        },
                        label = {
                            Text(
                                text = "Contraseña",
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
                                painter = painterResource(id = R.drawable.clave),
                                contentDescription = "clave_logo"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { vm.validateFrom()}) {
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
                            modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route ) },
                            text = "Registrate",
                            color = Color.Blue,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        }
    }
}