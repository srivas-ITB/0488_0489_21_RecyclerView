package com.example.app21_RecyclerView

import PokemonDetailScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.app21_RecyclerView.data.pokemon.PokemonProvider
import com.example.app21_RecyclerView.ui.navigation.pokemon.NavigationWrapper_pokemon
import com.example.app21_RecyclerView.ui.theme.MyApp_Theme
import com.example.myapplication.data.Pokemon


class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }
        enableEdgeToEdge()
        setContent {

            //BLOC PER FER SERVIR AMB EL LAZY COLUMN ADAPTIVE
            MyApp_Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationWrapper_pokemon(modifier = Modifier.padding(innerPadding))
                }
            }


            //BLOC PER FER SERVIR AMB ELS EXEMPLES 1 a 4

//            MyApp_Theme() {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MyLayout_Exemple4(modifier = Modifier.padding(innerPadding))
//                }
//            }
        }
    }
}

@Composable
fun MyLayout_Exemple1(modifier: Modifier) {
    Column( modifier = modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(R.drawable.demo_001),
                        contentDescription = "User image",
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text("First User")
                }
            }
            item {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(R.drawable.demo_002),
                        contentDescription = "User image",
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text("Second User")
                }
            }
            item {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(R.drawable.demo_003),
                        contentDescription = "User image",
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text("Third User")
                }
            }
        }
    }

}

@Composable
fun MyLayout_Exemple2(modifier: Modifier) {
    Column( modifier = modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(Modifier.fillMaxSize()) {
            items(10) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(getImageResource(it)),
                        contentDescription = "User image",
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text("User name $it")
                }
            }
        }

    }

}

fun getImageResource(it:Int) : Int {

    return when (it%3) {
        0 -> R.drawable.demo_001
        1 -> R.drawable.demo_002
        else -> R.drawable.demo_003
    }

}

@Composable
fun MyLayout_Exemple3(modifier: Modifier) {
    val myItems = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
        "Item 6", "Item 7", "Item 8", "Item 9", "Item 10")

    Column( modifier = modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(Modifier.fillMaxSize()) {

            items(myItems) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(getImageResource( Integer.parseInt(it.split(" ")[1]))),
                        contentDescription = "User image",
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text("User name $it")
                }
            }
        }

    }

}

@Composable
fun MyLayout_Exemple4(modifier: Modifier) {
    val pokemons = PokemonProvider().getPokemonList()


    Column( modifier = modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(Modifier.fillMaxSize()) {
            items(pokemons) { pokemon ->
                PokemonItem(pokemon = pokemon)
            }
        }

    }

}

@Composable
fun PokemonItem(pokemon: Pokemon) {
    Card(border = BorderStroke(2.dp, Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
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


