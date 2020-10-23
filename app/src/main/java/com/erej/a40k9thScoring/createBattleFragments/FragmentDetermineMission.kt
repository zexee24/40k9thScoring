package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.battleViewModel
import com.erej.a40k9thScoring.classes.Battle

class FragmentDetermineMission(val battleObject:Battle): Fragment(R.layout.fragment_create_select_mission) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}