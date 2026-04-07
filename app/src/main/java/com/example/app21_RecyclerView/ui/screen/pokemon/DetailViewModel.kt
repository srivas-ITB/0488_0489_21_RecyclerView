package com.example.app21_RecyclerView.ui.screen.pokemon

import androidx.lifecycle.ViewModel
import com.example.app21_RecyclerView.data.pokemon.PokemonProvider
import com.example.app21_RecyclerView.data.preferences.SettingsRepository
import com.example.myapplication.data.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(pokemonId: Int, sr: SettingsRepository) : ViewModel() {
    private val provider = PokemonProvider()

    private val _pokemon = MutableStateFlow<Pokemon?>(null)
    val pokemon: StateFlow<Pokemon?> = _pokemon.asStateFlow()

    private val _pokemonAnterior = MutableStateFlow<Pokemon?>(null)
    val pokemonAnterior: StateFlow<Pokemon?> = _pokemonAnterior.asStateFlow()

    init {

        _pokemonAnterior.value = provider.getPokemon(sr.getSettingValue("pokemonId", 0))

        _pokemon.value = provider.getPokemon(pokemonId)

        //Actualiza el pokemon
        sr.saveSettingValue("pokemonId", pokemonId);

    }


}