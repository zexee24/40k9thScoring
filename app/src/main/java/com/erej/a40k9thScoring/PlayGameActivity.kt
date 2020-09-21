package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
import kotlinx.android.synthetic.main.layout_battle_big.*
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'


class PlayGameActivity:AppCompatActivity() {

    private fun setupFragments(battleObject: Battle, supportFragmentManager: FragmentManager){

        val secondaryList = SecondaryList().getSecondaries()

        //store fragments
        val p1Fragment1 = getFragment(battleObject,secondaryList[battleObject.p1Secondary1],battleObject.p1Secondary1Counter1, 1, secondaryList[battleObject.p1Secondary1].fragmentType)
        val p1Fragment2 = getFragment(battleObject,secondaryList[battleObject.p1Secondary2],battleObject.p1Secondary1Counter1, 2, secondaryList[battleObject.p1Secondary2].fragmentType)
        val p1Fragment3 = getFragment(battleObject,secondaryList[battleObject.p1Secondary3],battleObject.p1Secondary1Counter1, 3, secondaryList[battleObject.p1Secondary3].fragmentType)

        val p2Fragment1 = getFragment(battleObject,secondaryList[battleObject.p2Secondary1],battleObject.p1Secondary1Counter1, 4, secondaryList[battleObject.p2Secondary1].fragmentType)
        val p2Fragment2 = getFragment(battleObject,secondaryList[battleObject.p2Secondary2],battleObject.p1Secondary1Counter1, 5, secondaryList[battleObject.p2Secondary2].fragmentType)
        val p2Fragment3 = getFragment(battleObject,secondaryList[battleObject.p2Secondary3],battleObject.p1Secondary1Counter1, 6, secondaryList[battleObject.p2Secondary3].fragmentType)




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
    }

    private fun getFragment(battleObject: Battle, secondary : Secondary, secondaryCounter: Int, counterNumber:Int, FragmentType : String): Fragment {
        return when(FragmentType){
            "Counter" -> FragmentSecondaryCounter(battleObject, secondary, secondaryCounter, counterNumber)
            "DualCounter" -> FragmentSecondaryDualCounter(battleObject, secondary, secondaryCounter,counterNumber)
            "OneTimeCheckMark" -> FragmentSecondaryOnetimeCheckMark(battleObject,secondary,secondaryCounter, counterNumber)
            "OneCheckMark" -> FragmentSecondaryOneCheckMark(battleObject,secondary,secondaryCounter, counterNumber)
            "ThreeOneTimeCheckMarks" -> FragmentSecondaryThreeOnetimeCheckMarks(battleObject, secondary, secondaryCounter, counterNumber)
            "TwoOneTimeCheckMarks" -> FragmentSecondaryTwoOnetimeCheckMarks(battleObject, secondary, secondaryCounter, counterNumber)
            "TwoCheckMarks" -> FragmentSecondaryTwoCheckMarks(battleObject, secondary, secondaryCounter, counterNumber)
            "Empty" -> FragmentSecondaryNone()
            else -> FragmentSecondaryNone()

        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
=======
        setTheme(R.style.AppTheme_NoActionBar)

>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'
        //set contentView
        setContentView(R.layout.layout_battle_big)

        //Fetch the battle date from MainActivity
        val battleObject = intent.getSerializableExtra("battle") as Battle

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
>>>>>>> 6a5579d... Merge remote-tracking branch 'origin/master'

        //set roundCounter
        textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)

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
            textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)
<<<<<<< HEAD



<<<<<<< HEAD

>>>>>>> 1fac747... Working...
            startActivity(Intent(this,MainActivity::class.java))
=======
=======
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

        }

    }

}