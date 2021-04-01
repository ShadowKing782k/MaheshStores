package com.example.maheshstores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.maheshstores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.Intro)
        NavigationUI.setupActionBarWithNavController(this,navController)
        NavigationUI.setupWithNavController(Binding.navView, navController)
       drawerLayout = Binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.Intro)
        return  NavigationUI.navigateUp(navController, drawerLayout)
    }
}