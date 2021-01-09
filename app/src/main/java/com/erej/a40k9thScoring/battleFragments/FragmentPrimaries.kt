package com.erej.a40k9thScoring.battleFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Objective
import com.erej.a40k9thScoring.objectiveFragments.FragmentObjectiveNone
import com.erej.a40k9thScoring.objectiveFragments.FragmentObjectiveThreeCheckMarks
import kotlinx.android.synthetic.main.fragment_battle_primary.*

class FragmentPrimaries(
    private val battleObject: Battle,
    private val supportFragmentManager: FragmentManager
) :Fragment(R.layout.fragment_battle_primary) {

    private val primary = battleObject.primaryMission


    private fun getFragment(
        mission: Objective
    ): Fragment{

        return when (mission.fragmentType){
            "Empty" ->  FragmentObjectiveNone()
            "ThreeCheckMarks" -> FragmentObjectiveThreeCheckMarks(mission)
            else -> throw error("Wrong primary fragment type")
        }
    }

    private fun setupFragments(){
        val p1Fragment = getFragment(battleObject.primaryMissionP1)
        val p2Fragment = getFragment(battleObject.primaryMissionP2)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_missionObjectiveP1, p1Fragment)
            replace(R.id.fl_missionObjectiveP2, p2Fragment)
            commit()
        }
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       textViewMissionName.text = primary.name
       setupFragments()

    }
}