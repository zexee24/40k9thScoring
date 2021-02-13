package com.erej.a40k9thScoring


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erej.a40k9thScoring.classes.*
import com.erej.a40k9thScoring.dataStoring.BattleViewModel
import com.erej.a40k9thScoring.dataStoring.MissionPackViewModel
import com.erej.a40k9thScoring.dataStoring.fireBaseConverter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup_update_data.view.*
import kotlinx.coroutines.*


private lateinit var battleAdapter: BattleRecyclerAdapter
lateinit var battleViewModel : BattleViewModel
lateinit var missionPackViewModel : MissionPackViewModel

val createBattleMethod = CreateBattleSlow::class.java

class MainActivity : AppCompatActivity(), OnBattleClickListener{

    private fun upDateData(){
        val popupView = layoutInflater.inflate(R.layout.popup_update_data, null, false)
        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val heigth = LinearLayout.LayoutParams.WRAP_CONTENT

        val popupWindow = PopupWindow(popupView, width, heigth, false)
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        val fbdb = FirebaseFirestore.getInstance()

        val docRef = fbdb.collection("MissionPacks")
        val missionPackList = mutableListOf<MissionPack>()

        docRef.get().addOnSuccessListener { document ->
            for (i in document) {
                val newDocRef = docRef.document(i.id)
                    val missionPackName = i["name"]
                    val missions = mutableListOf<Mission>()

                    newDocRef.collection("missions").get().addOnSuccessListener { missionList ->
                        for (j in missionList) {
                            val missionsName = j["name"] as String
                            val briefing = j["briefing"] as String
                            val rules = j["missionRules"] as String
                            val size = j["missionSize"] as String
                            val primaryObjective =
                                fireBaseConverter(j["primaryObjective"] as Map<String, Any>)
                            val secondaryObjective =
                                fireBaseConverter(j["secondaryObjective"] as Map<String, Any>)
                            val setupImage = j["setupImage"] as Long
                            missions.add(
                                Mission(
                                    "",
                                    size,
                                    missionsName,
                                    rules,
                                    briefing,
                                    primaryObjective,
                                    secondaryObjective,
                                    setupImage.toInt()
                                )
                            )
                        }
                        }

                val objectives = mutableListOf<Objective>()
                newDocRef.collection("objectives").get()
                    .addOnSuccessListener { objectiveList ->
                        for (j in objectiveList) {
                            val objective = fireBaseConverter(j)
                            objectives.add(objective)
                            Log.d("Objectives","$objective")
                        }
                    }
                val missionPack = MissionPack(missionPackName.toString(), missions, objectives)
                missionPackList.add(missionPack)
            }
        }

        Toast.makeText(this, "$missionPackList", Toast.LENGTH_SHORT).show()
        for (i in missionPackList){
            missionPackViewModel.insert(i)
            Toast.makeText(this, "$i", Toast.LENGTH_SHORT).show()
        }

        popupWindow.contentView.buttonCancel.setOnClickListener {
            popupWindow.dismiss()
        }
        popupWindow.contentView.buttonOk.setOnClickListener {
            popupWindow.dismiss()
        }

    }

    //set listener for actionbar menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.action_updateData -> {
                upDateData()
            }
            else -> throw error("Error in menu item ids")
        }
        return true
    }

    //inflate the actionbar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    //setup everything
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set supportActionBar
        setSupportActionBar(toolbar)

        //init BattleViewModel
        battleViewModel = ViewModelProvider(this).get(BattleViewModel::class.java)
        missionPackViewModel = ViewModelProvider(this).get(MissionPackViewModel::class.java)


        // initialise recycler view
        initRecyclerView()
        val createBattleIntent = Intent(this, createBattleMethod)

        //on data update
        battleViewModel.allBattles.observe(this, Observer {battles ->

            //update the ui
            battles?.let {battleAdapter.submitList(it)}
        })

        missionPackViewModel.allMissionPacks.observe(this, Observer { missionsPacks ->
            Toast.makeText(this, missionsPacks.size.toString(), Toast.LENGTH_SHORT).show()
        })

        //create new battle
        addNewBattle.setOnClickListener{
        startActivity(createBattleIntent)
        }

        //delete battle
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                battleViewModel.deleteOne(battleAdapter.getBattleAtPosition(viewHolder.adapterPosition))

            }

        }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }

    //enterBattle
    override fun onItemClick(item: Battle, position: Int) {
            val intent = Intent(this, PlayGameActivity::class.java)
            intent.putExtra("battle", item)
        startActivity(intent)

    }

    //initialize the recyclerView for battles
    private fun initRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            battleAdapter = BattleRecyclerAdapter(this@MainActivity)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            adapter = battleAdapter
        }

    }

}