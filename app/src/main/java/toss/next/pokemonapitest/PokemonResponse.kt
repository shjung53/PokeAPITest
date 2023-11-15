package toss.next.pokemonapitest

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: String,
    val name: String,
    @SerializedName("sprites") val imageUrl: PokemonImage,
)

data class PokemonImage(
    @SerializedName("other") val bigImage: BigImage,
)

data class BigImage(
    @SerializedName("home") val defaultImage: DefaultImage,
)

data class DefaultImage(
    @SerializedName("front_default") val frontDefault: String,
)

data class PokemonListResponse(
    val count: Int,
    val results: List<PokemonResponse>
)
