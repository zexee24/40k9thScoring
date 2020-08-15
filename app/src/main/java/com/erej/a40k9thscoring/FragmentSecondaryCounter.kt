package com.erej.a40k9thscoring


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_secondary_counter.*


class FragmentSecondaryCounter(private val battleObject: Battle, private val secondary: Secondary, var secondaryCounter: Int) : Fragment(R.layout.fragment_secondary_counter) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        //setup secondary names
        textViewTitle.text = secondary.secondaryName
        textViewdescription.text = secondary.hint
        counterView1.text = secondaryCounter.toString()
        textViewCounterHint.text = secondary.counterHints[0]

        buttonIncrease.setOnClickListener{
            secondaryCounter++
            counterView1.text = secondaryCounter.toString()

        }


        buttonDecrease.setOnClickListener{
            secondaryCounter--
            if (secondaryCounter < 0 ){
                secondaryCounter = 0
        }
            counterView1.text = secondaryCounter.toString()



        }





    }


}