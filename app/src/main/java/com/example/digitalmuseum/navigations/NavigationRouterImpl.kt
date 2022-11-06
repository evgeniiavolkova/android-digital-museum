package com.example.digitalmuseum.navigations

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {

    override fun getNavController(): NavController = navController

    override fun returnBack() {
        navController.popBackStack()
    }

    override fun navigateToArtHub() {
        navController.navigate(Destination.ArtHub.route)
    }

    override fun navigateToObjectDetails(objectId: Int) {
        navController.navigate(Destination.ObjectDetails.route + "/" + objectId)
    }

    override fun navigateToMap(museumName: String) {
        navController.navigate(Destination.MapScreen.route + "/" + museumName)
    }


}