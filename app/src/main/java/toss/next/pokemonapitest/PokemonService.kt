package toss.next.pokemonapitest

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{name}/")
    suspend fun fetchPokemonByName(@Path(value = "name") name: String): PokemonResponse

    @GET("pokemon/{id}/")
    suspend fun fetchPokemonById(@Path(value = "id") id: String): PokemonResponse

    @GET("pokemon/")
    suspend fun fetchPokemonList(@Query(value = "limit") limit: String = "151"): PokemonListResponse

    companion object {
        val gsonConverter: GsonConverterFactory = GsonConverterFactory.create()
        val service = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(
            gsonConverter
        ).client(OkHttpClient.client).build().create(PokemonService::class.java)

    }
}
