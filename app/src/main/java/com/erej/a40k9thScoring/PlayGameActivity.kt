package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.erej.a40k9thScoring.battleFragments.FragmentCp
import com.erej.a40k9thScoring.battleFragments.FragmentPrimaries
import com.erej.a40k9thScoring.battleFragments.FragmentSecondaries
import com.erej.a40k9thScoring.battleFragments.FragmentSetup
import com.erej.a40k9thScoring.classes.Battle
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.layout_battle_big.*


class PlayGameActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var battleObject: Battle

    private fun setupFragment(){
        battleViewModel.update(battleObject)
        when(battleObject.openedFragment){
            0 -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.navHostFragment, FragmentSecondaries(battleObject,supportFragmentManager))
                    commit()
                    }
                }
            1 -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.navHostFragment, FragmentPrimaries(battleObject,supportFragmentManager))
                    commit()
                    }
                }
            2 -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.navHostFragment, FragmentCp(battleObject))
                    commit()
                    }
                }
            3 -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.navHostFragment, FragmentSetup(battleObject.primaryMission))
                    commit()
                }
            }
        }
    }

    private fun updateVP(){
        battleObject.p1Vp = battleObject.p1Secondary1.vp + battleObject.p1Secondary2.vp + battleObject.p1Secondary3.vp + battleObject.primaryMissionP1.primaryObjective.vp
        battleObject.p2Vp = battleObject.p2Secondary1.vp + battleObject.p2Secondary2.vp + battleObject.p2Secondary3.vp + battleObject.primaryMissionP2.primaryObjective.vp
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.fragment_battle_secondaries -> battleObject.openedFragment = 0

            R.id.fragment_battle_primaries -> battleObject.openedFragment = 1

            R.id.fragment_battle_cp -> battleObject.openedFragment = 2

            R.id.fragment_battle_setup -> battleObject.openedFragment = 3
        }
        setupFragment()
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setTextView() {
        textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)
        updateVP()
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


        setupFragment()
        setTextView()

        buttonOpenDrawer.setOnClickListener{
        drawer_layout.openDrawer(GravityCompat.START)
        }

        buttonPrevious.setOnClickListener {
            battleViewModel.update(battleObject)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonNext.setOnClickListener {
            battleObject.roundCounter++
            battleViewModel.update(battleObject)
            setTextView()
            setupFragment()

            if (battleObject.p1Secondary1.progressive) {battleObject.p1Secondary1.unCheck()}
            if (battleObject.p1Secondary2.progressive) {battleObject.p1Secondary2.unCheck()}
            if (battleObject.p1Secondary3.progressive) {battleObject.p1Secondary3.unCheck()}
            if (battleObject.p2Secondary1.progressive) {battleObject.p2Secondary1.unCheck()}
            if (battleObject.p2Secondary2.progressive) {battleObject.p2Secondary2.unCheck()}
            if (battleObject.p2Secondary3.progressive) {battleObject.p2Secondary3.unCheck()}

            if(battleObject.primaryMission.primaryObjective.progressive) {battleObject.primaryMissionP1.primaryObjective.unCheck()}
            if(battleObject.primaryMission.primaryObjective.progressive) {battleObject.primaryMissionP2.primaryObjective.unCheck()}



            if (battleObject.roundCounter > 5) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }


    }




}
