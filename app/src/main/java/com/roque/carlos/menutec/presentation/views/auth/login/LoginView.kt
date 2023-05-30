package com.roque.carlos.menutec.presentation.views.auth.login

import androidx.compose.material.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.roque.carlos.menutec.presentation.theme.MenutecTheme
import com.roque.carlos.menutec.presentation.views.auth.login.components.LoginContent

@Composable
fun LoginView(navController : NavHostController){
    Scaffold{paddingValues ->
        LoginContent(navController = navController, paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginViewPreview() {
    MenutecTheme {
        LoginView(rememberNavController())
    }
}