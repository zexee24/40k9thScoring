package com.erej.a40k9thScoring.objectiveFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_secondary_counter.buttonDecrease
import kotlinx.android.synthetic.main.fragment_secondary_counter.buttonIncrease
import kotlinx.android.synthetic.main.fragment_secondary_counter.counterView1
import kotlinx.android.synthetic.main.fragment_secondary_counter.textViewTitle
import kotlinx.android.synthetic.main.fragment_secondary_counter.textViewdescription
import kotlinx.android.synthetic.main.fragment_secondary_dualcounter.*

class FragmentSecondaryDualCounter(private val objective: Objective) : Fragment(
    R.layout.fragment_secondary_dualcounter
)  {



    private fun updateVP (){
        objective.counterToVp()
        textViewSecondaryVp.text = objective.vp.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        //setup secondary names and counters
        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint
        textViewSecondaryVp.text = objective.vp.toString()
        counterView1.text = objective.counter1.toString()
        counterView.text = objective.counter2.toString()
        textViewCounterHint2.text = objective.counterHints[0]
        textViewCounterHint1.text = objective.counterHints[1]

        //lower button
        buttonIncrease.setOnClickListener{
            objective.counter1++
            counterView1.text = objective.counter1.toString()
           updateVP()
        }

        //lower button
        buttonDecrease2.setOnClickListener{
            objective.counter1--
            if (objective.counter1 < 0 ){
                objective.counter1 = 0
        }
            counterView1.text = objective.counter1.toString()
            updateVP()

        }

        //upper button
        buttonIncrease1.setOnClickListener{
            objective.counter2++
            counterView.text = objective.counter2.toString()
            updateVP()

        }

        //upper button
        buttonDecrease.setOnClickListener{
            objective.counter2--
            if (objective.counter2 < 0 ){
                objective.counter2 = 0
            }
            counterView.text = objective.counter2.toString()
            updateVP()
        }

    }


}