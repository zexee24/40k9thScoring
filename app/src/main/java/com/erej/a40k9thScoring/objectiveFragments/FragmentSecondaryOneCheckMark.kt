package com.erej.a40k9thScoring.objectiveFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_one_checkmark.*

class FragmentSecondaryOneCheckMark(private val battleObject: Battle, private val objective: Objective, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(
    R.layout.fragment_one_checkmark
){

    private fun updateVP (){
        battleObject.secondaryToVpOneCheckMark(objective,counterNumber,secondaryCounter)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkBox0.isChecked = battleObject.getCheck(counterNumber)

        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)
        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint
        checkBox0.text = objective.counterHints[0]
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()

            checkBox0.setOnClickListener {
                if (checkBox0.isChecked) {
                    secondaryCounter++
                    battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                    battleObject.setCheck(counterNumber)
                } else {
                    secondaryCounter--
                    battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                    battleObject.unCheck(counterNumber)
                }
                updateVP()
            }
    }
}