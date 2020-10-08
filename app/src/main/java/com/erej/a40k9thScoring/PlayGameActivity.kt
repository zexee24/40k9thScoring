package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import kotlinx.android.synthetic.main.fragment_battle.*
=======
=======
import androidx.fragment.app.Fragment
<<<<<<< HEAD
>>>>>>> c3fa666... Merge remote-tracking branch 'origin/master'
import kotlinx.android.synthetic.main.layout_battle_big.*
<<<<<<< HEAD
>>>>>>> 1fc6641... Merge remote-tracking branch 'origin/master'
=======
import java.lang.ref.Reference
import kotlin.reflect.KClass
>>>>>>> 1fac747... Working...
=======
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
=======
import androidx.core.view.GravityCompat
import com.erej.a40k9thScoring.battleFragments.FragmentCp
import com.erej.a40k9thScoring.battleFragments.FragmentPrimaries
import com.erej.a40k9thScoring.battleFragments.FragmentSecondaries
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8fe89ef... Interface switching implemented - next the interfaces
=======
=======
import com.erej.a40k9thScoring.battleFragments.FragmentSetup
>>>>>>> a3e2bc7... Added BattleSetup images + flavour
import com.erej.a40k9thScoring.classes.Battle
>>>>>>> 69259f0... Primaries implemented time to A. go fuck myself and B. do it well next time because this shit is unmainteinable
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.layout_battle_big.*
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'


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

    private fun nextTurn(){
        when(battleObject.turnCounter){
            0 -> {
                battleObject.phaseCounter = 0
                battleObject.turnCounter++
            }
            1 -> {
                battleObject.phaseCounter = 0
                battleObject.turnCounter = 0
                battleObject.roundCounter++
            }
        }
        setRoundText()
    }

    private fun setRoundText(){

        var roundText = "Turn "
        roundText += battleObject.roundCounter

        roundText += " "
        roundText += when(battleObject.phaseCounter){
            0 -> getString(R.string.command)
            1 -> getString(R.string.movement)
            2 -> getString(R.string.psychic)
            3 -> getString(R.string.shooting)
            4 -> getString(R.string.charge)
            5 -> getString(R.string.fight)
            6 -> getString(R.string.endOfRound)
            7 -> {
                nextTurn()
                return
            }
            else -> throw error("in phase indexing")
        }
        roundText += " "
        roundText += when(battleObject.turnCounter){
            0 -> battleObject.p1Name
            1 -> battleObject.p2Name
            else -> throw error("Error in turn indexing")
        }

        textViewRoundCounter.text = roundText

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

        updateVP()
        textViewP1Vp.text = battleObject.p1Vp.toString()
        textViewP2Vp.text = battleObject.p2Vp.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
=======
        setTheme(R.style.AppTheme_NoActionBar)

<<<<<<< HEAD
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'
=======

>>>>>>> 367b9bc... Menu very much in progress
        //set contentView
        setContentView(R.layout.layout_battle_big)

        //Fetch the battle date from MainActivity
        battleObject = intent.getSerializableExtra("battle") as Battle

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD:app/src/main/java/com/erej/a40k9thscoring/PlayGameActivity.kt
<<<<<<< HEAD
        val firstFragment = BattleFragment(battleObject)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,firstFragment)
            intent.

=======
        //get a super ugly list of secondaries ... but it works ... for now
=======
        //get a super ugly list of secondaries ... but it works ... i guess ... for now
>>>>>>> f308786... Renamed as shit:app/src/main/java/com/erej/a40k9thScoring/PlayGameActivity.kt
        val secondaryList = SecondaryList().getSecondaries()

<<<<<<< HEAD
<<<<<<< HEAD
        //store fragments
<<<<<<< HEAD
<<<<<<< HEAD
        val p1Fragment1 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary1],1 )
        val p1Fragment2 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary2],2 )
        val p1Fragment3 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary2],3 )
>>>>>>> 1fc6641... Merge remote-tracking branch 'origin/master'
=======
        val p1Fragment1 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary1],battleObject.p1Secondary1Counter )
        val p1Fragment2 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary2],battleObject.p1Secondary2Counter )
        val p1Fragment3 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary3],battleObject.p1Secondary3Counter )
>>>>>>> c3fa666... Merge remote-tracking branch 'origin/master'

        val p2Fragment1 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary1],4 )
        val p2Fragment2 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary2],5 )
        val p2Fragment3 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary3],6 )
