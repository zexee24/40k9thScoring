package com.erej.a40k9thScoring.classes

class PrimaryObjectives{

    val primaryObjectives: List<Objective> = listOf(

        Objective("None", "None", listOf(), "Be Empty","Empty"),

        Objective(
            "None",
            "Take and Hold",
            listOf(6),
            "At the end of each player's Command phase, the player whose turn it is scores 5 victory points for each of the following conditions they satisfy (for a maximum of 1 5 victory points):\n" +
                    "• They control one or more objective markers.\n" +
                    "• They control two or more objective markers.\n" +
                    "• They control more objective markers than their\n" +
                    "opponent controls. This primary objective cannot be scored in the first battle round.",
            "ThreeCheckMarks",
            listOf("You control one or more objective markers", "You control two or more objective markers", "You control more objective markers than your opponent" ))
    )
}