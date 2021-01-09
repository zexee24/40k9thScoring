package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_create_determine_attacker_and_defender.*

class FragmentDetermineAttackerAndDefender(val battleObject:Battle): Fragment(R.layout.fragment_create_determine_attacker_and_defender) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinnerSelectAttacker.adapter = ArrayAdapter<String>(activity?.applicationContext!!, R.layout.support_simple_spinner_dropdown_item,listOf(battleObject.p1Name, battleObject.p2Name))

        spinnerSelectAttacker.setSelection(battleObject.attacker)

        spinnerSelectAttacker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                battleObject.attacker = position
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }
}