package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.battleViewModel
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_create_select_battlesize.*

class FragmentSelectBattleSize(val battleObject:Battle): Fragment(R.layout.fragment_create_select_battlesize) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextP1Name.hint = battleObject.p1Name
        editTextP2Name.hint = battleObject.p2Name

        editTextP1Name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                battleObject.p1Name = editTextP1Name.text.toString()
                battleViewModel.update(battleObject)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

        editTextP2Name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                battleObject.p2Name = editTextP2Name.text.toString()
                battleViewModel.update(battleObject)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        val missionTypes = listOf("Combat patrol", "Incursion", "Strike force", "Onslaught")
        spinnerSelectBattleSize.adapter = ArrayAdapter<String>(activity?.applicationContext!!, android.R.layout.simple_list_item_1, missionTypes)

        spinnerSelectBattleSize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.battleType = missionTypes[p2]
                battleViewModel.update(battleObject)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}