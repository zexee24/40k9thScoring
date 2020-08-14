package com.erej.a40k9thscoring


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_assasinate.*


class AssassinateFragment(val battleObject: Battle, val secondary: Secondary) : Fragment(R.layout.fragment_assasinate)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var counter1 = 0


        textViewTitle.text = secondary.secondaryName
        textViewdescription.text = secondary.hint

        buttonIncrease.setOnClickListener{
            counter1++
            counterView1.text = counter1.toString()
        }
        buttonDecrease.setOnClickListener{
            counter1--
            if (counter1 < 0 ){
            counter1 = 0
                Toast.makeText(activity, "You haven't killed a negative amount of character have you?", Toast.LENGTH_SHORT).show()
        }
            counterView1.text = counter1.toString()

        }





    }


}