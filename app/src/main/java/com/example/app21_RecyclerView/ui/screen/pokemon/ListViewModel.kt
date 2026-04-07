package com.example.app21_RecyclerView.ui.screen.pokemon

import androidx.lifecycle.ViewModel
import com.example.app21_RecyclerView.data.pokemon.PokemonProvider
import com.example.myapplication.data.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListViewModel(): ViewModel() {
    private val provider = PokemonProvider()

    private var _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList.asStateFlow()

    init {
       _pokemonList.value = provider.getPokemonList()
    }

}