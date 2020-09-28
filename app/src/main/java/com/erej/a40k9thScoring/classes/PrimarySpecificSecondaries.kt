package com.erej.a40k9thScoring.classes

class PrimarySpecificSecondaries{

     val secondaryList: List<Secondary> = listOf(
        Secondary("None", "None", listOf(), "Be Empty","Empty"),

        Secondary(
            "Specific",
            "Lines Of Demarcation", listOf(6),
            "At the end of your turn, you score 4 victory points if you control both objective markers labelled A, or 2 victory points if you control both  objective markers labelled B.",
            "TwoCheckMarks",
            listOf("You control both objectives labeled A", "You control both objectives labeled A"))
    )

}