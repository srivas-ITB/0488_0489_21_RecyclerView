package com.example.app21_RecyclerView.ui.navigation.pokemon

import PokemonDetailScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.app21_RecyclerView.ui.screen.pokemon.PokemonListScreen

@Composable
fun NavigationWrapper_pokemon(modifier: Modifier) {
    val backStack = rememberNavBackStack(Route.PokemonListScreen)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Route.PokemonListScreen> {
                PokemonListScreen { id -> backStack.add(Route.PokemonDetailScreen(id)) }
            }
            entry<Route.PokemonDetailScreen> { key->
                PokemonDetailScreen(key.id) {
                    backStack.removeLastOrNull()
                }
            }
        }

    )

}
