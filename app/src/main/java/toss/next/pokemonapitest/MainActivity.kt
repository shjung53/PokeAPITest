package toss.next.pokemonapitest

import android.graphics.BlendModeColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import toss.next.pokemonapitest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                val response = PokemonService.service.fetchPokemonById("35")

                Glide
                    .with(this@MainActivity)
                    .load(response.imageUrl.bigImage.defaultImage.frontDefault)
                    .centerCrop()
                    .into(binding.pokemonImage);

                val response2 = PokemonService.service.fetchPokemonList()

                async {
                    for (result in response2.results) {
                        withContext(Dispatchers.IO) {
                            val response3 = PokemonService.service.fetchPokemonByName(result.name)
                            PokemonRepository.get().insertPokemon(
                                Pokemon(
                                    response3.id,
                                    response3.name,
                                    response3.imageUrl.bigImage.defaultImage.frontDefault,
                                    response3.imageUrl.bigImage.defaultImage.frontDefault,
                                    ""
                                )
                            )
                        }
                    }
                }

            }
        }
    }
}
