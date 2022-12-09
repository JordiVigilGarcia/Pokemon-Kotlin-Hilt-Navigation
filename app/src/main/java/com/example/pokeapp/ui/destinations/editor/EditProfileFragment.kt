package com.example.pokeapp.ui.destinations.editor

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokeapp.R
import com.example.pokeapp.commons.BaseFragment
import com.example.pokeapp.data.room.User
import com.example.pokeapp.databinding.EditprofileFragmentBinding
import com.example.pokeapp.ui.destinations.list.ViewModelCharacters
import com.example.pokeapp.ui.destinations.profie.ViewModelProfile
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileFragment : BaseFragment() {

    private var _binding: EditprofileFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModelProfile by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = EditprofileFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val name = binding.editTextTextPersonName.text.toString()
            val username = binding.editTextTextPersonName2.text.toString()
            val description = binding.editTextTextPersonName3.text.toString()
            initUser(name, username, description) }

    }

    private fun initUser(name: String, username: String, description: String) {
        val user = User(0, name, username, description)
        viewModel.createUser(user)
        Log.d("hola2", user.toString())
    }

    private fun inputCheck(name: String, username: String, description: String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(username) && description.isEmpty())
    }

}