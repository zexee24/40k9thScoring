package com.erej.a40k9thScoring.objectiveFragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_secondary_counter.*


class FragmentSecondaryCounter(private val objective: Objective) : Fragment(
    R.layout.fragment_secondary_counter
) {

    private fun updateVP (){
        objective.counterToVp()
        textViewSecondaryVp.text = objective.vp.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //setup secondary names
        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint
        counterView1.text = objective.counter1.toString()
        textViewCounterHint.text = objective.counterHints[0]
        textViewSecondaryVp.text = objective.vp.toString()

        buttonIncrease.setOnClickListener{
            objective.counter1++
            counterView1.text = objective.counter1.toString()
            updateVP()
        }

        buttonDecrease.setOnClickListener{
            objective.counter1--
            if (objective.counter1 < 0 ){
                objective.counter1 = 0
        }
            counterView1.text = objective.counter1.toString()
            updateVP()
        }
    }
}