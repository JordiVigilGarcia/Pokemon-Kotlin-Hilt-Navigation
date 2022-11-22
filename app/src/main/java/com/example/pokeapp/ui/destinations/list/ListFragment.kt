package com.example.pokeapp.ui.destinations.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeapp.commons.BaseFragment
import com.example.pokeapp.databinding.ListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment(){
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModelCharacters by viewModels()

    private lateinit var adapter: CharactersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.rickMortyResults.observe(viewLifecycleOwner, Observer {
            binding.recyclerViewPokemons.layoutManager = LinearLayoutManager(activity)
            adapter = CharactersAdapter(it, this)
            binding.recyclerViewPokemons.adapter = adapter
        })

    }
}