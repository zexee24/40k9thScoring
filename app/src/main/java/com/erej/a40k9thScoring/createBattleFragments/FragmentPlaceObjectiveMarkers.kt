package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_create_place_objective_markers.*

class FragmentPlaceObjectiveMarkers(val battleObject:Battle): Fragment(R.layout.fragment_create_place_objective_markers) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewBattleMap.setImageResource(battleObject.primaryMission.setupImage)
    }
}