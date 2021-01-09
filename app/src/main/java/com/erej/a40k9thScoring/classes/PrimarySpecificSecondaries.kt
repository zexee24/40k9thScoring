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
             listOf("You control the objective marker in your opponent's DZ")),

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
             listOf("You control the objective both objective markers not in either players DZ")),

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
             "DualCounter",
             listOf("You have at least one unit from your army wholly withing 6\" of you battlefield edge and atleast on unit wholly within 6\" of your opponent's edge", "one of them is also in your opponent's DZ")),

         Objective(
             "Specific",
             "Lines Of Demarcation",
             true,
             listOf(6),
             "At the end of your turn, you score 4 victory points if you control both objective markers labelled A, or 2 victory points if you control both  objective markers labelled B.",
             "DualCounter",
             listOf("You control both objectives labeled A", "You control both objectives labeled A")),

         Objective(
             "Specific",
             "Outflank",
             true,
             listOf(0),
             "At the end of your Command phase, you score 3 victory points if you control both of the objective markers labelled A. Score 5 victory points instead if, at the end of your Command phase, you control both of the objective markers labelled A and there is at least one enemy unit within 9\" of the centre of the battlefield. This secondary objective cannot be scored in the first battle round.",
             "DualCounter",
             listOf("You control both objectives labeled A", "You control both objectives labeled A and there is an enemy unit 9\" of the centre of the table")),

         Objective(
             "Specific",
             "Center ground",
             true,
             listOf(0,1),
             "Each time a unit from your army successfully completes the following action, you score 3 victory points if you currently control one of the objective markers labelled A, or 5 victory points if you currently control both objective markers labelled A. \n" +
                     "One unit from your army can start to perform this action at the end of your Movement phase if it is within range of an objective marker labelled A and no enemy units (excluding AIRCRAFT) are within range of that objective marker. The action is completed at the end of your next Command phase so long as the unit performing it is still within range of the same objective marker.",
             "Dual",
             listOf("You completed the action while controlling one objective labelled A", "You completed the action while controlling two objectives labelled A")),

         Objective(
             "Specific",
             "Forward Push",
             true,
             listOf(0,1),
             "One unit from your army can start to perform this action at the start of your Movement phase if it is within range of an objective marker that you control. The action is completed at the end of your turn and you score a number of victory points depending on which objective marker this action was performed on:" +
                     "A : 1, B : 2, C : 4, D : 8 for p1 or reverse for p2",
             "Counter",
             listOf("Points gained for completing the action")),

         Objective(
             "Specific",
             "Ransack",
             true,
             listOf(0,1),
             "Score a number of victory points " +
                     "at the end of your Command phase if you control one " +
                     "or more of the objective markers that are within your " +
                     "opponent's territory, as shown in the table below:\n " +
                     "1 : 2\n" +
                     "2 : 3\n" +
                     "3 : 5",
             "Counter",
             listOf("You control 1 objective in your opponent's territory", "You control 2 objective in your opponent's territory", "You control 3 objective in your opponent's territory")),

         Objective(
             "Specific",
             "Test Their Line",
             true,
             listOf(0,1),
             "Score 3 victory points at " +
                     "the end of your turn if two or more units from your army " +
                     "(excluding AIR CRAFT) are wholly within your opponent's " +
                     "deployment zone and at least two different battlefield " +
                     "edges have at least one of those units wholly within 6\" of " +
                     "them (if one of those battlefield edges is your opponent's " +
                     "battlefield edge, score 5 victory points instead). For the " +
                     "purposes of this objective, a unit can only count as being " +
                     "wholly within 6\" of one battlefield edge at a time - if " +
                     "a unit is within 6\" of two battlefield edges because it is " +
                     "in the corner of the battlefield, you can select which " +
                     "battlefield edge it counts as being wholly within 6\" of at " +
                     "the end of your turn.",
             "Counter",
             listOf("You two or more units wholly within your opponent's DZ and wholly within 6\" of two different battlefield edges", "One of those edges is your opponent's")),

         Objective(
             "Specific",
             "Minimise Losses",
             false,
             listOf(0,1),
             "At the start of the battle, " +
                     "add up the number of units in your army - this is your " +
                     "army's Strength. If a unit splits to form two or more " +
                     "individual units during the battle, then immediately " +
                     "increase your army's Strength accordingly (e.g. if one " +
                     "unit in your army splits to form three individual units, " +
                     "your army's Strength is increased by 2). If a unit merges " +
                     "with another to form a combined unit during the battle, " +
                     "then decrease your army's strength accordingly (e.g. if " +
                     "two units from your army merge to form one unit, you " +
                     "immediately decrease your army's strength by I). At the " +
                     "end of the battle, add up how many units from your army " +
                     "are left on the battlefield, including all units embarked " +
                     "within TRANSPO RTS, but excluding all units that have been " +
                     "added to your army during the battle. If the total is 75% " +
                     "or more of your army's Strength, score 15 victory points; " +
                     "if the total is less than 75%, but is 50% or more of your " +
                     "army's Strength, score 10 victory points; if the total is less " +
                     "than 50%, but is 25% or more of your army's Strength, " +
                     "score 5 victory points.",
             "Counter",
             listOf("You have >= 75% of your units remaining", "You have < 75% but >= 50 of your units remaining", "You have < 50% but >= 25% of your units remaining")),


         Objective(
             "Specific",
             "Vital Ground",
             true,
             listOf(0),
             "At the end of each of " +
                     "your Command phases, you score 3 victory points if " +
                     "you control the objective marker in your opponent's " +
                     "deployment zone, and score 2 victory points for each " +
                     "objective marker that you control that is not in either " +
                     "player's deployment zone (for a maximum of 7 victory " +
                     "points). This secondary objective cannot be scored in the " +
                     "first battle round.",
             "DualCounter",
             listOf("You control the objective in your opponent's DZ", "Other objectives you control ")),

         Objective(
             "Specific",
             "Siphon Power",
             true,
             listOf(0,1),
             "If you select this objective, " +
                     "units in your army can perform the following action: " +
                     "Siphon Power (Action): One or more units from your " +
                     "army can start to perform this action at the end of your " +
                     "Movement phase. Each unit that starts to perform this " +
                     "action must be within range of a different objective " +
                     "marker. A unit cannot start this action while any enemy " +
                     "units (excluding AIRCRAFT) are in range of the same " +
                     "objective marker. The action is completed at the end of " +
                     "your next Command phase, and you score a number of " +
                     "victory points depending on how many units completed " +
                     "this action this phase, as shown in the table below:\n " +
                     "1 : 1\n" +
                     "2 : 3\n" +
                     "3 : 6\n" +
                     "4 : 10",
             "Counter",
             listOf("Number of points gained")),

         Objective(
             "Specific",
             "Secure No Man's Land",
             true,
             listOf(0,1),
             "At the end of each " +
                     "of your turns, if you control the central objective marker " +
                     "you score a number of victory points equal to the current " +
                     "battle round number (so 1 victory point in the first battle " +
                     "round, 2 victory points in the second battle round etc.).",
             "CheckMark",
             listOf("You Control the central objective marker.")),

         Objective(
             "Specific",
             "Raze",
             false,
             listOf(0,1),
             "At the end of the battle, a player " +
                     "scores 5 victory points if one objective marker was " +
                     "removed from the battlefield due to a successful Raze " +
                     "Objective action performed by a unit from their army " +
                     "during the battle, and 15 victory points if two objective " +
                     "markers were so removed.",
             "DualCounter",
             listOf("You razed 1 objective", "You razed 2 objectives")),

         Objective(
             "Specific",
             "Data Intercept",
             true,
             listOf(0,1),
             "Each time a unit from " +
                     "your army successfully completes the following action, " +
                     "you score a number of victory points equal to the number " +
                     "of objective markers you currently control:\n" +
                     "Data Intercept (Action): One unit from your army can " +
                     "start to perform this action at the end of your Movement " +
                     "phase if it is within range of an objective marker and " +
                     "no enemy units (excluding AIRCRAFT) are within range " +
                     "of that objective marker. The action is completed at " +
                     "the end of your next Command phase so long as the " +
                     "unit performing it is still within range of the same " +
                     "objective marker.",
             "Counter",
             listOf("Number of objectives you control."))




     )

}