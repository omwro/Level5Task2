package nl.OmerErdem.madlvl5t2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_add_game.*
import nl.OmerErdem.madlvl5t2.model.Game
import nl.OmerErdem.madlvl5t2.model.GameViewModel
import nl.omererdem.madlvl5t2.R
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {
    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = (activity as MainActivity)
        activity.setTitle("Add Game")
        activity.enableBackButton(true)
        activity.enableDelete(false)

        view.findViewById<FloatingActionButton>(R.id.fabSaveGame).setOnClickListener {
            if (formIsValid(activity)) {
                val game = Game(
                    etTitle.text.toString(),
                    etPlatform.text.toString(),
                    Date(
                        etYear.text.toString().toInt(),
                        etMonth.text.toString().toInt(),
                        etDay.text.toString().toInt()
                    )
                )
                viewModel.insertGame(game)
                games.add(game)
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                Toast.makeText(activity.applicationContext, game.title+" has been added", Toast.LENGTH_LONG).show()
                gameAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun formIsValid(activity: MainActivity): Boolean {
        val context = activity.applicationContext
        try {
            if (etTitle.text.isNullOrBlank()) {
                Toast.makeText(context, "Please fill in a Title", Toast.LENGTH_LONG).show()
                return false
            }
            if (etPlatform.text.isNullOrBlank()) {
                Toast.makeText(context, "Please fill in a Platform", Toast.LENGTH_LONG).show()
                return false
            }
            if (etDay.text.isNullOrBlank() || etMonth.text.isNullOrBlank() || etYear.text.isNullOrBlank()) {
                Toast.makeText(context, "Please fill in a Date", Toast.LENGTH_LONG).show()
                return false
            }
            try {
                Calendar.getInstance().set(
                    etYear.text.toString().toInt(),
                    etMonth.text.toString().toInt(),
                    etDay.text.toString().toInt()
                )
            } catch (e: Exception) {
                Toast.makeText(context, "Please fill in a valid Date", Toast.LENGTH_LONG).show()
                return false
            }
            return true
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            return false
        }
    }
}