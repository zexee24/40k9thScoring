package com.erej.a40k9thscoring

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_secondary_counter.buttonDecrease
import kotlinx.android.synthetic.main.fragment_secondary_counter.buttonIncrease
import kotlinx.android.synthetic.main.fragment_secondary_counter.counterView1
import kotlinx.android.synthetic.main.fragment_secondary_counter.textViewTitle
import kotlinx.android.synthetic.main.fragment_secondary_counter.textViewdescription
import kotlinx.android.synthetic.main.fragment_secondary_dualcounter.*

class FragmentSecondaryDualCounter(
    private val battleObject: Battle, private val secondary: Secondary, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(R.layout.fragment_secondary_dualcounter)  {

    private var secondaryCounter2 = battleObject.getSecondaryCounter(10 + counterNumber)

    private fun updateVP (){
        battleObject.secondaryToVpDual(secondary,counterNumber,secondaryCounter,secondaryCounter2)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)



        //setup secondary names and counters
        textViewTitle.text = secondary.name
        textViewdescription.text = secondary.hint
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
        counterView1.text = secondaryCounter.toString()
        counterView.text = secondaryCounter2.toString()
        textViewCounterHint2.text = secondary.counterHints[0]
        textViewCounterHint1.text = secondary.counterHints[1]

        //lower button
        buttonIncrease.setOnClickListener{
            secondaryCounter++
            counterView1.text = secondaryCounter.toString()
            battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
           updateVP()
        }

        //lower button
        buttonDecrease2.setOnClickListener{
            secondaryCounter--
            if (secondaryCounter < 0 ){
                secondaryCounter = 0
        }
            counterView1.text = secondaryCounter.toString()
            battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
            updateVP()

        }

        //upper button
        buttonIncrease1.setOnClickListener{
            secondaryCounter2++
            counterView.text = secondaryCounter2.toString()
            battleObject.setSecondaryCounter(10+counterNumber, secondaryCounter2)
            updateVP()

        }

        //upper button
        buttonDecrease.setOnClickListener{
            secondaryCounter2--
            if (secondaryCounter2 < 0 ){
                secondaryCounter2 = 0
            }
            counterView.text = secondaryCounter2.toString()
            battleObject.setSecondaryCounter(10+counterNumber, secondaryCounter2)
            updateVP()
        }

    }


}