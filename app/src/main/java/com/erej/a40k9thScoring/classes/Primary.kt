package com.erej.a40k9thScoring.classes

import com.erej.a40k9thScoring.R
import java.io.Serializable


data class Primary(
    val missionPack: String,
    val missionSize: String,
    val name: String,
    val missionRules: String,
    val briefing: String,
    val primaryObjective: Objective,
    val secondaryObjective: Objective,
    val setupImage: Int
): Serializable

class PrimaryList {

    private val secondaries = PrimarySpecificSecondaries().secondaryList
    private val primaries = PrimaryObjectives().primaryObjectives

    val missions: List<Primary> = listOf(
        Primary("Empty","Empty","Empty","","No briefing", primaries[0], secondaries[0],
         R.drawable.divide_and_conquer
        ),

        Primary(
            "Eternal War",
            "Combat patrol",
            "Incisive attack",
            "Sweep and Clear: In this mission, if you control an" +
                    "objective marker at the end of your Command phase, it" +
                    "remains under your control, even if you have no models" +
                    "within range of it, unless your opponent controls it at the" +
                    "end of any subsequent phase.",
            "Two forces have dug in and fought to a stalemate. Adopting a new approach to the war, opportunistic bands of warriors now venture forth into no man'.s land to seize vital" +
                    "ground and defeat the enemy with surgical assaults across" +
                    "the front..",
            primaries[1],
            secondaries[0],
            //TODO surgical assault page 286
            R.drawable.incisive_attack
        ),

        Primary(
            "Eternal War",
            "Incursion",
            "Divide and conquer",
            "The enemy's advance forces are seeking to expand into our territory, but they risk overextending themselves. If  you strike quickly and capture key battlefield locations you can drive a wedge between the fo e's warriors, divorcing them fr om their support units and making them easy prey to dispatch at your leisure.",
            "",
            primaries[1],
            secondaries[1],
            R.drawable.divide_and_conquer
        )
    )
}