=======

        val p1Fragment1 = getFragment(battleObject,secondaryList[battleObject.p1Secondary1],battleObject.p1Secondary1Counter, 1, secondaryList[battleObject.p1Secondary1].fragmentType)
        val p1Fragment2 = getFragment(battleObject,secondaryList[battleObject.p1Secondary2],battleObject.p1Secondary1Counter, 2, secondaryList[battleObject.p1Secondary2].fragmentType)
        val p1Fragment3 = getFragment(battleObject,secondaryList[battleObject.p1Secondary3],battleObject.p1Secondary1Counter, 3, secondaryList[battleObject.p1Secondary3].fragmentType)

        val p2Fragment1 = getFragment(battleObject,secondaryList[battleObject.p2Secondary1],battleObject.p1Secondary1Counter, 4, secondaryList[battleObject.p2Secondary1].fragmentType)
        val p2Fragment2 = getFragment(battleObject,secondaryList[battleObject.p2Secondary2],battleObject.p1Secondary1Counter, 5, secondaryList[battleObject.p2Secondary2].fragmentType)
        val p2Fragment3 = getFragment(battleObject,secondaryList[battleObject.p2Secondary3],battleObject.p1Secondary1Counter, 6, secondaryList[battleObject.p2Secondary3].fragmentType)
=======
        setupFragments(battleObject, secondaryList, supportFragmentManager)
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'
=======
        setupFragments(battleObject, supportFragmentManager)
<<<<<<< HEAD
>>>>>>> 6a5579d... Merge remote-tracking branch 'origin/master'

        //set roundCounter
        textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)
=======
        setTextView(battleObject)
>>>>>>> 83b5257... All exept banners working.

<<<<<<< HEAD

>>>>>>> 0db018a... Merge remote-tracking branch 'origin/master'


        //set fragments
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFirstFragment,p1Fragment1)
            replace(R.id.flSecondFragment,p1Fragment2)
            replace(R.id.flThirdFragment,p1Fragment3)

            replace(R.id.flFourthFragment,p2Fragment1)
            replace(R.id.flFifthFragment,p2Fragment2)
            replace(R.id.flSixthFragment,p2Fragment3)
            commit()
        }
        supportFragmentManager

        buttonNext.setOnClickListener{
<<<<<<< HEAD
=======

=======
        buttonPrevious.setOnClickListener{
            battleViewModel.update(battleObject)
            startActivity(Intent(this,MainActivity::class.java))
        }

        buttonNext.setOnClickListener{
            battleObject.roundCounter++
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'
            battleViewModel.update(battleObject)
<<<<<<< HEAD
            textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)
<<<<<<< HEAD



<<<<<<< HEAD

>>>>>>> 1fac747... Working...
            startActivity(Intent(this,MainActivity::class.java))
=======
=======
=======
            setTextView(battleObject)
>>>>>>> 83b5257... All exept banners working.
            setupFragments(battleObject,supportFragmentManager)
<<<<<<< HEAD
>>>>>>> 6a5579d... Merge remote-tracking branch 'origin/master'
            if (battleObject.roundCounter == 5){
=======
            if (battleObject.roundCounter > 5){
>>>>>>> 5c39fd9... 3 Check Mark counter done
                startActivity(Intent(this,MainActivity::class.java))
            }
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'
=======
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentNav) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<NavigationView>(R.id.drawerBattleMenu).setupWithNavController(navController)
=======
        //navController = findNavController(R.id.fragmentNav)
        //appBarConfiguration = AppBarConfiguration(navController.graph, drawer_layout)
>>>>>>> b006708... Such buggy
=======
>>>>>>> 0bb401c... Got to actually learn drawer navigation
=======
        drawerBattleMenu.setNavigationItemSelectedListener(this)
>>>>>>> 8fe89ef... Interface switching implemented - next the interfaces


        setRoundText()
        setupFragment()
        setTextView()

        buttonOpenDrawer.setOnClickListener{
        drawer_layout.openDrawer(GravityCompat.START)
        }

        buttonExit.setOnClickListener {
            battleViewModel.update(battleObject)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonNext.setOnClickListener {
            battleObject.phaseCounter++
            setRoundText()
            setTextView()
            battleViewModel.update(battleObject)
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

<<<<<<< HEAD
<<<<<<< HEAD
       /* val fragment = FragmentSecondaries(battleObject, supportFragmentManager)
>>>>>>> 367b9bc... Menu very much in progress
=======
>>>>>>> b006708... Such buggy
=======
        }
>>>>>>> 0bb401c... Got to actually learn drawer navigation


    }




}
