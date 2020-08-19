package com.erej.a40k9thscoring


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

@Entity(tableName = "battle_table")
class Battle(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "battle")

    val id : Long?,
    val yourName : String,
    val opponentName : String,
    val battleType : String

) : Serializable{

     var roundCounter: Int = 1

     var p1Cp = 0
     var p2Cp = 0
     var p1Vp = 0
     var p2Vp = 0

     var p1Secondary1Vp: Int = 0
     var p1Secondary2Vp: Int = 0
     var p1Secondary3Vp: Int = 0
     var p2Secondary1Vp: Int = 0
     var p2Secondary2Vp: Int = 0
     var p2Secondary3Vp: Int = 0

    var p1Secondary1: Int = 0
    var p1Secondary2: Int = 0
    var p1Secondary3: Int = 0
    var p2Secondary1: Int = 0
    var p2Secondary2: Int = 0
    var p2Secondary3: Int = 0

    var p1Secondary1Counter1: Int = 0
    var p1Secondary2Counter1: Int = 0
    var p1Secondary3Counter1: Int = 0
    var p2Secondary1Counter1: Int = 0
    var p2Secondary2Counter1: Int = 0
    var p2Secondary3Counter1: Int = 0

    var p1Secondary1Counter2: Int = 0
    var p1Secondary2Counter2: Int = 0
    var p1Secondary3Counter2: Int = 0
    var p2Secondary1Counter2: Int = 0
    var p2Secondary2Counter2: Int = 0
    var p2Secondary3Counter2: Int = 0

    fun getSecondaryCounter(counterNumber: Int):Int{

        return when(counterNumber){
            1 -> this.p1Secondary1Counter1
            2 -> this.p1Secondary2Counter1
            3 -> this.p1Secondary3Counter1

            4 -> this.p2Secondary1Counter1
            5 -> this.p2Secondary2Counter1
            6 -> this.p2Secondary3Counter1

            11 -> this.p1Secondary1Counter2
            12 -> this.p1Secondary2Counter2
            13 -> this.p1Secondary3Counter2

            14 -> this.p2Secondary1Counter2
            15 -> this.p2Secondary2Counter2
            16 -> this.p2Secondary3Counter2
            else -> throw error("Problem in counter Indexing")
        }
    }

    fun getSecondaryVpCounter(counterNumber: Int):Int{

        return when(counterNumber){
            1 -> this.p1Secondary1Vp
            2 -> this.p1Secondary2Vp
            3 -> this.p1Secondary3Vp

            4 -> this.p2Secondary1Vp
            5 -> this.p2Secondary2Vp
            6 -> this.p2Secondary3Vp
            else -> throw error("Problem in counter Indexing")
        }
    }

    fun setSecondaryCounter(counterNumber: Int, counter: Int){

        when(counterNumber){
            1 -> this.p1Secondary1Counter1 = counter
            2 -> this.p1Secondary2Counter1 = counter
            3 -> this.p1Secondary3Counter1 = counter

            4 -> this.p2Secondary1Counter1 = counter
            5 -> this.p2Secondary2Counter1 = counter
            6 -> this.p2Secondary3Counter1 = counter

            11 -> this.p1Secondary1Counter2 = counter
            12 -> this.p1Secondary2Counter2 = counter
            13 -> this.p1Secondary3Counter2 = counter

            14 -> this.p2Secondary1Counter2 = counter
            15 -> this.p2Secondary2Counter2 = counter
            16 -> this.p2Secondary3Counter2 = counter

            else -> throw error("Problem in counter Indexing")
        }
        battleViewModel.update(this)
    }

    fun setSecondaryVpCounter(counterNumber: Int, counter: Int){

        when(counterNumber){
            1 -> this.p1Secondary1Vp = counter
            2 -> this.p1Secondary2Vp = counter
            3 -> this.p1Secondary3Vp = counter

            4 -> this.p2Secondary1Vp = counter
            5 -> this.p2Secondary2Vp = counter
            6 -> this.p2Secondary3Vp = counter
            else -> throw error("Problem in counter Indexing")
        }
        battleViewModel.update(this)
    }

}

private lateinit var battleAdapter: BattleRecyclerAdapter
lateinit var battleViewModel : BattleViewModel


class MainActivity : AppCompatActivity(), OnBattleClickListner{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init BattleViewModel
        battleViewModel = ViewModelProvider(this).get(BattleViewModel::class.java)

        //initialise recycler view
        initRecyclerView()

        //on data update
        battleViewModel.allBattles.observe(this, Observer {battles ->

            //update the ui
            battles?.let { battleAdapter.submitList(it)}
        })

        //create new battle
        addNewBattle.setOnClickListener{
        startActivity(Intent(this,CreateBattle::class.java))

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
            val intent = Intent(this,PlayGameActivity::class.java)
            intent.putExtra("battle", item)
        startActivity(intent)

    }

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