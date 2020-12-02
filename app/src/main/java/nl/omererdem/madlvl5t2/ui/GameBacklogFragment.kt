package nl.OmerErdem.madlvl5t2.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_game_backlog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import nl.OmerErdem.madlvl5t2.model.Game
import nl.OmerErdem.madlvl5t2.model.GameViewModel
import nl.OmerErdem.madlvl5t2.room.GameRepository
import nl.OmerErdem.madlvl5t2.utils.GameAdapter
import nl.omererdem.madlvl5t2.R

// List of the games in the history
val games = arrayListOf<Game>()

// Adapter for the game object
val gameAdapter = GameAdapter(games)

class GameBacklogFragment : Fragment() {
    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_backlog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = (activity as MainActivity)
        activity.setTitle("Game Backlog")
        activity.enableBackButton(false)
        activity.enableDelete(true)

        view.findViewById<FloatingActionButton>(R.id.fabAddGame).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        rvGames.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvGames.adapter = gameAdapter

        viewModel.games.observe(viewLifecycleOwner, {
            savedGames ->
            games.clear()
            games.addAll(savedGames)
            gameAdapter.notifyDataSetChanged()
        })
    }
}