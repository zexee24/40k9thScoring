package com.erej.a40k9thScoring.classes

import java.io.Serializable


data class Mission(
    val missionSize: String,
    val name: String,
    val missionRules: String,
    val briefing: String,
    val primaryObjective: Objective,
    val secondaryObjective: Objective,
    val setupImage: Int
): Serializable
