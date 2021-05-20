package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Mission
import com.erej.a40k9thScoring.classes.PrimaryList
import com.erej.a40k9thScoring.missionPackViewModel
import kotlinx.android.synthetic.main.fragment_create_select_mission.*

class FragmentDetermineMission(val battleObject:Battle): Fragment(R.layout.fragment_create_select_mission) {

    private val missionPacks = missionPackViewModel.allMissionPacks.value?.map { it.name }
    private val allMission = PrimaryList().missions
    private var missionList : MutableList<Mission> = mutableListOf(allMission[0])
    private lateinit var missionNameList : List<String>

    private fun updatePrimaryList(){
        missionList.clear()
        for (i in allMission) {

            if (i.missionSize == battleObject.battleType) {
                missionList.add(i)
            }
        }
        missionNameList = missionList.map {
            it.name
        }

        spinnerSelectMission.adapter = ArrayAdapter<String>(activity?.applicationContext!!, android.R.layout.simple_list_item_1, missionNameList)
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


        spinnerSelectMissionPack.adapter = ArrayAdapter<String>(activity?.applicationContext!!, android.R.layout.simple_list_item_1, missionPacks)
        spinnerSelectMissionPack.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.missionType = missionPacks[p2]
                updatePrimaryList()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                battleObject.missionType = missionPacks[0]
            }
        }
        spinnerSelectMission.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.primaryMission = missionList[p2]
                battleObject.primaryMissionP1 = battleObject.primaryMission.primaryObjective.copy()
                battleObject.primaryMissionP2 = battleObject.primaryMission.primaryObjective.copy()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


    }
}