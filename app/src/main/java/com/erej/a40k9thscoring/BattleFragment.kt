package com.erej.a40k9thscoring



import android.widget.TextView
import androidx.fragment.app.Fragment


class BattleFragment : Fragment(R.layout.fragment_battle)  {

     fun setBattle(battle: Battle){


         val view = layoutInflater.inflate(R.layout.fragment_battle,null)
         val text = view.findViewById<TextView>(R.id.textViewBattleName)
         text.text = battle.yourName



    }



}