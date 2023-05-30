package com.roque.carlos.menutec.presentation.views.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.roque.carlos.menutec.R
import com.roque.carlos.menutec.presentation.theme.MenutecTheme
import com.roque.carlos.menutec.presentation.views.auth.register.components.RegisterContent


@Composable
fun RegisterView(navController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Registro",
                        fontSize = 19.sp,

                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
            ) 
        }

    ){paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterViewPreview() {
    MenutecTheme {
        RegisterView(rememberNavController())
    }
}
