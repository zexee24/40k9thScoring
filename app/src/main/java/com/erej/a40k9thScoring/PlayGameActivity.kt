package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_battle_secondaries.*
import kotlinx.android.synthetic.main.layout_battle_big.*


class PlayGameActivity:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)


        //set contentView
        setContentView(R.layout.layout_battle_big)

        //Fetch the battle date from MainActivity
        val battleObject = intent.getSerializableExtra("battle") as Battle

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentNav) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<NavigationView>(R.id.drawerBattleMenu).setupWithNavController(navController)


       /* val fragment = FragmentSecondaries(battleObject, supportFragmentManager)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentNav, fragment)
            commit()
        }

        */

    }

}
