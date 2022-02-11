package io.github.sb689.summationlib

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import io.github.sb689.summationlib.R

import io.github.sb689.summationlib.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dataBinding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,
            container,
            false
        )

        dataBinding.buttonPlay.setOnClickListener { view: View ->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
//        dataBinding..setOnClickListener { view: View ->
//            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
//        }
        return dataBinding.root
    }


}