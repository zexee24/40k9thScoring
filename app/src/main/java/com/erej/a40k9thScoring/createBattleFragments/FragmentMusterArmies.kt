package com.erej.a40k9thScoring.createBattleFragments

import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.battleViewModel
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_create_muster_armies.*

class FragmentMusterArmies(val battleObject:Battle): Fragment(R.layout.fragment_create_muster_armies) {

    override fun onDestroyView() {
        try{
            battleObject.p1Cp = editTextNumber.text.toString().toInt()
            battleObject.p2Cp = editTextNumber2.text.toString().toInt()
        }catch (e: NumberFormatException){
            battleObject.p1Cp = 0
            battleObject.p2Cp = 0
        }

        battleViewModel.update(battleObject)
        super.onDestroyView()
    }
}