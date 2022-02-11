package io.github.sb689.summationlib

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import io.github.sb689.summationlib.R
import io.github.sb689.summationlib.databinding.FragmentGameCompleteBinding


class GameCompleteFragment : Fragment() {


    lateinit var gameStat: String
    lateinit var btnText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameCompleteBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_complete, container, false)
        val args = GameCompleteFragmentArgs.fromBundle(requireArguments())
        if(args.isWon) {
            gameStat = getString(R.string.game_won_text)
            btnText = getString(R.string.btn_won_text)
        }
        else {
            gameStat = getString(R.string.game_lost_text)
            btnText = getString(R.string.btn_lost_text)
        }

        binding.gameStat = this

        binding.btnRestart.setOnClickListener { view:View ->
            view.findNavController().navigate(GameCompleteFragmentDirections.actionGameCompleteFragmentToGameFragment())
        }


        return binding.root

    }


}