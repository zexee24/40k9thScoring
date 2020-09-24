package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_battle_secondaries.*
import kotlinx.android.synthetic.main.layout_battle_big.*


class PlayGameActivity:AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)


        //set contentView
        setContentView(R.layout.layout_battle_big)

        //Fetch the battle date from MainActivity
        val battleObject = intent.getSerializableExtra("battle") as Battle

        //navController = findNavController(R.id.fragmentNav)
        //appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout)

        //drawerBattleMenu.setupWithNavController(navController)



    }

}
