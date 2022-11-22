package com.example.pokeapp.ui.splash

import android.content.Intent
import android.os.Bundle
import com.example.pokeapp.commons.BaseActivity
import com.example.pokeapp.commons.Constants
import com.example.pokeapp.ui.home.HomeActivity
import com.example.pokeapp.databinding.SplashActivityBinding

class SplashActivity : BaseActivity() {

    private var _binding: SplashActivityBinding? = null

    private val binding get() = _binding!!
    override fun onViewCreated() {
        //Open HomeActivity with navigation after 2000 ms

        object: Thread(){
            override fun run(){
                try{
                    sleep(Constants.LOADING_SLEEP)
                }catch (ie: InterruptedException){
                    ie.printStackTrace()
                }finally {
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                    finish()
                }
            }
        }.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onViewCreated()

    }

}