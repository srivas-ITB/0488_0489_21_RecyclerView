package com.example.app21_RecyclerView.ui.navigation.pokemon

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Route: NavKey {
    @Serializable
    data object PokemonListScreen: Route()

    @Serializable
    data class PokemonDetailScreen(val id: String): Route()

    @Serializable
    data object Error: Route()
}