package com.example.pokeapp.ui.destinations.profie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pokeapp.R
import com.example.pokeapp.commons.BaseFragment
import com.example.pokeapp.databinding.ProfileFragmentBinding

class ProfileFragment : BaseFragment() {

    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.imageEDIT.visibility = View.VISIBLE

        binding.toolbar.imageEDIT.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        })

    }
}