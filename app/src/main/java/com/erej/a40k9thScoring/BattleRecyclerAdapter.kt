package com.erej.a40k9thScoring

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erej.a40k9thScoring.classes.Battle
import kotlinx.android.synthetic.main.layout_battle_list.view.*

class BattleRecyclerAdapter(private var clickListener: OnBattleClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items = emptyList<Battle>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return BattleViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_battle_list, parent,false)
    )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BattleViewHolder ->{
                holder.bind(items[position],clickListener)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(battleList: List<Battle>){
        items = battleList
        notifyDataSetChanged()
    }

fun  getBattleAtPosition(position : Int): Battle {
        return items[position]
    }



    class BattleViewHolder constructor(
        itemView: View
    ):RecyclerView.ViewHolder(itemView) {

        fun bind(battle: Battle, action: OnBattleClickListener){
            itemView.name1.text = battle.p1Name
            itemView.name2.text = battle.p2Name
            itemView.cp1.text = battle.p1Cp.toString()
            itemView.cp2.text = battle.p2Cp.toString()
            itemView.battleType.text = battle.battleType
            itemView.score1.text = battle.p1Vp.toString()
            itemView.score2.text = battle.p2Vp.toString()

            itemView.setOnClickListener{
                action.onItemClick(battle, adapterPosition)
            }
        }
    }


}

interface OnBattleClickListener{
    fun onItemClick(item: Battle, position: Int)
}