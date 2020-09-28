package com.erej.a40k9thScoring.battleFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.battleViewModel
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.fragment_cp.*

class FragmentCp (val battleObject: Battle) :Fragment(R.layout.fragment_cp) {


    fun setTextViews(){
        textViewYourCp.text = battleObject.p1Cp.toString()
        textViewOpponetCp.text = battleObject.p2Cp.toString()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewYourName.text = battleObject.yourName
        textViewOpponentsName.text = battleObject.opponentName

        setTextViews()



        buttonIncreaseYou.setOnClickListener {
            battleObject.p1Cp += 1
            battleViewModel.update(battleObject)
            setTextViews()
        }

        buttonDecreaseYou.setOnClickListener {
            battleObject.p1Cp -= 1
            battleViewModel.update(battleObject)
            setTextViews()
        }

        buttonIncreaseOpponent.setOnClickListener {
            battleObject.p2Cp += 1
            battleViewModel.update(battleObject)
            setTextViews()
        }

        buttonDecreaseOpponent.setOnClickListener {
            battleObject.p2Cp -= 1
            battleViewModel.update(battleObject)
            setTextViews()
        }
    }

}