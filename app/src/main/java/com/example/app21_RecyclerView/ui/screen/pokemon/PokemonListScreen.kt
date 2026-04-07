package com.example.app21_RecyclerView.ui.screen.pokemon

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.example.app21_RecyclerView.PokemonItem
import com.example.app21_RecyclerView.data.pokemon.PokemonProvider


@Composable
fun PokemonListScreen(navigateToDetail: (String) -> Unit) {
    val pokemons = PokemonProvider().getPokemonList()
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(pokemons) {
            PokemonItem(pokemon = it, navigateToDetail)
        }
    }
}
