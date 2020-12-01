package nl.OmerErdem.madlvl5t2.ui

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
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

    fun setTitle(title: String) {
        this.title = title
    }

    fun enableBackButton(boolean: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(boolean)
    }

    fun enableDelete(boolean: Boolean) {
        menu?.findItem(R.id.actionDeleteBtn)?.isVisible = boolean
    }

    private fun resetGames() {

    }
}