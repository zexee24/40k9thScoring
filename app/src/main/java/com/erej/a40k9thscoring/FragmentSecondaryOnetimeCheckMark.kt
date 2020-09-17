package com.erej.a40k9thscoring

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one_checkmark.*

class FragmentSecondaryOnetimeCheckMark(private val battleObject: Battle, private val secondary: Secondary, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(R.layout.fragment_one_checkmark){
    private fun updateVP (){
        battleObject.secondaryToVpOneTimeCheckMark(secondary,counterNumber,secondaryCounter)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)
        textViewTitle.text = secondary.name
        textViewdescription.text = secondary.hint
        checkBox0.text = secondary.counterHints[0]
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()

        if(battleObject.getSecondaryVpCounter(counterNumber) != 0){
            checkBox0.isChecked = true
        }

            checkBox0.setOnClickListener {
                if (checkBox0.isChecked) {
                    secondaryCounter++
                    battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                } else {
                    secondaryCounter--
                    battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                }
                updateVP()
            }
    }
}
