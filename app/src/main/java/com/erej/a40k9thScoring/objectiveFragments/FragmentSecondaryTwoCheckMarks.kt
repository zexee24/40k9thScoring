package com.erej.a40k9thScoring.objectiveFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_two_checkmarks.*

class FragmentSecondaryTwoCheckMarks(private val battleObject: Battle, private val objective: Objective, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(
    R.layout.fragment_two_checkmarks
){

    private var secondaryCounter2 = battleObject.getSecondaryCounter(10 + counterNumber)

    private fun updateVP (){
        battleObject.secondaryToVpTwoCheckMarks(objective,counterNumber,secondaryCounter, secondaryCounter2)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)
        secondaryCounter2 = battleObject.getSecondaryCounter(10 + counterNumber)
        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint

        //hints
        checkBox0.isChecked = battleObject.getCheck(counterNumber)
        checkBox0.text = objective.counterHints[0]
        checkBox1.isChecked = battleObject.getCheck(10 + counterNumber)
        checkBox1.text = objective.counterHints[1]


        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()

        checkBox1.setOnClickListener {
            if (checkBox1.isChecked) {
                secondaryCounter++
                battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                battleObject.setCheck(10 + counterNumber)
            } else {
                secondaryCounter--
                battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                battleObject.unCheck(10 + counterNumber)
            }
            updateVP()
            }

        checkBox0.setOnClickListener {
            if (checkBox0.isChecked) {
                secondaryCounter2++
                battleObject.setSecondaryCounter(10 + counterNumber, secondaryCounter)
                battleObject.setCheck(counterNumber)
            } else {
                secondaryCounter2--
                battleObject.setSecondaryCounter(10 + counterNumber, secondaryCounter)
                battleObject.unCheck(counterNumber)
            }
            updateVP()
        }
    }
}
