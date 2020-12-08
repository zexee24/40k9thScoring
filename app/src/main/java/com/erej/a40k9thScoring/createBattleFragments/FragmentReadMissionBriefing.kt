package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.battleViewModel
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_create_read_briefing.*

class FragmentReadMissionBriefing(val battleObject:Battle): Fragment(R.layout.fragment_create_read_briefing) {
    val mission = battleObject.primaryMission

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewSpecialRules.text = mission.missionRules
        textViewPrimaryName.text = mission.primaryObjective.name
        textViewPrimary.text = mission.primaryObjective.hint

        textViewSecondaryName.text = mission.secondaryObjective.name
        textViewSecondary.text = mission.secondaryObjective.hint
    }
}