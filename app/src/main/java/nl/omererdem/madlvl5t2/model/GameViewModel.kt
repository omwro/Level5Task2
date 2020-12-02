package nl.OmerErdem.madlvl5t2.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nl.OmerErdem.madlvl5t2.room.GameRepository

class GameViewModel(application: Application): AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameRepository = GameRepository(application.applicationContext)

    val games: LiveData<List<Game>> = gameRepository.getAllGames()

    fun insertGame(game: Game) {
        ioScope.launch { gameRepository.insertGame(game) }
    }

    fun deleteGame(game: Game) {
        ioScope.launch { gameRepository.deleteGame(game) }
    }

    fun deleteAllGames() {
        ioScope.launch { gameRepository.deleteAllGames() }
    }
}