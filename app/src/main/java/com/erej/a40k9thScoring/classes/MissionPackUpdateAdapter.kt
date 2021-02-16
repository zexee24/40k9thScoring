package com.erej.a40k9thScoring.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erej.a40k9thScoring.R
import kotlinx.android.synthetic.main.cardview_missionpack_update_status.view.*


class MissionPackUpdateRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = emptyList<MissionPack>()



    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(missionPackList: List<MissionPack>){
        items = missionPackList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MissionPackViewHolder).bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MissionPackViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_missionpack_update_status, parent, false)
        )
    }

    class MissionPackViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        fun bind(missionPack: MissionPack){
            itemView.textViewMissionPackName.text = missionPack.name
        }

        fun updateMissionStatus(missionPack: MissionPack, number : Int){
            itemView.textViewMissionNumber.text = number.toString()

            if (number == missionPack.expectedMission){
                itemView.progressBarMissions.visibility = View.GONE
            }
        }

        fun updateSecondaryStatus(missionPack: MissionPack, number : Int){
            itemView.textViewSecondaryNumber.text = number.toString()
            if (number == missionPack.expectedSecondaries){
                itemView.progressBarSecondaries.visibility = View.GONE
            }
        }
    }
}