package com.erej.a40k9thScoring.classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.erej.a40k9thScoring.battleViewModel
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

    var missionType: String = ""

    @TypeConverters(PrimaryConverter::class)
    lateinit var primaryMission: Primary

    var roundCounter: Int = 1
    var phaseCounter: Int = 0

    var p1PrimaryVp: Int = 0
    var p2PrimaryVp: Int = 0

    var openedFragment: Int = 0

    var p1Cp = 0
    var p2Cp = 0
    var p1Vp = 0
    var p2Vp = 0

    var p1PrimaryCounter1: Int = 0
    var p1PrimaryCounter2: Int = 0
    var p1PrimaryCounter3: Int = 0


    var p2PrimaryCounter1: Int = 0
    var p2PrimaryCounter2: Int = 0
    var p2PrimaryCounter3: Int = 0


    var p1PrimaryCheck1: Boolean = false
    var p1PrimaryCheck2: Boolean = false
    var p1PrimaryCheck3: Boolean = false

    var p2PrimaryCheck1: Boolean = false
    var p2PrimaryCheck2: Boolean = false
    var p2PrimaryCheck3: Boolean = false

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

    var p1Secondary1Counter3: Int = 0
    var p1Secondary2Counter3: Int = 0
    var p1Secondary3Counter3: Int = 0

    var p2Secondary1Counter3: Int = 0
    var p2Secondary2Counter3: Int = 0
    var p2Secondary3Counter3: Int = 0

    var p1Secondary1Check1: Boolean = false
    var p1Secondary2Check1: Boolean = false
    var p1Secondary3Check1: Boolean = false

    var p2Secondary1Check1: Boolean = false
    var p2Secondary2Check1: Boolean = false
    var p2Secondary3Check1: Boolean = false

    var p1Secondary1Check2: Boolean = false
    var p1Secondary2Check2: Boolean = false
    var p1Secondary3Check2: Boolean = false

    var p2Secondary1Check2: Boolean = false
    var p2Secondary2Check2: Boolean = false
    var p2Secondary3Check2: Boolean = false

    var p1Secondary1Check3: Boolean = false
    var p1Secondary2Check3: Boolean = false
    var p1Secondary3Check3: Boolean = false

    var p2Secondary1Check3: Boolean = false
    var p2Secondary2Check3: Boolean = false
    var p2Secondary3Check3: Boolean = false

    var permanentP1Secondary1Check1: Boolean = false
    var permanentP1Secondary2Check1: Boolean = false
    var permanentP1Secondary3Check1: Boolean = false

    var permanentP2Secondary1Check1: Boolean = false
    var permanentP2Secondary2Check1: Boolean = false
    var permanentP2Secondary3Check1: Boolean = false

    var permanentP1Secondary1Check2: Boolean = false
    var permanentP1Secondary2Check2: Boolean = false
    var permanentP1Secondary3Check2: Boolean = false

    var permanentP2Secondary1Check2: Boolean = false
    var permanentP2Secondary2Check2: Boolean = false
    var permanentP2Secondary3Check2: Boolean = false

    var permanentP1Secondary1Check3: Boolean = false
    var permanentP1Secondary2Check3: Boolean = false
    var permanentP1Secondary3Check3: Boolean = false

    var permanentP2Secondary1Check3: Boolean = false
    var permanentP2Secondary2Check3: Boolean = false
    var permanentP2Secondary3Check3: Boolean = false

    fun getCheck(counterNumber: Int) : Boolean{

        return when(counterNumber){
            1 -> this.p1Secondary1Check1
            2 -> this.p1Secondary2Check1
            3 -> this.p1Secondary3Check1

            4 -> this.p2Secondary1Check1
            5 -> this.p2Secondary2Check1
            6 -> this.p2Secondary3Check1

            11 -> this.p1Secondary1Check2
            12 -> this.p1Secondary2Check2
            13 -> this.p1Secondary3Check2

            14 -> this.p2Secondary1Check2
            15 -> this.p2Secondary2Check2
            16 -> this.p2Secondary3Check2

            21 -> this.p1Secondary1Check3
            22 -> this.p1Secondary2Check3
            23 -> this.p1Secondary3Check3

            24 -> this.p2Secondary1Check3
            25 -> this.p2Secondary2Check3
            26 -> this.p2Secondary3Check3

            31 -> this.p1PrimaryCheck1
            41 -> this.p1PrimaryCheck2
            51 -> this.p1PrimaryCheck3

            32 -> this.p2PrimaryCheck1
            42 -> this.p2PrimaryCheck2
            52 -> this.p2PrimaryCheck3

            else -> throw error("Problem in counter Indexing")
        }
    }

    fun getPrimaryVpCounter(counterNumber: Int): Int{
        return when (counterNumber){
            31 -> this.p1PrimaryVp
            32 -> this.p2PrimaryVp
            else -> throw error("FUCKTREOAWJRAWEIHJAWET")
        }
    }

    fun setCheck(counterNumber: Int) {
         when(counterNumber){
             1 -> this.p1Secondary1Check1 = true
             2 -> this.p1Secondary2Check1 = true
             3 -> this.p1Secondary3Check1 = true

             4 -> this.p2Secondary1Check1 = true
             5 -> this.p2Secondary2Check1 = true
             6 -> this.p2Secondary3Check1 = true

             11 -> this.p1Secondary1Check2 = true
             12 -> this.p1Secondary2Check2 = true
             13 -> this.p1Secondary3Check2 = true

             14 -> this.p2Secondary1Check2 = true
             15 -> this.p2Secondary2Check2 = true
             16 -> this.p2Secondary3Check2 = true

             21 -> this.p1Secondary1Check3 = true
             22 -> this.p1Secondary2Check3 = true
             23 -> this.p1Secondary3Check3 = true

             24 -> this.p2Secondary1Check3 = true
             25 -> this.p2Secondary2Check3 = true
             26 -> this.p2Secondary3Check3 = true

             31 -> this.p1PrimaryCheck1 = true
             41 -> this.p1PrimaryCheck2 = true
             51 -> this.p1PrimaryCheck3 = true

             32 -> this.p2PrimaryCheck1 = true
             42 -> this.p2PrimaryCheck2 = true
             52 -> this.p2PrimaryCheck3 = true
            else -> throw error("Problem in counter Indexing")
        }
    }

    fun unCheck(counterNumber: Int) {

        when(counterNumber){
            1 -> this.p1Secondary1Check1 = false
            2 -> this.p1Secondary2Check1 = false
            3 -> this.p1Secondary3Check1 = false

            4 -> this.p2Secondary1Check1 = false
            5 -> this.p2Secondary2Check1 = false
            6 -> this.p2Secondary3Check1 = false

            11 -> this.p1Secondary1Check2 = false
            12 -> this.p1Secondary2Check2 = false
            13 -> this.p1Secondary3Check2 = false

            14 -> this.p2Secondary1Check2 = false
            15 -> this.p2Secondary2Check2 = false
            16 -> this.p2Secondary3Check2 = false

            21 -> this.p1Secondary1Check3 = false
            22 -> this.p1Secondary2Check3 = false
            23 -> this.p1Secondary3Check3 = false

            24 -> this.p2Secondary1Check3 = false
            25 -> this.p2Secondary2Check3 = false
            26 -> this.p2Secondary3Check3 = false

            31 -> this.p1PrimaryCheck1 = false
            41 -> this.p1PrimaryCheck2 = false
            51 -> this.p1PrimaryCheck3 = false

            32 -> this.p2PrimaryCheck1 = false
            42 -> this.p2PrimaryCheck2 = false
            52 -> this.p2PrimaryCheck3 = false
        }
    }

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

            21 -> this.p1Secondary1Counter3
            22 -> this.p1Secondary2Counter3
            23 -> this.p1Secondary3Counter3

            24 -> this.p2Secondary1Counter3
            25 -> this.p2Secondary2Counter3
            26 -> this.p2Secondary3Counter3

            31 -> this.p1PrimaryCounter1
            32 -> this.p2PrimaryCounter1

            41 -> this.p1PrimaryCounter1
            42 -> this.p2PrimaryCounter1

            51 -> this.p1PrimaryCounter1
            52 -> this.p2PrimaryCounter1
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

    //TODO secondary to vp reasonably

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

            21 -> this.p1Secondary1Counter3 = secondaryCounter
            22 -> this.p1Secondary2Counter3 = secondaryCounter
            23 -> this.p1Secondary3Counter3 = secondaryCounter

            24 -> this.p2Secondary1Counter3 = secondaryCounter
            25 -> this.p2Secondary2Counter3 = secondaryCounter
            26 -> this.p2Secondary3Counter3 = secondaryCounter

            31 -> this.p1PrimaryCounter1 = secondaryCounter
            32 -> this.p2PrimaryCounter1 = secondaryCounter

            41 -> this.p1PrimaryCounter1 = secondaryCounter
            42 -> this.p2PrimaryCounter1 = secondaryCounter

            51 -> this.p1PrimaryCounter1 = secondaryCounter
            52 -> this.p2PrimaryCounter1 = secondaryCounter
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
        if(this.getSecondaryVpCounter(counterNumber) < 0){
          throw error("Vp counter is under 0")
        }
        this.updateVp()
    }

    private fun setPrimaryVpCounter(counterNumber: Int, secondaryCounter: Int){
        when (counterNumber){
            31 -> p1PrimaryVp = secondaryCounter
            32 -> p2PrimaryVp = secondaryCounter
            else -> throw error("how did we get here?")
        }
        if(this.getPrimaryVpCounter(counterNumber) > 45){
            this.setPrimaryVpCounter(counterNumber, 45)
        }
        if(this.getPrimaryVpCounter(counterNumber) < 0){
            throw error("Vp counter is under 0")
        }


        this.updateVp()
    }

    fun secondaryToVpDual(objective: Objective, counterNumber: Int, secondaryCounter: Int, secondaryCounter2: Int){
        when (objective.name){
            "Bring It Down" -> this.setSecondaryVpCounter(counterNumber, 2 * secondaryCounter + 3 * secondaryCounter2)
            "Thin Their Ranks" -> this.setSecondaryVpCounter(counterNumber, (secondaryCounter + 10 * secondaryCounter2)/10)
            "Abhor The Witch" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter + 5 * secondaryCounter2)
        }
    }

    fun secondaryToVpCounter(objective: Objective, counterNumber: Int, secondaryCounter: Int){
        when (objective.name){
            "Assassinate" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter)
            "Titan Slayers" -> this.setSecondaryVpCounter(counterNumber,10 * secondaryCounter)

        }
    }

    fun secondaryToVpOneCheckMark(objective: Objective, counterNumber: Int, secondaryCounter: Int){
        when (objective.name){
            "Attrition" -> this.setSecondaryVpCounter(counterNumber, 4 * secondaryCounter)
            "Slay The Warlord" -> this.setSecondaryVpCounter(counterNumber, 6 * secondaryCounter)
            "Line Breaker" -> this.setSecondaryVpCounter(counterNumber, 4 * secondaryCounter)
            "Domination" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter)
            "Investigate Sites" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter)
            "Repair Teleporter Homer" -> this.setSecondaryVpCounter(counterNumber, 5 * secondaryCounter)
            "Mental Interrogation" -> this.setSecondaryVpCounter(counterNumber, 3 * secondaryCounter)
            "Psychic Ritual" -> this.setSecondaryVpCounter(counterNumber, (secondaryCounter / 3) * 15)

        }
    }

    fun secondaryToVpTwoCheckMarks(objective: Objective, counterNumber: Int, secondaryCounter: Int, secondaryCounter2: Int){
        when (objective.name){
            "First Strike" -> {

                if (secondaryCounter <= 1){
                    this.setSecondaryVpCounter(counterNumber, 5 * secondaryCounter)
                }
                if (secondaryCounter == 2){
                    this.setSecondaryVpCounter(counterNumber, 8)
                }
            }
            "Engage On All Fronts" -> this.setSecondaryVpCounter(counterNumber, 2 * secondaryCounter + secondaryCounter2)
        }
    }

    fun secondaryToVpThreeCheckMarks(objective: Objective, counterNumber: Int, secondaryCounter: Int, secondaryCounter2: Int, secondaryCounter3: Int){
        when (objective.name){
            "While We Stand, We Fight" -> this.setSecondaryVpCounter(counterNumber, 5 * secondaryCounter)
            "Take and Hold" -> this.setPrimaryVpCounter(counterNumber, 5 * secondaryCounter + 5 * secondaryCounter2 + 5 * secondaryCounter3)
        }
    }

    private fun updateVp() {
        p1Vp = p1PrimaryVp + p1Secondary1Vp + p1Secondary2Vp + p1Secondary3Vp
        p2Vp = p2PrimaryVp + p2Secondary1Vp + p2Secondary2Vp + p2Secondary3Vp
        battleViewModel.update(this)
    }
}