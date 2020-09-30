package com.erej.a40k9thScoring.battleFragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Primary
import kotlinx.android.synthetic.main.fragment_battle_setup.*


class FragmentSetup(private val primaryMission: Primary) : Fragment(R.layout.fragment_battle_setup) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        imageViewBattleSetup.setImageResource(primaryMission.setupImage)
        textViewMissionName.text = primaryMission.name
        textViewBriefing.text = primaryMission.briefing
    }

}