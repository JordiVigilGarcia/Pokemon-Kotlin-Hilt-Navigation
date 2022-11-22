package com.example.pokeapp.ui.destinations.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokeapp.commons.BaseFragment
import com.example.pokeapp.databinding.FavoriteFragmentBinding
import com.example.pokeapp.databinding.ListFragmentBinding

class FavoriteFragment : BaseFragment(){
    private var _binding: FavoriteFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FavoriteFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}