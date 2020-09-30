package com.erej.a40k9thScoring.objectiveFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_three_checkmarks.*


class FragmentSecondaryThreeCheckMarks(private val objective: Objective) : Fragment(
    R.layout.fragment_three_checkmarks
){

    private fun updateVP (){
        objective.counterToVp()
        textViewSecondaryVp.text = objective.vp.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint

        //hints
        checkBox0.isChecked = objective.counterCheck1
        checkBox0.text = objective.counterHints[0]
        checkBox1.isChecked = objective.counterCheck2
        checkBox1.text = objective.counterHints[1]
        checkBox2.isChecked = objective.counterCheck3
        checkBox2.text = objective.counterHints[2]

        textViewSecondaryVp.text = objective.vp.toString()

        checkBox2.setOnClickListener {
            if (checkBox2.isChecked) {
                objective.counter3++
            } else {
                objective.counter3--
            }
            objective.counterCheck3 = !objective.counterCheck3
            updateVP()
        }

        checkBox1.setOnClickListener {
            if (checkBox1.isChecked) {
                objective.counter2++
            } else {
                objective.counter2--
            }
            objective.counterCheck2 = !objective.counterCheck2
            updateVP()
        }


        checkBox0.setOnClickListener {
            if (checkBox0.isChecked) {
                objective.counter1++
            } else {
                objective.counter1--
            }
            objective.counterCheck1 = !objective.counterCheck1
            updateVP()
        }

    }
}
