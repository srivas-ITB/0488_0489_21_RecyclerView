package com.example.app21_RecyclerView.ui.screen.pokemon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app21_RecyclerView.PokemonItem
import com.example.app21_RecyclerView.data.pokemon.PokemonProvider
import com.example.myapplication.data.Pokemon
import kotlinx.coroutines.launch


//Versió 1, llista simple, amb Fixed o Adaptive
@Composable
fun PokemonListScreen_v1(navigateToDetail: (String) -> Unit) {
    val pokemons = PokemonProvider().getPokemonList()
    //LazyVerticalGrid(columns = GridCells.Fixed(3)) {
    LazyVerticalGrid(columns = GridCells.Adaptive(200.dp)) {
        items(pokemons) {
            PokemonItem(pokemon = it, navigateToDetail)
        }
    }
}

//Versió 2, amb botó de tornar a l'inici segons l'estat del Lazy
@Composable
fun PokemonListScreen(navigateToDetail: (String) -> Unit) {
    //val rvState = rememberLazyListState()
    val rvState = rememberLazyGridState()
    val pokemons = PokemonProvider().getPokemonList()
    Box(modifier = Modifier.fillMaxSize()) {
        //LazyColumn(state = rvState, modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(state = rvState, columns = GridCells.Adaptive(200.dp)) {
            items(pokemons) { pokemon ->
                    PokemonItem(pokemon = pokemon, { navigateToDetail(pokemon.name) })
                }
        }
        val showButton by remember { derivedStateOf { rvState.firstVisibleItemIndex > 0 } }
        val coroutineScope = rememberCoroutineScope()
        if (showButton) {
            Button(onClick = {
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }
            }, modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 16.dp)) {
                Icon(painterResource(id = android.R.drawable.arrow_up_float), "Up")
            }
        }

    }
}



@Composable
fun PokemonItem(pokemon: Pokemon, navigateToDetail: (String) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navigateToDetail(pokemon.name) }
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.padding(8.dp)
                    .fillMaxHeight()
                    .size(100.dp),
                contentScale = ContentScale.Fit
            )
            Column {
                Text(pokemon.name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Text(text = "Type: ${pokemon.type}")
            }
        }
    }
}

