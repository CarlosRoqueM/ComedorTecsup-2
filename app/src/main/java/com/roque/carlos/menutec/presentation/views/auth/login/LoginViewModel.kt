package com.roque.carlos.menutec.presentation.views.auth.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }

    fun  validateFrom() = viewModelScope.launch{
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
        }
        else if(state.password.length<6){
            errorMessage = "La contraseña debe de tener de 6 caracteres a mas"
        }
        delay(3000)

        errorMessage = ""
    }


}