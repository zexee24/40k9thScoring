package com.erej.a40k9thscoring


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_battle.*


class BattleFragment(val battleObject: Battle) : Fragment(R.layout.fragment_battle)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewBattleName.text = battleObject.yourName




    }


}