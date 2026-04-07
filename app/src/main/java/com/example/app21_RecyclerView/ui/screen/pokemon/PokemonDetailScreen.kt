import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app21_RecyclerView.PokemonItem
import com.example.app21_RecyclerView.R
import com.example.app21_RecyclerView.data.pokemon.PokemonProvider

@Composable
fun PokemonDetailScreen(pokemonName: String, navigateBack: () -> Unit) {
    val pokemon = PokemonProvider().getPokemon(pokemonName)
    Column(
        Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(painterResource(pokemon?.image ?: R.drawable.ic_launcher_foreground),
            contentDescription = "Pokemon image"
        )
        Text(pokemon?.name ?: "Pokemon",fontSize = 28.sp,fontWeight = FontWeight.Bold)
        Text(text = "Type: ${pokemon?.type ?: "Pokemon type"}")
        Button(navigateBack) {Text("Return")}
    }
}


