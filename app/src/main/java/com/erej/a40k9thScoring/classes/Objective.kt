package com.erej.a40k9thScoring.classes

import java.io.Serializable


data class Objective(

    val category : String,
    val name : String,
    val progressive: Boolean,

    /*
    0 = Command
    1 = Movement
    2 = Psychic
    3 = Shooting
    4 = Charge
    5 = Fight
    6 = End of round
     */

    val triggerPhases : List<Int>,
<<<<<<< HEAD
    val hint : String
=======
    val hint : String,
    val fragmentType: String,
    var counterHints : List<String> = listOf("no Hints", "no Hints", "no Hints")
<<<<<<< HEAD
<<<<<<< HEAD:app/src/main/java/com/erej/a40k9thScoring/classes/Secondary.kt
)
>>>>>>> c3fa666... Merge remote-tracking branch 'origin/master'
=======
) : Serializable
>>>>>>> 1de02ff... Started the massive cleanup from Battle.kt:app/src/main/java/com/erej/a40k9thScoring/classes/Objective.kt
=======
) : Serializable {


    var counter1: Int = 0
    var counter2: Int = 0
    var counter3: Int = 0
    var counterCheck1: Boolean = false
    var counterCheck2: Boolean = false
    var counterCheck3: Boolean = false
    var vp: Int = 0

    fun counterToVp(){
         when (this.name) {
            "Attrition", "Line Breaker" -> this.vp = 4 * counter1
            "Slay The Warlord" -> this.vp = 6 * counter1
            "Domination", "Investigate Sites", "Mental Interrogation", "Assassinate" -> this.vp = 3 * counter1
            "Repair Teleporter Homer" -> this.vp = 5 * counter1
            "Psychic Ritual" -> this.vp = (counter1 / 3) * 15
            "Titan Slayers" -> this.vp = counter1 * 10
            "Bring It Down" -> this.vp = counter1 * 2 + counter2 * 3
            "Thin Their Ranks" -> this.vp = (counter1 + counter2 * 10) / 10
            "Abhor The Witch" -> this.vp = counter1 * 3 + counter2 * 5
            "First Strike" -> this.vp = counter1 * 5 + counter2 * 3
            "Engage On All Fronts" -> this.vp = counter1 * 2 + counter2
            "While We Stand, We Fight" -> this.vp = counter1 * 5 + counter2 * 5 + counter3 * 5
            "Take and Hold" -> this.vp = counter1 * 5 + counter2 * 5 + counter3 * 5
             else -> this.vp = counter1 + counter2 + counter3
        }
        if (this.vp >= 15){
            this.vp = 15
        }
    }

    fun unCheck(){
        counterCheck1 = false
        counterCheck2 = false
        counterCheck3 = false
    }
}
>>>>>>> 8ced4de... TODO basically all objectiveFragments

<<<<<<< HEAD



) {
    var secondaryPoints = 0






}


public class SecondaryList() {


