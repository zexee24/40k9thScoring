package com.erej.a40k9thscoring


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_assasinate.*


class AssassinateFragment( private val battleObject: Battle, private val secondary: Secondary, private val secondaryNumber: Int) : Fragment(R.layout.fragment_assasinate)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var counter = battleObject.p1Secondary1Counter
        var vpCounter = battleObject.p1Secondary1Vp


        // set correct secondary to edit
        when(secondaryNumber){
            1-> {
                counter = battleObject.p1Secondary1Counter
                vpCounter = battleObject.p1Secondary1Vp
            }
            2-> {
                counter = battleObject.p1Secondary2Counter
                vpCounter = battleObject.p1Secondary2Vp
            }

            3-> {
                counter = battleObject.p1Secondary3Counter
                vpCounter = battleObject.p1Secondary3Vp
            }

            4-> {
                counter = battleObject.p2Secondary1Counter
                vpCounter = battleObject.p2Secondary1Vp
            }
            5-> {
                counter = battleObject.p2Secondary2Counter
                vpCounter = battleObject.p2Secondary2Vp
            }
            6-> {
                counter = battleObject.p2Secondary3Counter
                vpCounter = battleObject.p2Secondary3Vp
            }
        }




        textViewTitle.text = secondary.secondaryName
        textViewdescription.text = secondary.hint
        counterView1.text = counter.toString()

        buttonIncrease.setOnClickListener{
            counter
            counterView1.text = counter.toString()
            battleViewModel.update(battleObject)
        }
        buttonDecrease.setOnClickListener{
            counter.--
            if (counter < 0 ){
                counter = 0
                Toast.makeText(activity, "You haven't killed a negative amount of character have you?", Toast.LENGTH_SHORT).show()
        }
            counterView1.text = counter.toString()
            battleObject.p1Secondary1Vp = 3 * counter
            battleViewModel.update(battleObject)


        }





    }


}