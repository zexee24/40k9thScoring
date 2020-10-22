package com.erej.a40k9thScoring.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.erej.a40k9thScoring.dataStoring.PrimaryConverter
import java.io.Serializable

@Entity(tableName = "battle_table")
class Battle(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "battle")
    val id : Long?

) : Serializable {

    var p1Name : String = ""
    var p2Name : String = ""
    var battleType : String = ""

    var missionType: String = ""

    @TypeConverters(PrimaryConverter::class)
    lateinit var primaryMission: Primary

    @TypeConverters(PrimaryConverter::class)
    lateinit var primaryMissionP1: Primary

    @TypeConverters(PrimaryConverter::class)
    lateinit var primaryMissionP2: Primary

    var createCounter: Int = 0

    var roundCounter: Int = 1
    var phaseCounter: Int = 0
    var turn1: Int = 0
    var turnCounter: Int = 0

    var openedFragment: Int = 0

    var p1Cp = 0
    var p2Cp = 0
    var p1Vp = 0
    var p2Vp = 0

    var p1Secondary1: Objective = SecondaryList().getSecondaries[0]
    var p1Secondary2: Objective = SecondaryList().getSecondaries[0]
    var p1Secondary3: Objective = SecondaryList().getSecondaries[0]

    var p2Secondary1: Objective = SecondaryList().getSecondaries[0]
    var p2Secondary2: Objective = SecondaryList().getSecondaries[0]
    var p2Secondary3: Objective = SecondaryList().getSecondaries[0]
}