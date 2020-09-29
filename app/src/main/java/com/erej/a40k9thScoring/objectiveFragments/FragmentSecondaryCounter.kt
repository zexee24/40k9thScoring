package com.erej.a40k9thScoring.objectiveFragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_secondary_counter.*


class FragmentSecondaryCounter(private val battleObject: Battle, private val objective: Objective, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(
    R.layout.fragment_secondary_counter
) {

    private fun updateVP (){
        battleObject.secondaryToVpCounter(objective,counterNumber,secondaryCounter)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)

        //setup secondary names
        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint
        counterView1.text = secondaryCounter.toString()
        textViewCounterHint.text = objective.counterHints[0]
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()

        buttonIncrease.setOnClickListener{
            secondaryCounter++
            counterView1.text = secondaryCounter.toString()
            battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
            updateVP()
        }

        buttonDecrease.setOnClickListener{
            secondaryCounter--
            if (secondaryCounter < 0 ){
                secondaryCounter = 0
        }
            counterView1.text = secondaryCounter.toString()
            battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
            updateVP()
        }
    }
}