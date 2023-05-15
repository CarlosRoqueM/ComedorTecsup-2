package com.roque.carlos.menutec.presentation.views.auth.login

import androidx.compose.material.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.roque.carlos.menutec.presentation.theme.MenutecTheme
import com.roque.carlos.menutec.presentation.views.auth.login.components.LoginContent

@Composable
fun LoginView(){
    Scaffold{paddingValues ->
        LoginContent(paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginViewPreview() {
    MenutecTheme {
        LoginView()
    }
}