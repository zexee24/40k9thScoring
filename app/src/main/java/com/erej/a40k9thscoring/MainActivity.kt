package com.erej.a40k9thscoring


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
    val yourCP : Int,
    val opponentCP : Int,
    val battleType : String

) : Serializable

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