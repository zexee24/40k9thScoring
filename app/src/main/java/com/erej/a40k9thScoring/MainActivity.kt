package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erej.a40k9thScoring.classes.*
import com.erej.a40k9thScoring.dataStoring.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup_update_data.*
import kotlinx.android.synthetic.main.popup_update_data.view.*
import kotlinx.coroutines.*


private lateinit var battleAdapter: BattleRecyclerAdapter
lateinit var battleViewModel : BattleViewModel
lateinit var missionPackViewModel : MissionPackViewModel
lateinit var missionPackAdapter : MissionPackUpdateRecyclerAdapter

val createBattleMethod = CreateBattleSlow::class.java

class MainActivity : AppCompatActivity(), OnBattleClickListener{

    private fun upDateData() {

        //create the "ui"
        val popupView = layoutInflater.inflate(R.layout.popup_update_data, null, false)
        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val heigth = LinearLayout.LayoutParams.WRAP_CONTENT
        val popupWindow = PopupWindow(popupView, width, heigth, false)

        popupView.recyclerViewMissionPacks.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            missionPackAdapter = MissionPackUpdateRecyclerAdapter()
            val topSpacingItemDecoration = TopSpacingItemDecoration(10)
            addItemDecoration(topSpacingItemDecoration)
            adapter = missionPackAdapter
        }

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        //define data source
        val fbdb = FirebaseFirestore.getInstance()
        val docRef = fbdb.collection("MissionPacks")

        //create a list for the missionPacks
        val missionPackList = mutableListOf<MissionPack>()

        //initialize info about data updates
        missionPackViewModel.allMissionPacks.observe(this, Observer { missionPack ->
            missionPack?.let { missionPackAdapter.submitList(it) }
        })

        //go through the documents and do shit
        docRef.get().addOnSuccessListener { document ->

            //loop trough all missionPacks
            for (i in document) {
                val missionPackName = i["name"]
                val missions = i["missions"] as ArrayList<HashMap<String,Any>>
                val secondaries = i["secondaries"] as ArrayList<HashMap<String,Any>>
                val expected = i["expected"] as Long
                val missionList = mutableListOf<Mission>()
                val secondaryList = mutableListOf<Objective>()
                missions.forEach { missionList.add(hashMapToMission(it))}
                secondaries.forEach { secondaryList.add(hashMapToObjective(it)) }
                val missionPack = MissionPack(missionPackName.toString(), missionList, secondaryList,expected.toInt())
                missionPackList.add(missionPack)
                missionPackAdapter.submitList(missionPackList)
            }

            popupWindow.contentView.buttonCancel.setOnClickListener {
                popupWindow.dismiss()
            }

            popupWindow.contentView.buttonOk.setOnClickListener {
                for (i in missionPackList){
                    missionPackViewModel.insert(i)
                }
                popupWindow.dismiss()
            }

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

    //initialize the recyclerView for data update
}