package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle

class FragmentDetermineAttackerAndDefender(val battleObject:Battle): Fragment(R.layout.fragment_create_determine_attacker_and_defender) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val k = battleObject
    }
}