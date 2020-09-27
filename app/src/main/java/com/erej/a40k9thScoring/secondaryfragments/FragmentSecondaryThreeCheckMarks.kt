package com.erej.a40k9thScoring.secondaryfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Secondary
import kotlinx.android.synthetic.main.fragment_three_checkmarks.*


class FragmentSecondaryThreeCheckMarks(private val battleObject: Battle, private val secondary: Secondary, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(
    R.layout.fragment_three_checkmarks
){

    private var secondaryCounter2 = battleObject.getSecondaryCounter(10 + counterNumber)
    private var secondaryCounter3 = battleObject.getSecondaryCounter(20 + counterNumber)

    private fun updateVP (){
        battleObject.secondaryToVpThreeCheckMarks(secondary, counterNumber, secondaryCounter, secondaryCounter2, secondaryCounter3)
        textViewSecondaryVp.text = battleObject.getPrimaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)
        secondaryCounter2 = battleObject.getSecondaryCounter(10 + counterNumber)
        secondaryCounter3 = battleObject.getSecondaryCounter(20 + counterNumber)
        textViewTitle.text = secondary.name
        textViewdescription.text = secondary.hint

        //hints
        checkBox0.isChecked = battleObject.getCheck(counterNumber)
        checkBox0.text = secondary.counterHints[0]
        checkBox1.isChecked = battleObject.getCheck(10 + counterNumber)
        checkBox1.text = secondary.counterHints[1]
        checkBox2.isChecked = battleObject.getCheck(20 + counterNumber)
        checkBox2.text = secondary.counterHints[2]

        textViewSecondaryVp.text = battleObject.getPrimaryVpCounter(counterNumber).toString()

        checkBox2.setOnClickListener {
            if (checkBox2.isChecked) {
                secondaryCounter3++
                battleObject.setSecondaryCounter(20 + counterNumber, secondaryCounter3)
                battleObject.setCheck(20 + counterNumber)
            } else {
                secondaryCounter3--
                battleObject.setSecondaryCounter(20 + counterNumber, secondaryCounter3)
                battleObject.unCheck(20 + counterNumber)
            }
            updateVP()
        }

        checkBox1.setOnClickListener {
            if (checkBox1.isChecked) {
                secondaryCounter2++
                battleObject.setSecondaryCounter(10 + counterNumber, secondaryCounter2)
                battleObject.setCheck(10 + counterNumber)
            } else {
                secondaryCounter2--
                battleObject.setSecondaryCounter(10 + counterNumber, secondaryCounter2)
                battleObject.unCheck(10 + counterNumber)
            }
            updateVP()
            }

        checkBox0.setOnClickListener {
            if (checkBox0.isChecked) {
                secondaryCounter++
                battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                battleObject.setCheck(counterNumber)
            } else {
                secondaryCounter--
                battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
                battleObject.unCheck(counterNumber)
            }
            updateVP()
        }
    }
}
