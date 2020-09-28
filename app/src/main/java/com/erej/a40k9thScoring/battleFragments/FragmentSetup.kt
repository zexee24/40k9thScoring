package com.erej.a40k9thScoring.battleFragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.PrimaryList
import kotlinx.android.synthetic.main.fragment_battle_setup.*


class FragmentSetup(val battleObject: Battle) : Fragment(R.layout.fragment_battle_setup) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mission = PrimaryList().missions[battleObject.primaryMission]

        imageViewBattleSetup.setImageResource(mission.setupImage)
        textViewMissionName.text = mission.name
        textViewBriefing.text = mission.briefing
    }

}