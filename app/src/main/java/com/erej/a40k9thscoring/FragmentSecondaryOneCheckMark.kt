package com.erej.a40k9thscoring

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one_checkmark.*

class FragmentSecondaryOneCheckMark(private val battleObject: Battle, private val secondary: Secondary, private var secondaryCounter: Int, private val counterNumber: Int) : Fragment(R.layout.fragment_one_checkmark){

    private fun updateVP (){
        battleObject.secondaryToVpOneCheckMark(secondary,counterNumber,secondaryCounter)
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewTitle.text = secondary.name
        textViewdescription.text = secondary.hint
        checkBox0.text = secondary.counterHints[0]
        textViewSecondaryVp.text = battleObject.getSecondaryVpCounter(counterNumber).toString()

            checkBox0.setOnClickListener {
                if (checkBox0.isChecked) {
                    secondaryCounter++
                } else {
                    secondaryCounter--
                }
                updateVP()
            }
    }

}