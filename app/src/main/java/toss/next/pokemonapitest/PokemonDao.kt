package toss.next.pokemonapitest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDao {

    @Query("select * from pokemon")
    fun getAllPokemons(): List<Pokemon>

    @Query("select * from pokemon where id=(:id)")
    fun getPokemon(id: Int): Pokemon

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(pokemon: Pokemon)

    @Update
    fun updatePokemon(pokemon: Pokemon)
}
