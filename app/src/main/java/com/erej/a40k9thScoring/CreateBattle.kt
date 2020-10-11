package com.erej.a40k9thScoring


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.erej.a40k9thScoring.classes.*
import kotlinx.android.synthetic.main.createbattle.*


class CreateBattle : AppCompatActivity() {

    lateinit var p1Secondary1: Objective
    lateinit var p1Secondary2: Objective
    lateinit var p1Secondary3: Objective
    lateinit var p2Secondary1: Objective
    lateinit var p2Secondary2: Objective
    lateinit var p2Secondary3: Objective
    var battleType = "none"
    lateinit var mission: Primary
    private var secondaryList: MutableList<Objective> = SecondaryList().getSecondaries as MutableList<Objective>
    private lateinit var secondaryNameList: List<String>
    var primaryList: MutableList<Primary> = PrimaryList().missions as MutableList<Primary>
    private lateinit var currentPrimaryList: MutableList<Primary>
    private lateinit var primaryNameList: List<String>

    private fun setSecondaryLists(){
        secondaryNameList = secondaryList.map {
            it.name
        }

        val secondaryNameAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, secondaryNameList)

        spinnerP1Sec1.adapter = secondaryNameAdapter
        spinnerP1Sec2.adapter = secondaryNameAdapter
        spinnerP1Sec3.adapter = secondaryNameAdapter

        spinnerP2Sec1.adapter = secondaryNameAdapter
        spinnerP2Sec2.adapter = secondaryNameAdapter
        spinnerP2Sec3.adapter = secondaryNameAdapter
    }


    private fun setPrimaryMissionList(){
        currentPrimaryList = mutableListOf()
        for(i in primaryList){
            if(i.missionSize == battleType){
                currentPrimaryList.add(i)
            }
        }

        primaryNameList = currentPrimaryList.map{
            it.name
        }
        spinnerSelectPrimary.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, primaryNameList)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.createbattle)


        setSecondaryLists()
        setPrimaryMissionList()



        //select mission type
        val missionTypes = listOf("Combat patrol", "Incursion", "Strike force", "Onslaught")

        selectMissonType.adapter = ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,missionTypes)






            //P1 Sec 1
            spinnerP1Sec1.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p1Secondary1 = secondaryList[position]
                }
            }

            //P1 Sec 2

            spinnerP1Sec2.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p1Secondary2 = secondaryList[position]
                }
            }

            //P1 Sec 3

            spinnerP1Sec3.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p1Secondary3 = secondaryList[position]
                }
            }

            //P2 Sec 1


            spinnerP2Sec1.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p2Secondary1 = secondaryList[position]
                }
            }

            //P2 Sec 2

            spinnerP2Sec2.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p2Secondary2 = secondaryList[position]
                }
            }

            //P2 Sec 3


            spinnerP2Sec3.onItemSelectedListener = object  :  AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                     p2Secondary3 = secondaryList[position]
                }
            }




            selectMissonType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(p0: AdapterView<*>?){}

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    battleType = missionTypes[position]
                    setPrimaryMissionList()
                }
            }

            spinnerSelectPrimary.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {}
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    mission = currentPrimaryList[position]
                    secondaryList[0] = mission.secondaryObjective
                    setSecondaryLists()
                }
            }

            //done
            addBattleDoneButton.setOnClickListener{

                //TODO battle start and end interface

                //in case of wrong input
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
                    battle.primaryMission = mission
                    battle.primaryMissionP1 = mission
                    battle.primaryMissionP2 = mission
                    battle.turnCounter = 0


                    battleViewModel.insert(battle)
                    finish()

                }
                catch (e: NumberFormatException){
                    Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }
    }
}





