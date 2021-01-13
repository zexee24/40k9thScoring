package com.erej.a40k9thScoring.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.erej.a40k9thScoring.dataStoring.PrimaryConverter


@Entity(tableName = "missionPack_table")
data class MissionPack(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "missionPack")
    val name : String,
    @TypeConverters(PrimaryConverter::class)
    val missions : List<Mission>,
    val secondaries: List<Objective>,
    val missionsSpecificSecondaries: List<Objective>
)
