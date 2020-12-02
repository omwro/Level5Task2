package nl.OmerErdem.madlvl5t2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import nl.OmerErdem.madlvl5t2.model.GameViewModel
import nl.omererdem.madlvl5t2.R

class MainActivity : AppCompatActivity() {

    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actionDeleteBtn -> {
                resetGames()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun resetGames() {
        val viewModel: GameViewModel by viewModels()
        viewModel.deleteAllGames()
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun enableBackButton(boolean: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(boolean)
    }

    fun enableDelete(boolean: Boolean) {
        menu?.findItem(R.id.actionDeleteBtn)?.isVisible = boolean
    }
}