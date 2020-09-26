package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.erej.a40k9thScoring.battleFragments.FragmentSecondaries
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.layout_battle_big.*


class PlayGameActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var battleObject: Battle

    private fun setTextView(battleObject: Battle) {
        textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)
        textViewP1Vp.text = battleObject.p1Vp.toString()
        textViewP2Vp.text = battleObject.p2Vp.toString()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)


        //set contentView
        setContentView(R.layout.layout_battle_big)

        //Fetch the battle date from MainActivity
        battleObject = intent.getSerializableExtra("battle") as Battle

        drawerBattleMenu.setNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.navHostFragment, FragmentSecondaries(battleObject,supportFragmentManager))
            commit()
        }


        setTextView(battleObject)

        buttonPrevious.setOnClickListener {
            battleViewModel.update(battleObject)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonNext.setOnClickListener {
            battleObject.roundCounter++
            battleViewModel.update(battleObject)
            setTextView(battleObject)

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.navHostFragment, FragmentSecondaries(battleObject,supportFragmentManager))
                commit()
            }

            if (battleObject.roundCounter > 5) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }


    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.fragment_battle_secondaries -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.navHostFragment, FragmentSecondaries(battleObject,supportFragmentManager))
                    commit()
                }
            }
            R.id.fragment_battle_primaries->{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.navHostFragment, FragmentSecondaries(battleObject,supportFragmentManager))
                    commit()
                }
            }
            R.id.fragment_battle_cp -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.navHostFragment, FragmentSecondaries(battleObject,supportFragmentManager))
                    commit()
                }
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }



}
