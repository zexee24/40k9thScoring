package com.erej.a40k9thScoring.classes

class PrimaryObjectives{

    val primaryObjectives: List<Objective> = listOf(

        Objective("Primary", "None",false, listOf(), "Be Empty","Empty"),

        Objective(
            "Primary",
            "Take and Hold",
            true,
            listOf(6),
            "At the end of each player's Command phase, the player whose turn it is scores 5 victory points for each of the following conditions they satisfy (for a maximum of 15 victory points):\n" +
                    "• They control one or more objective markers.\n" +
                    "• They control two or more objective markers.\n" +
                    "• They control more objective markers than their\n" +
                    "opponent controls. This primary objective cannot be scored in the first battle round.",
            "ThreeCheckMarks",
            listOf("You control one or more objective markers", "You control two or more objective markers", "You control more objective markers than your opponent" )),

        Objective(
            "Primary",
            "Domination",
            true,
            listOf(6),
            "At the end of each player's Command phase, the player whose turn it is scores 5 victory points for each of the following conditions they satisfy (for a maximum of 15 victory points):\n" +
                    "• They control two or more objective markers.\n" +
                    "• They control three or more objective markers.\n" +
                    "• They control more objective markers than their\n" +
                    "opponent controls. This primary objective cannot be scored in the first battle round.",
            "ThreeCheckMarks",
            listOf("You control two or more objective markers", "You control three or more objective markers", "You control more objective markers than your opponent" )),

        Objective(
            "Primary",
            "Unified Advance",
            true,
            listOf(6),
            "At the end of each player's Command phase, the player whose turn it is scores 5 victory points for each of the following conditions they satisfy (for a maximum of 15 victory points):\n" +
                    "• They control one or more objective markers.\n" +
                    "• They control at least one objective marker labelled A and at least one objective marker labelled C.\n" +
                    "• They control at least one objective marker labelled A, at least one objective marker labelled B and at least one objective marker labelled C.\n" +
                    "This primary objective cannot be scored in the first battle round.",
            "ThreeCheckMarks",
            listOf("You control one or more objective markers", "You control at least one objective marker labelled A and at least one objective marker labelled C.", "You control at least one objective marker labelled A, at least one objective marker labelled B and at least one objective marker labelled C." ))

    )

}