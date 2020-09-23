package com.erej.a40k9thScoring


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.createbattle.*
import java.lang.NumberFormatException



class CreateBattle : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.createbattle)



            //select mission type
            val missionTypes = listOf("Combat Patrol", "Incursion", "Strike force", "Onslaught")

            selectMissonType.adapter = ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,missionTypes)

            val secondaryList = SecondaryList().getSecondaries()

            val secondaryNameList = secondaryList.map { it.name }

            var p1Secondary1 = 0
            var p1Secondary2 = 0
            var p1Secondary3 = 0
            var p2Secondary1 = 0
            var p2Secondary2 = 0
            var p2Secondary3 = 0




            //P1 Sec 1
            spinnerP1Sec1.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, secondaryNameList)
            spinnerP1Sec1.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p1Secondary1 = position
                }
            }

            //P1 Sec 2
            spinnerP1Sec2.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, secondaryNameList)
            spinnerP1Sec2.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p1Secondary2 = position
                }
            }

            //P1 Sec 3
            spinnerP1Sec3.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, secondaryNameList)

            spinnerP1Sec3.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p1Secondary3 = position
                }
            }

            //P2 Sec 1
            spinnerP2Sec1.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, secondaryNameList)

            spinnerP2Sec1.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p2Secondary1 = position
                }
            }

            //P2 Sec 2
            spinnerP2Sec2.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, secondaryNameList)

            spinnerP2Sec2.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p2Secondary2 = position
                }
            }

            //P2 Sec 3
            spinnerP2Sec3.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, secondaryNameList)

            spinnerP2Sec3.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p2Secondary3 = position
                }
            }





            var battleType = "none"

            selectMissonType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                      battleType = missionTypes[position]
                }
            }

            //done
            addBattleDoneButton.setOnClickListener{


                //in case of väärä inputti
                try {
                    val battle = Battle(null,editYourName.text.toString(),editOpponentName.text.toString(), battleType)
                    battle.p1Cp = editYourCp.text.toString().toInt()
                    battle.p2Cp = editOpponetCp.text.toString().toInt()

                    battle.p1Secondary1 = p1Secondary1
                    battle.p1Secondary2 = p1Secondary2
                    battle.p1Secondary3 = p1Secondary3
                    battle.p2Secondary1 = p2Secondary1
                    battle.p2Secondary2 = p2Secondary2
                    battle.p2Secondary3 = p2Secondary3


                    battleViewModel.insert(battle)
                    finish()

                }
                catch (e: NumberFormatException){
                    Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT).show()

                }


            }

        }


    }




