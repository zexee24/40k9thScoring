package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.Objective
import com.erej.a40k9thScoring.classes.SecondaryAdapter
import com.erej.a40k9thScoring.classes.SecondaryList
import kotlinx.android.synthetic.main.fragment_create_select_secondaries.*

class FragmentSelectSecondaryObjectives(val battleObject:Battle): Fragment(R.layout.fragment_create_select_secondaries) {

    private val allSecondaries = SecondaryList().getSecondaries


    private fun setAdapter(spinner: Spinner){
        spinner.adapter = SecondaryAdapter(activity?.applicationContext!!, allSecondaries)
    }

    private fun setSpinner(spinner: Spinner, secondary : Objective){
        spinner.setSelection((spinner.adapter as SecondaryAdapter).getPosition(secondary))
    }

    private fun setAllSpinners (){
        setSpinner(spinnerP1Secondary1, battleObject.p1Secondary1)
        setSpinner(spinnerP1Secondary2, battleObject.p1Secondary2)
        setSpinner(spinnerP1Secondary3, battleObject.p1Secondary3)

        setSpinner(spinnerP2Secondary1, battleObject.p2Secondary1)
        setSpinner(spinnerP2Secondary2, battleObject.p2Secondary2)
        setSpinner(spinnerP2Secondary3, battleObject.p2Secondary3)


    }

    private fun reloadSpinners(){

        setSpinner(spinnerP1Secondary1, battleObject.p1Secondary1)

        var thisSecondary = battleObject.p1Secondary1
        (spinnerP1Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary3.category)
        (spinnerP1Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary2.category)

        setSpinner(spinnerP1Secondary2, battleObject.p1Secondary2)

        thisSecondary = battleObject.p1Secondary2
        (spinnerP1Secondary1.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary3.category)
        (spinnerP1Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary1.category)

        setSpinner(spinnerP1Secondary3, battleObject.p1Secondary3)

        thisSecondary = battleObject.p1Secondary3
        (spinnerP1Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary1.category)
        (spinnerP1Secondary1.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary2.category)

        setSpinner(spinnerP2Secondary1, battleObject.p2Secondary1)

        thisSecondary = battleObject.p2Secondary1
        (spinnerP2Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary3.category)
        (spinnerP2Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary2.category)

        setSpinner(spinnerP2Secondary2, battleObject.p2Secondary2)

        thisSecondary = battleObject.p2Secondary1
        (spinnerP2Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary3.category)
        (spinnerP2Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary2.category)

        setSpinner(spinnerP2Secondary3, battleObject.p2Secondary3)
        thisSecondary = battleObject.p2Secondary3
        (spinnerP2Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary1.category)
        (spinnerP2Secondary1.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary2.category)

        //TODO Oh fuck me sideways
    }

    private fun createSpinners(){
        setAdapter(spinnerP1Secondary1)
        setAdapter(spinnerP1Secondary2)
        setAdapter(spinnerP1Secondary3)

        setAdapter(spinnerP2Secondary1)
        setAdapter(spinnerP2Secondary2)
        setAdapter(spinnerP2Secondary3)



        //Spinners for P1
        spinnerP1Secondary1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                battleObject.p1Secondary1 = (spinnerP1Secondary1.adapter.getItem(position) as Objective).copy()
                val thisSecondary = battleObject.p1Secondary1
                (spinnerP1Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary3.category)
                (spinnerP1Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary2.category)
                setAllSpinners()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinnerP1Secondary2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                battleObject.p1Secondary2 = (spinnerP1Secondary2.adapter.getItem(position) as Objective).copy()
                val thisSecondary = battleObject.p1Secondary2
                (spinnerP1Secondary1.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary3.category)
                (spinnerP1Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary1.category)
                setAllSpinners()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spinnerP1Secondary3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                battleObject.p1Secondary3 = (spinnerP1Secondary3.adapter.getItem(position) as Objective).copy()
                val thisSecondary = battleObject.p1Secondary3
                (spinnerP1Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary1.category)
                (spinnerP1Secondary1.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p1Secondary2.category)
                setAllSpinners()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        //Spinners for p2
        spinnerP2Secondary1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                battleObject.p2Secondary1 = (spinnerP2Secondary1.adapter.getItem(position) as Objective).copy()
                val thisSecondary = battleObject.p2Secondary1
                (spinnerP2Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary3.category)
                (spinnerP2Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary2.category)
                setAllSpinners()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinnerP2Secondary2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                battleObject.p2Secondary2 = (spinnerP2Secondary2.adapter.getItem(position) as Objective).copy()
                val thisSecondary = battleObject.p2Secondary2
                (spinnerP2Secondary1.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary3.category)
                (spinnerP2Secondary3.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary1.category)
                setAllSpinners()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinnerP2Secondary3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                battleObject.p2Secondary3 = (spinnerP2Secondary3.adapter.getItem(position) as Objective).copy()
                val thisSecondary = battleObject.p2Secondary3
                (spinnerP2Secondary2.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary1.category)
                (spinnerP2Secondary1.adapter as SecondaryAdapter).updateList(thisSecondary.category, battleObject.p2Secondary2.category)
                setAllSpinners()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createSpinners()
        reloadSpinners()
    }

}