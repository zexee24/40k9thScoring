package com.erej.a40k9thscoring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.layout_battle_big.*

fun getFragment(battleObject: Battle, secondary : Secondary, counter: Int, counterNumber:Int, FragmentType : String): Fragment {
    return when(FragmentType){
        "Counter" -> FragmentSecondaryCounter(battleObject, secondary, counter, counterNumber)
        "DualCounter" -> FragmentSecondaryDualCounter(battleObject, secondary, counter,counterNumber)
        else -> FragmentSecondaryCounter(battleObject, secondary, counter, counterNumber)

    }


}

fun setupFragments(battleObject: Battle, secondaryList: List<Secondary>,supportFragmentManager: FragmentManager){

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
        textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)

        buttonPrevious.setOnClickListener{
            battleViewModel.update(battleObject)
            startActivity(Intent(this,MainActivity::class.java))
        }

        buttonNext.setOnClickListener{
            battleObject.roundCounter++
            battleViewModel.update(battleObject)
            textViewRoundCounter.text = resources.getString(R.string.Round, battleObject.roundCounter)



            if (battleObject.roundCounter == 5){
                startActivity(Intent(this,MainActivity::class.java))
            }

        }

    }

}