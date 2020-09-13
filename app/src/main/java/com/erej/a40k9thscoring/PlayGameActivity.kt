package com.erej.a40k9thscoring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.layout_battle_big.*

fun getSecondaryCounter(battleObject: Battle, counterNumber: Int):Int{

    return when(counterNumber){
        1 -> battleObject.p1Secondary1Counter
        2 -> battleObject.p1Secondary2Counter
        3 -> battleObject.p1Secondary3Counter

        4 -> battleObject.p2Secondary1Counter
        5 -> battleObject.p2Secondary2Counter
        6 -> battleObject.p2Secondary3Counter
        else -> throw error("Problem in counter Indexing")
    }
}

fun getSecondaryVpCounter(battleObject: Battle, counterNumber: Int):Int{

    return when(counterNumber){
        1 -> battleObject.p1Secondary1Vp
        2 -> battleObject.p1Secondary2Vp
        3 -> battleObject.p1Secondary3Vp

        4 -> battleObject.p2Secondary1Vp
        5 -> battleObject.p2Secondary2Vp
        6 -> battleObject.p2Secondary3Vp
        else -> throw error("Problem in counter Indexing")
    }
}

fun setSecondaryCounter(battleObject: Battle, counterNumber: Int, counter: Int){

    when(counterNumber){
        1 -> battleObject.p1Secondary1Counter = counter
        2 -> battleObject.p1Secondary2Counter = counter
        3 -> battleObject.p1Secondary3Counter = counter

        4 -> battleObject.p2Secondary1Counter = counter
        5 -> battleObject.p2Secondary2Counter = counter
        6 -> battleObject.p2Secondary3Counter = counter
        else -> throw error("Problem in counter Indexing")
    }
    battleViewModel.update(battleObject)
}

fun setSecondaryVpCounter(battleObject: Battle, counterNumber: Int, counter: Int){

    when(counterNumber){
        1 -> battleObject.p1Secondary1Vp = counter
        2 -> battleObject.p1Secondary2Vp = counter
        3 -> battleObject.p1Secondary3Vp = counter

        4 -> battleObject.p2Secondary1Vp = counter
        5 -> battleObject.p2Secondary2Vp = counter
        6 -> battleObject.p2Secondary3Vp = counter
        else -> throw error("Problem in counter Indexing")
    }
    battleViewModel.update(battleObject)
}

fun getFragment(battleObject: Battle, secondary : Secondary, counter: Int, counterNumber:Int, FragmentType : String): Fragment {
    return when(FragmentType){
        "Counter" -> FragmentSecondaryCounter(battleObject, secondary, counter, counterNumber)
        "DualCounter" -> FragmentSecondaryDualCounter(battleObject, secondary, counter,counterNumber)
        else -> FragmentSecondaryCounter(battleObject, secondary, counter, counterNumber)

    }


}

fun setupFragments(battleObject: Battle, secondaryList: List<Secondary>,supportFragmentManager: FragmentManager){

    //store fragments
    val p1Fragment1 = getFragment(battleObject,secondaryList[battleObject.p1Secondary1],battleObject.p1Secondary1Counter, 1, secondaryList[battleObject.p1Secondary1].fragmentType)
    val p1Fragment2 = getFragment(battleObject,secondaryList[battleObject.p1Secondary2],battleObject.p1Secondary1Counter, 2, secondaryList[battleObject.p1Secondary2].fragmentType)
    val p1Fragment3 = getFragment(battleObject,secondaryList[battleObject.p1Secondary3],battleObject.p1Secondary1Counter, 3, secondaryList[battleObject.p1Secondary3].fragmentType)

    val p2Fragment1 = getFragment(battleObject,secondaryList[battleObject.p2Secondary1],battleObject.p1Secondary1Counter, 4, secondaryList[battleObject.p2Secondary1].fragmentType)
    val p2Fragment2 = getFragment(battleObject,secondaryList[battleObject.p2Secondary2],battleObject.p1Secondary1Counter, 5, secondaryList[battleObject.p2Secondary2].fragmentType)
    val p2Fragment3 = getFragment(battleObject,secondaryList[battleObject.p2Secondary3],battleObject.p1Secondary1Counter, 6, secondaryList[battleObject.p2Secondary3].fragmentType)

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

class PlayGameActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)

        //set contentView
        setContentView(R.layout.layout_battle_big)

        //Fetch the battle date from MainActivity
        val battleObject = intent.getSerializableExtra("battle") as Battle

        //get a super ugly list of secondaries ... but it works ... for now
        val secondaryList = SecondaryList().getSecondaries()

        setupFragments(battleObject, secondaryList, supportFragmentManager)

        //set roundCounter
        val roundString = resources.getString(R.string.Round)
        textViewRoundCounter.text = "$roundString ${battleObject.roundCounter}"

        buttonPrevious.setOnClickListener{
            battleViewModel.update(battleObject)
            startActivity(Intent(this,MainActivity::class.java))
        }

        buttonNext.setOnClickListener{
            battleObject.roundCounter++
            battleViewModel.update(battleObject)
            textViewRoundCounter.text = "$roundString ${battleObject.roundCounter}"

            if (battleObject.roundCounter == 5){
                startActivity(Intent(this,MainActivity::class.java))
            }

        }

    }

}