package com.erej.a40k9thScoring.objectiveFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Objective
import kotlinx.android.synthetic.main.fragment_one_checkmark.*

class FragmentObjectiveOneCheckMark(private val objective: Objective) : Fragment(
    R.layout.fragment_one_checkmark
){

    private fun updateVP (){
        objective.counterToVp()
        textViewSecondaryVp.text = objective.vp.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkBox0.isChecked = objective.counterCheck1

        textViewTitle.text = objective.name
        textViewdescription.text = objective.hint
        checkBox0.text = objective.counterHints[0]
        textViewSecondaryVp.text = objective.vp.toString()

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