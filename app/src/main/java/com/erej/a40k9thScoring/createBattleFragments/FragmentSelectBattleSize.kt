package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.RandomNames
import com.erej.a40k9thScoring.Settings
import com.erej.a40k9thScoring.battleViewModel
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_create_select_battlesize.*

class FragmentSelectBattleSize(val battleObject:Battle): Fragment(R.layout.fragment_create_select_battlesize) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





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

        if (battleObject.p1Name == ""){
            var defaultName = Settings(activity?.applicationContext!!).getSetting("default_name")
            if (defaultName == "") {
                defaultName = RandomNames().getRandomName()
            }
            editTextP1Name.setText(defaultName)
        }else{
            editTextP1Name.hint = battleObject.p1Name
        }

        if (battleObject.p2Name == "" && Settings(activity?.applicationContext!!).getSettingBool("auto_generate_names")!!){
            editTextP2Name.setText(RandomNames().getRandomName())
        }else{
            editTextP2Name.hint = battleObject.p2Name
        }

    }
}