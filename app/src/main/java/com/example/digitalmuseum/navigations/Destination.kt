package com.example.digitalmuseum.navigations

sealed class Destination(
    val route: String
){
    object ArtHub : Destination(route = "hub")
    object ObjectDetails : Destination(route = "object_details")
    object ObjectsList : Destination(route = "objects_list")
    object ArtistsList : Destination(route = "artists_list")
    object ArtistDetails: Destination(route = "artist_details")
    object Camera : Destination(route = "camera")
    object MapScreen: Destination(route = "map_screen")
    object FavList: Destination(route = "fav_list")
    object AllMapScreen : Destination(route = "all_map")
}
