package com.example.app21_RecyclerView.data.pokemon

import com.example.app21_RecyclerView.R
import com.example.myapplication.data.Pokemon

class PokemonProvider() {
    private var pokemonList: MutableList<Pokemon> = mutableListOf(
        Pokemon("Caterpie", "Bug", R.drawable.caterpie),
        Pokemon("Charmander", "Fire", R.drawable.charmander),
        Pokemon("Squirtle", "Water", R.drawable.squirtle),
        Pokemon("Pikachu", "Electric", R.drawable.pikachu),
        Pokemon("Ditto", "Normal", R.drawable.ditto),
        Pokemon("Gengar", "Ghost", R.drawable.gengar),
        Pokemon("Lucario", "Fight", R.drawable.lucario),

        Pokemon("Caterpie (2)", "Bug", R.drawable.caterpie),
        Pokemon("Charmander (2)", "Fire", R.drawable.charmander),
        Pokemon("Squirtle (2)", "Water", R.drawable.squirtle),
        Pokemon("Pikachu (2)", "Electric", R.drawable.pikachu),
        Pokemon("Ditto (2)", "Normal", R.drawable.ditto),
        Pokemon("Gengar (2)", "Ghost", R.drawable.gengar),
        Pokemon("Lucario (2)", "Fight", R.drawable.lucario),

        Pokemon("Caterpie (3)", "Bug", R.drawable.caterpie),
        Pokemon("Charmander (3)", "Fire", R.drawable.charmander),
        Pokemon("Squirtle (3)", "Water", R.drawable.squirtle),
        Pokemon("Pikachu (3)", "Electric", R.drawable.pikachu),
        Pokemon("Ditto (3)", "Normal", R.drawable.ditto),
        Pokemon("Gengar (3)", "Ghost", R.drawable.gengar),
        Pokemon("Lucario (3)", "Fight", R.drawable.lucario)
    )

    fun getPokemonList(): MutableList<Pokemon> {
        return pokemonList
    }


    fun getPokemon(pokemonId:Int) : Pokemon? {

        return null
    }

    fun getPokemon(pokemonName: String): Pokemon?{
        return pokemonList.find { it.name == pokemonName }
    }

}
