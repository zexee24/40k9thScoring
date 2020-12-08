package com.erej.a40k9thScoring.createBattleFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.R
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.SecondaryList
import kotlinx.android.synthetic.main.fragment_create_select_secondaries.*

class FragmentSelectSecondaryObjectives(val battleObject:Battle): Fragment(R.layout.fragment_create_select_secondaries) {

    private val allSecondaries = SecondaryList().getSecondaries





    private fun updateSpinners(){
        val p1S1List = allSecondaries.toMutableList()
        val p1S2List = allSecondaries.toMutableList()
        val p1S3List = allSecondaries.toMutableList()

        val p2S1List = allSecondaries.toMutableList()
        val p2S2List = allSecondaries.toMutableList()
        val p2S3List = allSecondaries.toMutableList()

        p1S1List.removeAll {
            it.category == battleObject.p1Secondary2.category
            it.category == battleObject.p1Secondary3.category
        }
        p1S2List.removeAll {
            it.category == battleObject.p1Secondary1.category
            it.category == battleObject.p1Secondary3.category
        }
        p1S3List.removeAll {
            it.category == battleObject.p1Secondary2.category
            it.category == battleObject.p1Secondary1.category
        }


        p2S1List.removeAll {
            it.category == battleObject.p2Secondary2.category
            it.category == battleObject.p2Secondary3.category
        }
        p2S2List.removeAll {
            it.category == battleObject.p2Secondary1.category
            it.category == battleObject.p2Secondary3.category
        }
        p2S3List.removeAll {
            it.category == battleObject.p2Secondary2.category
            it.category == battleObject.p2Secondary1.category
        }

        val p1S1NameList = p1S1List.map { it.name }
        val p1S2NameList = p1S2List.map { it.name }
        val p1S3NameList = p1S3List.map { it.name }

        val p2S1NameList = p2S1List.map { it.name }
        val p2S2NameList = p2S2List.map { it.name }
        val p2S3NameList = p2S3List.map { it.name }



        spinnerP1Secondary1.adapter = ArrayAdapter<String>(activity?.applicationContext!!, R.layout.support_simple_spinner_dropdown_item, p1S1NameList)
        spinnerP1Secondary2.adapter = ArrayAdapter<String>(activity?.applicationContext!!, R.layout.support_simple_spinner_dropdown_item, p1S2NameList)
        spinnerP1Secondary3.adapter = ArrayAdapter<String>(activity?.applicationContext!!, R.layout.support_simple_spinner_dropdown_item, p1S3NameList)

        spinnerP2Secondary1.adapter = ArrayAdapter<String>(activity?.applicationContext!!, R.layout.support_simple_spinner_dropdown_item, p2S1NameList)
        spinnerP2Secondary2.adapter = ArrayAdapter<String>(activity?.applicationContext!!, R.layout.support_simple_spinner_dropdown_item, p2S2NameList)
        spinnerP2Secondary3.adapter = ArrayAdapter<String>(activity?.applicationContext!!, R.layout.support_simple_spinner_dropdown_item, p2S3NameList)

        spinnerP1Secondary1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.p1Secondary1 = p1S1List[p2]
                updateSpinners()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinnerP1Secondary2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.p1Secondary2 = p1S2List[p2]
                updateSpinners()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinnerP1Secondary3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.p1Secondary3 = p1S3List[p2]
                updateSpinners()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spinnerP2Secondary1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.p2Secondary1 = p2S1List[p2]
                updateSpinners()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinnerP2Secondary2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.p2Secondary2 = p2S2List[p2]
                updateSpinners()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinnerP2Secondary3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                battleObject.p2Secondary3 = p2S3List[p2]
                updateSpinners()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateSpinners()


    }
}