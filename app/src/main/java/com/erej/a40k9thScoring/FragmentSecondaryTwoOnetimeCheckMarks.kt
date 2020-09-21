package com.erej.a40k9thScoring

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_two_checkmarks.*


class FragmentSecondaryTwoOnetimeCheckMarks(private val battleObject: Battle, private val secondary: Secondary, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(R.layout.fragment_two_checkmarks){

    private fun updateVP (){
        battleObject.secondaryToVpTwoCheckMarks(secondary,counterNumber,secondaryCounter, 0)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        secondaryCounter = battleObject.getSecondaryCounter(counterNumber)
        textViewTitle.text = secondary.name
        textViewdescription.text = secondary.hint

        //hints
        checkBox0.text = secondary.counterHints[0]
        checkBox1.text = secondary.counterHints[1]


        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()


        if(battleObject.getSecondaryVpCounter(counterNumber) >= 5){
            checkBox0.isChecked = true
            }
        if(battleObject.getSecondaryVpCounter(counterNumber) >= 10){
            checkBox1.isChecked = true
        }

        checkBox0.setOnClickListener {
            if (checkBox0.isChecked) {
                    secondaryCounter++
                    battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
            } else {
                    secondaryCounter--
                    battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
            }
            updateVP()
            }

        checkBox1.setOnClickListener {
            if (checkBox1.isChecked) {
                secondaryCounter++
                battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
            } else {
                secondaryCounter--
                battleObject.setSecondaryCounter(counterNumber, secondaryCounter)
            }
            updateVP()
        }
    }
}
