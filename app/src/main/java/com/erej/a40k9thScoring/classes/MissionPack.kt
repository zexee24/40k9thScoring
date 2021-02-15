package com.erej.a40k9thScoring.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.erej.a40k9thScoring.dataStoring.ObjectiveListConverter
import com.erej.a40k9thScoring.dataStoring.PrimaryListConverter


@Entity(tableName = "missionPack_table")
data class MissionPack(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "missionPack")
    val name : String,
    @TypeConverters(PrimaryListConverter::class)
    var  missions : List<Mission>,

    @TypeConverters(ObjectiveListConverter::class)
    var secondaries: List<Objective>

)

