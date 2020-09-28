package com.erej.a40k9thScoring.objectiveFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_two_checkmarks.*


class FragmentSecondaryTwoOnetimeCheckMarks(private val battleObject: Battle, private val objective: Objective, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(
    R.layout.fragment_two_checkmarks
){

    private fun updateVP (){
        battleObject.secondaryToVpTwoCheckMarks(objective,counterNumber,secondaryCounter, 0)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)
        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint

        //hints
        checkBox0.text = objective.counterHints[0]
        checkBox1.text = objective.counterHints[1]


        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()


        if(battleObject.getSecondaryVpCounter(counterNumber) >= 5){
            checkBox0.isChecked = true
            }
        if(battleObject.getSecondaryVpCounter(counterNumber) >= 10){
            checkBox1.isChecked = true
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

        checkBox1.setOnClickListener {
            if (checkBox1.isChecked) {
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
