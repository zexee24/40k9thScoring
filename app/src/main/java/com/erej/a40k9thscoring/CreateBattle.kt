package com.erej.a40k9thscoring

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast


import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.createbattle.*
import org.json.JSONObject
import java.lang.NumberFormatException
import java.time.LocalDateTime


class CreateBattle : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.createbattle)



            //select mission type
            val missionTypes = listOf("Combat Patrol", "Incursion", "Strike force", "Onslaught")

            selectMissonType.adapter = ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,missionTypes)

            var battleType = "Combat Patrol"

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
                    battleViewModel.insert(Battle(null,editYourName.text.toString(),editOpponentName.text.toString(), editYourCp.text.toString().toInt() , editOpponetCp.text.toString().toInt() , battleType))
                    finish()

                }
                catch (e: NumberFormatException){
                    Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT).show()

                }


            }

        }


    }





