package com.erej.a40k9thScoring

data class Primary(
    val name: String,
    val triggerPhases: List<Int>,
    val objectiveName: String,
    val objectiveHint: String,
    val objectiveHints: List<String>,
    val objectiveSecondary: Secondary
)

class PrimaryList {
    val primaries: List<Primary> = listOf(
        Primary("empty", listOf(0), "empty", "empty", listOf("empty"), SecondaryList().getSecondaries[0])

    )
}