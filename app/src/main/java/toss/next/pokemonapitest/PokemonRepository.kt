package toss.next.pokemonapitest

import android.content.Context
import androidx.room.Room

class PokemonRepository private constructor(context: Context) {

    private val database: PokemonDatabase =
        Room.databaseBuilder(context.applicationContext, PokemonDatabase::class.java, "pokemon")
            .build()

    private val pokemonDao = database.pokemonDao()

    suspend fun getPokemonList(): List<Pokemon> {
        return pokemonDao.getAllPokemons()
    }

    suspend fun getPokemon(id: Int): Pokemon {
        return pokemonDao.getPokemon(id)
    }

    suspend fun insertPokemon(pokemon: Pokemon) {
        pokemonDao.insertPokemon(pokemon)
    }


    companion object{
        private var INSTANCE : PokemonRepository? =null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = PokemonRepository(context)
            }
        }

        fun get() : PokemonRepository {
            return INSTANCE ?:
            throw IllegalStateException("NoteRepository must be initialized")
        }
    }

}
