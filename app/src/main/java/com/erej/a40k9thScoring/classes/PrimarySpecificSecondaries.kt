package com.erej.a40k9thScoring.classes

class PrimarySpecificSecondaries{

     val secondaryList: List<Objective> = listOf(
        Objective("None", "None",true, listOf(), "Be Empty","Empty"),

         Objective(
             "Specific",
             "Surgical Assault",
             true,
             listOf(6),
             "Score 5 victory points " +
                     "if you control the objective marker in your opponent's " +
                     "deployment zone at the end of your turn.",
             "OneCheckMark",
             listOf("You control the objective marker in your opponent's deployment zone")),

         Objective(
             "Specific",
             "Survey",
             true,
             listOf(6),
             "Score 5 victory points if you " +
                     "control both of the objective markers that are not in " +
                     "either player's deployment zone at the end of your " +
                     "Command phase. This secondary objective cannot be " +
                     "scored in the first battle round.",
             "OneCheckMark",
             listOf("You control the objective both objective markers not in either players deployment zone")),

         Objective(
             "Specific",
             "Encircle",
             true,
             listOf(6),
             "Score 3 victory points if you have " +
                     "at least one unit from your army (excluding AIRCRAFT) " +
                     "wholly within 6\" of your battlefield edge and at least one " +
                     "unit from your army (excluding AIRCRAFT) wholly within " +
                     "6\" of your opponent's battlefield edge at the end of your " +
                     "turn ( score 5 victory points instead if one of these units is " +
                     "also wholly within your opponent's deployment zone).",
             "TwoCheckMarks",
             listOf("You have at least one unit from your army wholly withing 6\" of you battlefield edge and atleast on unit wholly within 6\" of your opponent's edge", "one of them is also in your opponent's deployment zone")),

         Objective(
             "Specific",
             "Lines Of Demarcation",
             true,
             listOf(6),
             "At the end of your turn, you score 4 victory points if you control both objective markers labelled A, or 2 victory points if you control both  objective markers labelled B.",
             "TwoCheckMarks",
             listOf("You control both objectives labeled A", "You control both objectives labeled A")),

         Objective(
             "Specific",
             "Outflank",
             true,
             listOf(0),
             "At the end of your Command phase, you score 3 victory points if you control both of the objective markers labelled A. Score 5 victory points instead if, at the end of your Command phase, you control both of the objective markers labelled A and there is at least one enemy unit within 9\" of the centre of the battlefield. This secondary objective cannot be scored in the first battle round.",
             "TwoCheckMarks",
             listOf("You control both objectives labeled A", "You control both objectives labeled A and there is an enemy unit 9\" of the centre of the table")),

         Objective(
             "Specific",
             "Center ground",
             true,
             listOf(0,1),
             "Each time a unit from your army successfully completes the following action, you score 3 victory points if you currently control one of the objective markers labelled A, or 5 victory points if you currently control both objective markers labelled A. \n" +
                     "One unit from your army can start to perform this action at the end of your Movement phase if it is within range of an objective marker labelled A and no enemy units (excluding AIRCRAFT) are within range of that objective marker. The action is completed at the end of your next Command phase so long as the unit performing it is still within range of the same objective marker.",
             "TwoCheckMarks",
             listOf("You completed the action while controlling one objective labelled A", "You completed the action while controlling two objectives labelled A")),

         Objective(
             "Specific",
             "Outflank",
             true,
             listOf(0,1),
             "One unit from your army can start to perform this action at the start of your Movement phase if it is within range of an objective marker that you control. The action is completed at the end of your turn and you score a number of victory points depending on which objective marker this action was performed on:" +
                     "A : 1, B : 2, C : 4, D : 8 for p1 or reverse for p2",
             "Counter",
             listOf("Points gained for completing the action"))

     )

}