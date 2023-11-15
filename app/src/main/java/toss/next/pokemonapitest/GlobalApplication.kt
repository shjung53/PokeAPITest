package toss.next.pokemonapitest

import android.app.Application

class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        PokemonRepository.initialize(this)
    }
}
