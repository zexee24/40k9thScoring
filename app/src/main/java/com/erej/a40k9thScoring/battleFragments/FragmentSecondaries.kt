package com.erej.a40k9thScoring.battleFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Objective
import com.erej.a40k9thScoring.classes.SecondaryList
import com.erej.a40k9thScoring.secondaryfragments.*

class FragmentSecondaries(
    private val battleObject: Battle,
    private val supportFragmentManager: FragmentManager
) :Fragment(R.layout.fragment_battle_secondaries) {

    private fun getFragment(
        battleObject: Battle,
        objective: Objective,
        secondaryCounter: Int,
        counterNumber: Int,
        FragmentType: String
    ): Fragment {
        return when (FragmentType) {
            "Counter" -> FragmentSecondaryCounter(
                battleObject,
                objective,
                secondaryCounter,
                counterNumber
            )
            "DualCounter" -> FragmentSecondaryDualCounter(
                battleObject,
                objective,
                secondaryCounter,
                counterNumber
            )
            "OneTimeCheckMark" -> FragmentSecondaryOnetimeCheckMark(
                battleObject,
                objective,
                secondaryCounter,
                counterNumber
            )
            "OneCheckMark" -> FragmentSecondaryOneCheckMark(
                battleObject,
                objective,
                secondaryCounter,
                counterNumber
            )
            "ThreeOneTimeCheckMarks" -> FragmentSecondaryThreeOnetimeCheckMarks(
                battleObject,
                objective,
                secondaryCounter,
                counterNumber
            )
            "TwoOneTimeCheckMarks" -> FragmentSecondaryTwoOnetimeCheckMarks(
                battleObject,
                objective,
                secondaryCounter,
                counterNumber
            )
            "TwoCheckMarks" -> FragmentSecondaryTwoCheckMarks(
                battleObject,
                objective,
                secondaryCounter,
                counterNumber
            )
            "Empty" -> FragmentSecondaryNone()
            else -> FragmentSecondaryNone()

        }


    }

    private fun setupFragments(battleObject: Battle, supportFragmentManager: FragmentManager) {

        val secondaryList = SecondaryList().getSecondaries

        //store fragments
        val p1Fragment1 = getFragment(
            battleObject,
            secondaryList[battleObject.p1Secondary1],
            battleObject.p1Secondary1Counter1,
            1,
            secondaryList[battleObject.p1Secondary1].fragmentType
        )
        val p1Fragment2 = getFragment(
            battleObject,
            secondaryList[battleObject.p1Secondary2],
            battleObject.p1Secondary1Counter1,
            2,
            secondaryList[battleObject.p1Secondary2].fragmentType
        )
        val p1Fragment3 = getFragment(
            battleObject,
            secondaryList[battleObject.p1Secondary3],
            battleObject.p1Secondary1Counter1,
            3,
            secondaryList[battleObject.p1Secondary3].fragmentType
        )

        val p2Fragment1 = getFragment(
            battleObject,
            secondaryList[battleObject.p2Secondary1],
            battleObject.p1Secondary1Counter1,
            4,
            secondaryList[battleObject.p2Secondary1].fragmentType
        )
        val p2Fragment2 = getFragment(
            battleObject,
            secondaryList[battleObject.p2Secondary2],
            battleObject.p1Secondary1Counter1,
            5,
            secondaryList[battleObject.p2Secondary2].fragmentType
        )
        val p2Fragment3 = getFragment(
            battleObject,
            secondaryList[battleObject.p2Secondary3],
            battleObject.p1Secondary1Counter1,
            6,
            secondaryList[battleObject.p2Secondary3].fragmentType
        )


        //set fragments
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFirstFragment, p1Fragment1)
            replace(R.id.flSecondFragment, p1Fragment2)
            replace(R.id.flThirdFragment, p1Fragment3)

            replace(R.id.flFourthFragment, p2Fragment1)
            replace(R.id.flFifthFragment, p2Fragment2)
            replace(R.id.flSixthFragment, p2Fragment3)
            commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFragments(battleObject, supportFragmentManager)
    }
}