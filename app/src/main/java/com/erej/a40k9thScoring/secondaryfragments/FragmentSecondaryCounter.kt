package com.erej.a40k9thScoring.secondaryfragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Secondary
import kotlinx.android.synthetic.main.fragment_secondary_counter.*


class FragmentSecondaryCounter(private val battleObject: Battle, private val secondary: Secondary, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(
    R.layout.fragment_secondary_counter
) {

    private fun updateVP (){
        battleObject.secondaryToVpCounter(secondary,counterNumber,secondaryCounter)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)

        //setup secondary names
        textViewTitle.text = secondary.name
        textViewdescription.text = secondary.hint
        counterView1.text = secondaryCounter.toString()
        textViewCounterHint.text = secondary.counterHints[0]
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