package com.roque.carlos.menutec.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.roque.carlos.menutec.presentation.navigation.Graph
import com.roque.carlos.menutec.presentation.navigation.screen.AuthScreen
import com.roque.carlos.menutec.presentation.views.auth.login.LoginView
import com.roque.carlos.menutec.presentation.views.auth.register.RegisterView

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginView(navController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterView(navController)
        }
    }
}