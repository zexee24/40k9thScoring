package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_create_select_mission.*

class FragmentDetermineMission(val battleObject:Battle): Fragment(R.layout.fragment_create_select_mission) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = when (battleObject.battleType){
            "Combat patrol" -> R.drawable.combat_patrol
            "Incursion" -> R.drawable.incursion
            "Strike force" -> R.drawable.strike_force
            "Onslaught" -> R.drawable.onslaught
            else -> throw error("Error in mission types")
        }
        imageView.setImageResource(image)
        val missionPacks = listOf<String>("Core")
        spinnerSelectMissionPack.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, missionPacks)
    }
}