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
             listOf("You control both objectives labeled A", "You control both objectives labeled A"))

     )

}