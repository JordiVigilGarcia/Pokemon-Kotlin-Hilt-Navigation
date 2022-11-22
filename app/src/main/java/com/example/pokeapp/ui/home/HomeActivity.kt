package com.example.pokeapp.ui.home

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pokeapp.R
import com.example.pokeapp.commons.BaseActivity
import com.example.pokeapp.databinding.HomeActivityBinding
import dagger.hilt.android.AndroidEntryPoint

class HomeActivity : BaseActivity() {

    private var _binding: HomeActivityBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onViewCreated()

    }

    override fun onViewCreated() {
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.navigationFragment) as NavHostFragment? ?: return
        val navController = host.navController
        binding.bottomnav.setupWithNavController(navController)
    }

}