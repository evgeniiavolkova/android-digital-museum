package com.example.digitalmuseum.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.digitalmuseum.constance.Constants

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    navigation: INavigationRouter = remember { NavigationRouterImpl(navController) },
    startDestination: String
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Destination.ArtHub.route) {
            //
        }

        composable(Destination.ObjectsList.route){
            //
        }

        composable(Destination.ObjectDetails.route + "/{objectID}",
            arguments = listOf(
                navArgument(Constants.objectID){
                    type = NavType.IntType
                    defaultValue = -1F
                }
            )
        ){
            val objectID = it.arguments?.getInt(Constants.objectID)
            //
        }
    }

}