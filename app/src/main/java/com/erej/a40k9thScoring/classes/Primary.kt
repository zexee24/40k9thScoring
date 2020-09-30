package com.erej.a40k9thScoring.classes

import com.erej.a40k9thScoring.R
import java.io.Serializable


data class Primary(
    val name: String,
    val briefing: String,
    val primaryObjective: Objective,
    val secondaryObjective: Objective,
    val setupImage: Int
): Serializable

class PrimaryList {

    private val secondaries = PrimarySpecificSecondaries().secondaryList
    private val primaries = PrimaryObjectives().primaryObjectives

    val missions: List<Primary> = listOf(
        Primary("empty","no briefing", primaries[0], secondaries[0],
         R.drawable.divide_and_conquer
        ),

        Primary(
            "Divide and conquer",
            "The enemy's advance forces are seeking to expand into our territory, but they risk overextending themselves. If  you strike quickly and capture key battlefield locations you can drive a wedge between the fo e's warriors, divorcing them fr om their support units and making them easy prey to dispatch at your leisure.",
            primaries[1],
            secondaries[1],
            R.drawable.divide_and_conquer
        )
    )
}