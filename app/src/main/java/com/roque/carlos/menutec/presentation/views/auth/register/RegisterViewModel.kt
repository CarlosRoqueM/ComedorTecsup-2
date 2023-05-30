package com.roque.carlos.menutec.presentation.views.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())

    var errorMessage by mutableStateOf("")
        private set

    fun onNameInput(input: String){
        state = state.copy(name = input)
    }

    fun onLastnameInput(input:String){
        state = state.copy(lastname = input)
    }
    fun onEmailInput(input:String){
        state = state.copy(email = input)
    }
    fun onPhoneInput(input:String){
        state = state.copy(phone = input)
    }
    fun onPasswordInput(input:String){
        state = state.copy(password = input)
    }
    fun onConfirmPasswordInput(input:String){
        state = state.copy(confirmPassword= input)
    }

    fun  validateFrom() = viewModelScope.launch{
        if(state.name == ""){
            errorMessage = "Ingresa tu nombre"
        }
        else if(state.lastname == ""){
            errorMessage = "Ingresa los apellidos"
        }
        else if(state.email == ""){
            errorMessage = "Ingresa tu email"
        }
        else if(state.phone == ""){
            errorMessage = "Ingresa tu numero de celular"
        }
        else if(state.password == ""){
            errorMessage = "Ingresa tu contraseña "
        }
        else if(state.confirmPassword == ""){
            errorMessage = "Confirma tu contraseña"
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El email no es valido"
        }
        else if(state.phone.length < 9){
            errorMessage = "Ingrese un numero correcto"
        }
        else if(state.password.length<6){
            errorMessage = "La contraseña debe de tener de 6 caracteres a mas"
        }
        else if(state.password != state.confirmPassword){
            errorMessage = "La contraseñas no coinciden"
        }
        delay(3000)

        errorMessage = ""
    }
}