  public  fun getSecondaries(): List<Secondary> {
=======
class SecondaryList {

<<<<<<< HEAD
  fun getSecondaries(): List<Secondary> {
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'
        return listOf(
=======
    val getSecondaries = listOf(
<<<<<<< HEAD
<<<<<<< HEAD:app/src/main/java/com/erej/a40k9thScoring/classes/Secondary.kt
>>>>>>> 75dcba5... secondary/ primary interface persistence implemented, TODO implement the primaries in Primary.kt
            Secondary("None", "None", listOf(), "Be Empty","Empty"),
=======
            Objective("None", "None", listOf(), "Be Empty","Empty"),
>>>>>>> 1de02ff... Started the massive cleanup from Battle.kt:app/src/main/java/com/erej/a40k9thScoring/classes/Objective.kt
=======
            Objective("None", "None",false,  listOf(), "Be Empty","Empty"),
>>>>>>> bb6d45c... Things mostly cleaned up

            Objective(
                "Purge The Enemy",
                "Assassinate",
                false,
                listOf(1, 2, 3, 4),
<<<<<<< HEAD
                "Score 3 VP per slain enemy Character."
=======
                "Score 3 VP per slain enemy Character.",
                "Counter",
                listOf("Killed Characters")
>>>>>>> c3fa666... Merge remote-tracking branch 'origin/master'
            ),
            Objective(
                "Purge The Enemy",
                "Bring It Down",
                false,
                listOf(1, 2, 3, 4),
                "Score 2 VP for each slain Monster/Vehicle 3 VP instead if they had >10 Wounds.",
                "DualCounter",
                listOf("slain monsters/vehicles", "slain monsters/vehicles with >10 wounds")
            ),
            Objective(
                "Purge The Enemy",
                "Titan Slayers",
                false,
                listOf(1, 2, 3, 4),
                "Score 10 VP if you slay a TITANIC model, or 15 if you slay two.",
                "Counter"
            ),
            Objective(
                "Purge The Enemy",
                "Slay The Warlord",
                false,
                listOf(1, 2, 3, 4),
                "Score 6 VP for killing the enemy Warlord.",
                "OneCheckMark"
            ),

            Objective(
                "No Mercy, No Respite",
                "Thin Their Ranks",
                false,
                listOf(1, 2, 3, 4),
                "Set aside a tally of the number of models that you destroy." +
                        " Add 10 to the tally if you destroy a model with 10 or more wounds. At the end of the game, " +
                        "divide your tally by 10 and round down, then score that many VP.( E.G. a tally of 109 would yield 10 VP)",
                "DualCounter",
                listOf("Killed models", "Killed models with 10+ wounds")
            ),
            Objective(
                "No Mercy, No Respite",
                "Attrition",
                true,
                listOf(1, 2, 3, 4),
                "At the end of every battle round, score 4 VP if you destroyed more units than your opponent.",
                "OneCheckMark"
            ),
            Objective(
                "No Mercy, No Respite",
                "While We Stand, We Fight",
                false,
                listOf(1, 2, 3, 4),
                "Determine your 3 most expensive individual models." +
                        " At the end of the game, score 5 VP for each that survived the battle.",
                "ThreeCheckMarks",
                listOf("Is your Expensive unit alive?", "Is your Expensive unit alive?", "Is your Expensive unit alive?")
            ),
            Objective(
                "No Mercy, No Respite",
                "First Strike",
                false,
                listOf(1, 2, 3, 4),
                "Score 5 VP if you destroy an enemy unit on the first round. " +
                        "Score an extra 3 VP if you slay more units than your opponent in the first round.",
                "TwoCheckMarks"
            ),
            Objective(
                "Battlefield Supremacy",
                "Engage On All Fronts",
                true,
                listOf(1, 2, 3, 4),
                "Score 2 VP if you have a unit wholly within 3 of the 4 table quarters and they are also more than 6” from the center at the end of every round. " +
                        "Score 3 VP instead if you’re in all 4 table quarters.",
                "TwoCheckMarks"
            ),

            Objective(
                "Battlefield Supremacy",
                "Line Breaker",
                true,
                listOf(1, 2, 3, 4),
                "Score 4VP if you have two non-Aircraft units wholly within the enemy deployment zone. Score this at the end of every round.",
                "OneCheckMark"
            ),
            Objective(
                "Battlefield Supremacy",
                "Domination",
                true,
                listOf(1, 2, 3, 4),
                "Score 3VP if you control more than half the objectives at the end of every round.",
                "OneCheckMark"
            ),

            Objective(
                "Shadow Operations",
                "Investigate Sites",
                true,
                listOf(1, 2, 3, 4),
                "Action, non-Character Infantry only. Any Infantry unit can take this action if they are within 6” of the center of the board and there are no enemy units within 6” of the board. The action completed at the end of your turn, and every time you do you score 3VP.",
                "OneCheckMark"
            ),
            //TODO some action shenanigans
            Objective(
                "Shadow Operations",
                "Repair Teleporter Homer",
                true,
                listOf(1, 2, 3, 4),
                "Much like Investigate Sites, except you have to be wholly within the enemy deployment zone and the action completes at the end of your next  Command Phase. Scores 5VP if completed.",
                "OneCheckMark"
            ),
            Objective(
                "Shadow Operations",
                "Raise The Banners High",
                true,
                listOf(1, 2, 3, 4),
                "Action, Infantry Only. If your Infantry unit controls an objective and there are no enemy units nearby, you may take the Action. It completes at the end of your turn, leaving a banner on that objective. You score 1VP at the end of every Command Phase and the end of the game for every objective with a Banner. If the enemy gains control of an objective with a banner, that banner is removed and no longer scores VP.",
                "Counter"
            ),
            //TODO banners
            Objective(
                "Warpcraft",
                "Mental Interrogation",
                true,
                listOf(2),
                "Psychic Action, Warp Charge 4. Action is taken in the Psychic phase, requires you to be within 18” of an enemy character. Every successful completion scores 3VP.",
                "OneCheckMark"
            ),
            Objective(
                "Warpcraft",
                "Psychic Ritual",
                true,
                listOf(2),
                "Psychic Action, Warp Charge 3. Action can only be taken if you’re wholly within 6” of the battlefield. If completed 3 times, score 15VP",
                "OneCheckMark"
            ),
            Objective(
                "Warpcraft",
                "Abhor The Witch",
                false,
                listOf(0,1,2,3,4,5),
                "Score 3 VP for every slain Psyker, score 5 VP instead if they were also a Character.",
                "DualCounter"
            )


        )

    }

