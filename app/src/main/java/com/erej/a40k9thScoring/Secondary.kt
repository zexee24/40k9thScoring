package com.erej.a40k9thScoring

data class Secondary(
    val category : String,
    val name : String,

    /*
    0 = Command
    1 = Movement
    2 = Psychic
    3 = Shooting
    4 = Charge
    5 = Fight
     */

    val triggerPhases : List<Int>,
    val hint : String,
    val fragmentType: String,
    var counterHints : List<String> = listOf("no Hints", "no Hints", "no Hints")
)

class SecondaryList {

  fun getSecondaries(): List<Secondary> {
        return listOf(
            Secondary("None", "None", listOf(), "Be Empty","Empty"),

            Secondary(
                "Purge The Enemy",
                "Assassinate",
                listOf(1, 2, 3, 4),
                "Score 3 VP per slain enemy Character.",
                "Counter",
                listOf("Killed Characters")
            ),
            Secondary(
                "Purge The Enemy",
                "Bring It Down",
                listOf(1, 2, 3, 4),
                "Score 2 VP for each slain Monster/Vehicle 3 VP instead if they had >10 Wounds.",
                "DualCounter",
                listOf("slain monsters/vehicles", "slain monsters/vehicles with >10 wounds")
            ),
            Secondary(
                "Purge The Enemy",
                "Titan Slayers",
                listOf(1, 2, 3, 4),
                "Score 10 VP if you slay a TITANIC model, or 15 if you slay two.",
                "Counter"
            ),
            Secondary(
                "Purge The Enemy",
                "Slay The Warlord",
                listOf(1, 2, 3, 4),
                "Score 6 VP for killing the enemy Warlord.",
                "OneTimeCheckMark"
            ),

            Secondary(
                "No Mercy, No Respite",
                "Thin Their Ranks",
                listOf(1, 2, 3, 4),
                "Set aside a tally of the number of models that you destroy." +
                        " Add 10 to the tally if you destroy a model with 10 or more wounds. At the end of the game, " +
                        "divide your tally by 10 and round down, then score that many VP.( E.G. a tally of 109 would yield 10 VP)",
                "DualCounter"
            ),
            Secondary(
                "No Mercy, No Respite",
                "Attrition",
                listOf(1, 2, 3, 4),
                "At the end of every battle round, score 4 VP if you destroyed more units than your opponent.",
                "OneCheckMark"
            ),
            Secondary(
                "No Mercy, No Respite",
                "While We Stand, We Fight",
                listOf(1, 2, 3, 4),
                "Determine your 3 most expensive individual models." +
                        " At the end of the game, score 5 VP for each that survived the battle.",
                "ThreeOneTimeCheckMarks",
                listOf("Is your Expensive unit alive?", "Is your Expensive unit alive?", "Is your Expensive unit alive?")
            ),
            Secondary(
                "No Mercy, No Respite",
                "First Strike",
                listOf(1, 2, 3, 4),
                "Score 5 VP if you destroy an enemy unit on the first round. " +
                        "Score an extra 3 VP if you slay more units than your opponent in the first round.",
                "TwoOneTimeCheckMarks"
            ),
            Secondary(
                "Battlefield Supremacy",
                "Engage On All Fronts",
                listOf(1, 2, 3, 4),
                "Score 2 VP if you have a unit wholly within 3 of the 4 table quarters and they are also more than 6” from the center at the end of every round. " +
                        "Score 3 VP instead if you’re in all 4 table quarters.",
                "TwoCheckMarks"
            ),

            Secondary(
                "Battlefield Supremacy",
                "Line Breaker",
                listOf(1, 2, 3, 4),
                "Score 4VP if you have two non-Aircraft units wholly within the enemy deployment zone. Score this at the end of every round.",
                "OneCheckMark"
            ),
            Secondary(
                "Battlefield Supremacy",
                "Domination",
                listOf(1, 2, 3, 4),
                "Score 3VP if you control more than half the objectives at the end of every round.",
                "OneCheckMark"
            ),

            Secondary(
                "Shadow Operations",
                "Investigate Sites",
                listOf(1, 2, 3, 4),
                "Action, non-Character Infantry only. Any Infantry unit can take this action if they are within 6” of the center of the board and there are no enemy units within 6” of the board. The action completed at the end of your turn, and every time you do you score 3VP.",
                "OneCheckMark"
            ),
            //TODO some action shenanigans
            Secondary(
                "Shadow Operations",
                "Repair Teleporter Homer",
                listOf(1, 2, 3, 4),
                "Much like Investigate Sites, except you have to be wholly within the enemy deployment zone and the action completes at the end of your next  Command Phase. Scores 5VP if completed.",
                "OneCheckMark"
            ),
            Secondary(
                "Shadow Operations",
                "Raise The Banners High",
                listOf(1, 2, 3, 4),
                "Action, Infantry Only. If your Infantry unit controls an objective and there are no enemy units nearby, you may take the Action. It completes at the end of your turn, leaving a banner on that objective. You score 1VP at the end of every Command Phase and the end of the game for every objective with a Banner. If the enemy gains control of an objective with a banner, that banner is removed and no longer scores VP.",
                "Counter"
            ),
            //TODO banners
            Secondary(
                "Warpcraft",
                "Mental Interrogation",
                listOf(2),
                "Psychic Action, Warp Charge 4. Action is taken in the Psychic phase, requires you to be within 18” of an enemy character. Every successful completion scores 3VP.",
                "OneCheckMark"
            ),
            Secondary(
                "Warpcraft",
                "Psychic Ritual",
                listOf(2),
                "Psychic Action, Warp Charge 3. Action can only be taken if you’re wholly within 6” of the battlefield. If completed 3 times, score 15VP",
                "OneCheckMark"
            ),
            Secondary(
                "Warpcraft",
                "Abhor The Witch",
                listOf(2),
                "Score 3 VP for every slain Psyker, score 5 VP instead if they were also a Character.",
                "DualCounter"
            )


        )

    }

}