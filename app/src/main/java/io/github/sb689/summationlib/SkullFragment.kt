package io.github.sb689.summationlib

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import io.github.sb689.summationlib.databinding.FragmentSkullBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SkullFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SkullFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSkullBinding>(inflater, R.layout.fragment_skull, container, false)
        binding.tvSkullDetail.movementMethod = LinkMovementMethod.getInstance()


        return binding.root
    }


}