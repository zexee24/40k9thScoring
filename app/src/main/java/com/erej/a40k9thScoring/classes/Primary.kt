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
            "Sweep and Clear: In this mission, if you control an " +
                    "objective marker at the end of your Command phase, it " +
                    "remains under your control, even if you have no models " +
                    "within range of it, unless your opponent controls it at the " +
                    "end of any subsequent phase. ",
            "Two forces have dug in and fought to a stalemate. Adopting a new approach to the war, opportunistic bands of warriors now venture forth into no man'.s land to seize vital " +
                    "ground and defeat the enemy with surgical assaults across " +
                    "the front..",
            primaries[1],
            secondaries[1],
            R.drawable.incisive_attack
        ),

        Primary(
            "Eternal War",
            "Combat patrol",
            "Outriders",
            "",
            "Advance parties have ranged ahead of the main force in " +
                    "preparation for a large push into enemy territory. They " +
                    "must scout the area, fight off enemy patrols and secure key " +
                    "locations that will prove vital to hold in the larger battle " +
                    "to come.",
            primaries[1],
            secondaries[2],
            //TODO survey page 287
            R.drawable.ouriders
        ),

        Primary(
            "Eternal War",
            "Combat patrol",
            "Encircle",
            "",
            "Both forces have converged on this vital location and a " +
                    "firefight has ensued. Neither side is willing to cede ground, " +
                    "but successfully circumventing the enemy's position " +
                    "will open up a brutal crossfire leaving the objectives for " +
                    "the taking.",
            primaries[1],
            secondaries[3],
            //TODO encircle page 288
            R.drawable.encircle
        ),

        Primary(
            "Eternal War",
            "Incursion",
            "Divide and conquer",
            "",
            "The enemy's advance forces are seeking to expand into our territory, but they risk overextending themselves. If  you strike quickly and capture key battlefield locations you can drive a wedge between the fo e's warriors, divorcing them fr om their support units and making them easy prey to dispatch at your leisure.",
            primaries[1],
            secondaries[4],
            R.drawable.divide_and_conquer
        ),

        Primary(
            "Eternal War",
            "Incursion",
            "Crossfire",
            "Crossfire: When resolving attacks against target units " +
                    "that are within 9\" of the centre of the battlefield, those " +
                    "attacks ignore the benefits of cover provided you can " +
                    "satisfy at least one of the following conditions:\n " +
                    "• You control both objective markers labelled A and the " +
                    "attacking model's unit is in range of an objective marker " +
                    "labelled A.\n" +
                    "• You control both objective markers labelled B and the " +
                    "attacking model's unit is in range of an objective marker " +
                    "labelled B.",
            "Enemy forces are massing in the area, seeking to secure " +
                    "the battlefield. A direct assault against them may result " +
                    "in unacceptable casualties, but victory can be assured by " +
                    "outflanking the foe and catching them in a deadly crossfire",
        primaries[1],
        secondaries[5],
        R.drawable.crossfire
    ),
        Primary(
            "Eternal War",
            "Incursion",
            "Centre ground",
            "",
            "You must advance swiftly into contested territory to seize " +
                "the battlefield while maintaining a strong rearguard to " +
                "protect your supply lines. The battleground is won and lost " +
                "one yard at a time, and a commander must simultaneously " +
                "master offensive and defensive tactics if they are to prevail.", primaries[1], secondaries[6],
            //TODO centre ground p.291
            R.drawable.centre_ground
        ),
        Primary(
            "Eternal War",
            "Incursion",
            "Forward push",
            "Quick March: Any Advance rolls of less than 3 made in " +
                    "the first battle round instead count as 3.",
            "This area is of extreme importance and you have been " +
                    "ordered to push forward and lead an immediate all-out " +
                    "assault to capture it. Storm every site of tactical import and " +
                    "leave the foe with no place to hide.",
            primaries[1], secondaries[7],
            //TODO forward push p.292
            R.drawable.forward_push
        ),
        Primary(
            "Eternal War",
            "Incursion",
            "Ransack",
            "",
            "With reinforcements on the way, both forces hastily attempt " +
                    "to establish a fortified position. Whoever secures the line " +
                    "will be able to dig in and outlast their enemy. However, if " +
                    "the enemy's position can be overrun, a brutal grinding war " +
                    "could be avoided.",
            primaries[2], secondaries[8],
            //TODO ransack p.293
            R.drawable.ransack
        ),
        Primary(
            "Eternal War",
            "Incursion",
            "Shifting front",
            "Supply Lines: In this mission, a player only receives the " +
                    "Battle-forged CP bonus at the start of their Command " +
                    "phase if they control the objective marker in their " +
                    "deployment zone.",
            "Both forces strike out from their positions, probing the front " +
                    "for vulnerable weak points ahead of an all-out offensive. " +
                    "The slightest gap in the opponent's defensive line could give " +
                    "our forces the breakthrough needed to cut off the enemy's " +
                    "supply lines.",
            primaries[1], secondaries[9],
            //TODO test their lines p.293
            R.drawable.shifting_front
        )


    )
}