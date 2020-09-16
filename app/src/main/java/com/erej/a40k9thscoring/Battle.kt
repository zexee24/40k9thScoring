package com.erej.a40k9thscoring

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "battle_table")
class Battle(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "battle")

    val id : Long?,
    val yourName : String,
    val opponentName : String,
    val battleType : String

) : Serializable {

    var roundCounter: Int = 1
    var phaseCounter: Int = 0

    var p1Cp = 0
    var p2Cp = 0
    var p1Vp = 0
    var p2Vp = 0

    var p1Secondary1Vp: Int = 0
    var p1Secondary2Vp: Int = 0
    var p1Secondary3Vp: Int = 0
    var p2Secondary1Vp: Int = 0
    var p2Secondary2Vp: Int = 0

    var p2Secondary3Vp: Int = 0

    var p1Secondary1: Int = 0
    var p1Secondary2: Int = 0
    var p1Secondary3: Int = 0
    var p2Secondary1: Int = 0
    var p2Secondary2: Int = 0
    var p2Secondary3: Int = 0

    var p1Secondary1Counter1: Int = 0
    var p1Secondary2Counter1: Int = 0
    var p1Secondary3Counter1: Int = 0
    var p2Secondary1Counter1: Int = 0
    var p2Secondary2Counter1: Int = 0
    var p2Secondary3Counter1: Int = 0

    var p1Secondary1Counter2: Int = 0
    var p1Secondary2Counter2: Int = 0
    var p1Secondary3Counter2: Int = 0
    var p2Secondary1Counter2: Int = 0
    var p2Secondary2Counter2: Int = 0
    var p2Secondary3Counter2: Int = 0

    fun getSecondaryCounter(counterNumber: Int):Int{

        return when(counterNumber){
            1 -> this.p1Secondary1Counter1
            2 -> this.p1Secondary2Counter1
            3 -> this.p1Secondary3Counter1

            4 -> this.p2Secondary1Counter1
            5 -> this.p2Secondary2Counter1
            6 -> this.p2Secondary3Counter1

            11 -> this.p1Secondary1Counter2
            12 -> this.p1Secondary2Counter2
            13 -> this.p1Secondary3Counter2

            14 -> this.p2Secondary1Counter2
            15 -> this.p2Secondary2Counter2
            16 -> this.p2Secondary3Counter2
            else -> throw error("Problem in counter Indexing")
        }
    }

    fun getSecondaryVpCounter(counterNumber: Int):Int{

        return when(counterNumber){
            1 -> this.p1Secondary1Vp
            2 -> this.p1Secondary2Vp
            3 -> this.p1Secondary3Vp

            4 -> this.p2Secondary1Vp
            5 -> this.p2Secondary2Vp
            6 -> this.p2Secondary3Vp
            else -> throw error("Problem in counter Indexing")
        }
    }

    fun setSecondaryCounter(counterNumber: Int, secondaryCounter: Int){

        when(counterNumber){
            1 -> this.p1Secondary1Counter1 = secondaryCounter
            2 -> this.p1Secondary2Counter1 = secondaryCounter
            3 -> this.p1Secondary3Counter1 = secondaryCounter

            4 -> this.p2Secondary1Counter1 = secondaryCounter
            5 -> this.p2Secondary2Counter1 = secondaryCounter
            6 -> this.p2Secondary3Counter1 = secondaryCounter

            11 -> this.p1Secondary1Counter2 = secondaryCounter
            12 -> this.p1Secondary2Counter2 = secondaryCounter
            13 -> this.p1Secondary3Counter2 = secondaryCounter

            14 -> this.p2Secondary1Counter2 = secondaryCounter
            15 -> this.p2Secondary2Counter2 = secondaryCounter
            16 -> this.p2Secondary3Counter2 = secondaryCounter

            else -> throw error("Problem in counter Indexing")
        }
        battleViewModel.update(this)
    }

    private fun setSecondaryVpCounter(counterNumber: Int, secondaryCounter: Int){

        when(counterNumber){
            1 -> this.p1Secondary1Vp = secondaryCounter
            2 -> this.p1Secondary2Vp = secondaryCounter
            3 -> this.p1Secondary3Vp = secondaryCounter

            4 -> this.p2Secondary1Vp = secondaryCounter
            5 -> this.p2Secondary2Vp = secondaryCounter
            6 -> this.p2Secondary3Vp = secondaryCounter
            else -> throw error("Problem in counter Indexing")
        }
        if(this.getSecondaryVpCounter(counterNumber) > 15){
            this.setSecondaryVpCounter(counterNumber, 15)
        }
        battleViewModel.update(this)
    }

    fun secondaryToVpDual(secondary: Secondary, counterNumber: Int, secondaryCounter: Int, secondaryCounter2: Int){
        when (secondary.name){
            "Bring It Down" -> this.setSecondaryVpCounter(counterNumber, 2 * secondaryCounter + 3 * secondaryCounter2)
            "Thin Their Ranks" -> this.setSecondaryVpCounter(counterNumber, secondaryCounter + 10 * secondaryCounter2)
            "Abhor The Witch" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter + 5 * secondaryCounter2)
        }
    }

    fun secondaryToVpCounter(secondary: Secondary, counterNumber: Int, secondaryCounter: Int){
        when (secondary.name){
            "Assassinate" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter)
            "Titan Slayers" -> this.setSecondaryVpCounter(counterNumber,10 * secondaryCounter)
            "Mental Interrogation" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter)
        }
    }

    fun secondaryToVpOneTimeCheckMark(secondary: Secondary, counterNumber: Int, secondaryCounter: Int){
        when (secondary.name){
            "Slay The Warlord" -> this.setSecondaryVpCounter(counterNumber, 6 * secondaryCounter)
        }
    }

    fun secondaryToVpOneCheckMark(secondary: Secondary, counterNumber: Int, secondaryCounter: Int){
        when (secondary.name){
            "Attrition" -> this.setSecondaryVpCounter(counterNumber, 4 * secondaryCounter)

        }
    }


}