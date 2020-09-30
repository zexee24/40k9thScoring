package com.erej.a40k9thScoring.classes

class PrimarySpecificSecondaries{

     val secondaryList: List<Objective> = listOf(
        Objective("None", "None",true, listOf(), "Be Empty","Empty"),

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