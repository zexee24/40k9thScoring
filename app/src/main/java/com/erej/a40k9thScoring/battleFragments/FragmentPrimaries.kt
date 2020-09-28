package com.erej.a40k9thScoring.battleFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.PrimaryList
import com.erej.a40k9thScoring.secondaryfragments.FragmentSecondaryNone
import com.erej.a40k9thScoring.secondaryfragments.FragmentSecondaryThreeCheckMarks
import kotlinx.android.synthetic.main.fragment_battle_primary.*

class FragmentPrimaries(
    private val battleObject: Battle,
    private val supportFragmentManager: FragmentManager
) :Fragment(R.layout.fragment_battle_primary) {

    private val mission = PrimaryList().missions[battleObject.primaryMission]


    private fun getFragment(
        counter: Int,
        counterNumber: Int
    ): Fragment{
        return when (mission.primaryObjective.fragmentType){
            "Empty" ->  FragmentSecondaryNone()
            "ThreeCheckMarks" -> FragmentSecondaryThreeCheckMarks(battleObject, mission.primaryObjective, counter, counterNumber )
            else -> throw error("Wrong Primary Name")
        }
    }

    private fun setupFragments(){
        val p1Fragment = getFragment(battleObject.p1PrimaryCounter1, 31)
        val p2Fragment = getFragment(battleObject.p2PrimaryCounter1, 32)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_missionObjectiveP1, p1Fragment)
            replace(R.id.fl_missionObjectiveP2, p2Fragment)
            commit()
        }
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewMissionName.text = mission.name
        setupFragments()

    }
}