package com.erej.a40k9thScoring.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.erej.a40k9thScoring.R

class SecondaryAdapter(val context: Context, private val secondarySet : List<Objective>): BaseAdapter() {
    private val secondaryList: MutableList<Objective> = mutableListOf()
    private var secondaryNameList = secondaryList.map { it.name }
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        updateList("", "")
    }

    override fun getCount(): Int {
        return secondaryList.size
    }


    fun getPosition(objective: Objective): Int{
        for (i in secondaryList.indices){
            if (secondaryList[i] == objective){
                return i
            }
        }
        throw error("The objective for this mission is no longer in the secondary set / selectable")
    }

    override fun getItem(position: Int): Objective {
        return secondaryList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun updateList(category1 : String, category2: String) : List<String>{
        secondaryList.clear()
        secondaryList.add(secondarySet[0])
        for (i in secondarySet.drop(1)){
            if (i.category != category1 && i.category != category2){
                secondaryList.add(i)
            }
        }
        secondaryNameList = secondaryList.map { it.name }
        this.notifyDataSetChanged()
        return secondaryNameList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
             view = inflater.inflate(R.layout.support_simple_spinner_dropdown_item, parent, false)
        } else{
             view = convertView
        }
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = secondaryNameList[position].toString()
        return view
}
}