package com.example.restapiidemo.home.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.restapiidemo.R
import com.example.restapiidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this,navController)

    }

}

