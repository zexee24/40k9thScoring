package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Mission
import com.erej.a40k9thScoring.classes.MissionPack
import com.erej.a40k9thScoring.missionPackViewModel
import kotlinx.android.synthetic.main.fragment_create_select_mission.*

class FragmentDetermineMission(val battleObject:Battle): Fragment(R.layout.fragment_create_select_mission) {

    private lateinit var  missionPacks : List<MissionPack>
    private var missionPackNameList : List<String> = listOf()
    private lateinit var  availableMissions: List<Mission>
    private lateinit var availableMissionNameList : List<String>
    private lateinit var missionPack : MissionPack

    private fun updatePrimaryList(){
        val tempList = mutableListOf<Mission>()
        for (i in missionPack.missions){
            if (i.missionSize == battleObject.battleType){
                tempList.add(i)
            }
        }
        availableMissions = tempList.toList()
        availableMissionNameList = availableMissions.map { it.name }
        spinnerSelectMission.adapter = ArrayAdapter<String>(activity?.applicationContext!!, android.R.layout.simple_list_item_1, availableMissionNameList)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = when (battleObject.battleType){
            "Combat patrol" -> R.drawable.combat_patrol
            "Incursion" -> R.drawable.incursion
            "Strike force" -> R.drawable.strike_force
            "Onslaught" -> R.drawable.onslaught
            else -> throw error("Error in mission types in $this")
        }
        imageViewBattleMap.setImageResource(image)

        missionPackViewModel.allMissionPacks.observe(viewLifecycleOwner, Observer {
            it?.let { missionPacks = it }
            missionPackNameList = missionPacks.map { it.name }
            spinnerSelectMissionPack.adapter = ArrayAdapter<String>(activity?.applicationContext!!, android.R.layout.simple_list_item_1, missionPackNameList)
        })

        spinnerSelectMissionPack.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                missionPack = missionPacks[p2]
                updatePrimaryList()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                missionPack = missionPacks[0]
                updatePrimaryList()
            }
        }

        spinnerSelectMission.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.primaryMission = availableMissions[p2]
                battleObject.primaryMissionP1 = battleObject.primaryMission.primaryObjective.copy()
                battleObject.primaryMissionP2 = battleObject.primaryMission.primaryObjective.copy()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }


    }
}