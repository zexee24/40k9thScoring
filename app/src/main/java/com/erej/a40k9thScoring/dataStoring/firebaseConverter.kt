package com.erej.a40k9thScoring.dataStoring

import com.erej.a40k9thScoring.classes.Objective
import com.google.firebase.firestore.QueryDocumentSnapshot


fun fireBaseConverter(document : Map<String,Any>): Objective{
    val name = document["name"] as String
    val category = document["category"] as String
    val counterHints = document["counterHints"] as ArrayList <String>
    val fragmentType = document["fragmentType"] as String
    val hint = document["hint"] as String
    val progressive = document["progressive"] as Boolean
    val triggerPhases = document["triggerPhases"] as ArrayList<Int>

    return Objective(category, name, progressive, triggerPhases.toList(), hint, fragmentType, counterHints.toList())
}

fun fireBaseConverter(document: QueryDocumentSnapshot): Objective{
    val name = document["name"] as String
    val category = document["category"] as String
    val counterHints = document["counterHints"] as ArrayList <String>
    val fragmentType = document["fragmentType"] as String
    val hint = document["hint"] as String
    val progressive = document["progressive"] as Boolean
    val triggerPhases = document["triggerPhases"] as ArrayList<Int>

    return Objective(category, name, progressive, triggerPhases.toList(), hint, fragmentType, counterHints.toList())
}