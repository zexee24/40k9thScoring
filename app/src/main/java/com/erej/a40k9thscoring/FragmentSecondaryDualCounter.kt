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


class FragmentSecondaryDualCounter(private val battleObject: Battle, private val secondary: Secondary, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(R.layout.fragment_secondary_dualcounter)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondaryCounter = getSecondaryCounter(battleObject, counterNumber)
        var secondaryCounter2 = 0





        //setup secondary names
        textViewTitle.text = secondary.secondaryName
        textViewdescription.text = secondary.hint
        counterView1.text = secondaryCounter.toString()
        textViewCounterHint2.text = secondary.counterHints[0]
        textViewCounterHint1.text = secondary.counterHints[1]

        buttonIncrease.setOnClickListener{
            secondaryCounter++
            counterView1.text = secondaryCounter.toString()
            setSecondaryCounter(battleObject, counterNumber, secondaryCounter)

        }


        buttonDecrease2.setOnClickListener{
            secondaryCounter--
            if (secondaryCounter < 0 ){
                secondaryCounter = 0
        }
            counterView1.text = secondaryCounter.toString()
            setSecondaryCounter(battleObject, counterNumber, secondaryCounter)

        }

        buttonIncrease1.setOnClickListener{
            secondaryCounter2++
            counterView.text = secondaryCounter2.toString()

        }


        buttonDecrease.setOnClickListener{
            secondaryCounter2--
            if (secondaryCounter2 < 0 ){
                secondaryCounter2 = 0
            }
            counterView.text = secondaryCounter2.toString()
        }





    }


}