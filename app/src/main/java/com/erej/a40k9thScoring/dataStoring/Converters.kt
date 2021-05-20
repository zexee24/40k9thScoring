package com.erej.a40k9thScoring.dataStoring

import androidx.room.TypeConverter
import com.erej.a40k9thScoring.classes.Mission
import com.erej.a40k9thScoring.classes.Objective
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun hashMapToObjective(hashMap: HashMap<String,Any>): Objective {
    val category = hashMap["category"] as String
    val name = hashMap["name"] as String
    val progressive = hashMap["progressive"] as Boolean
    val triggerPhases = hashMap["triggerPhases"] as List<Int>
    val hint = hashMap["hint"] as String
    val fragmentType = hashMap["fragmentType"] as String
    return Objective(category, name, progressive, triggerPhases, hint, fragmentType)
}

fun hashMapToMission(hashMap: HashMap<String,Any>): Mission {
    val name = hashMap["name"] as String
    val missionSize = hashMap["size"] as String
    val missionRules = hashMap["rules"] as String
    val primaryObjective = hashMapToObjective(hashMap["primaryObjective"] as HashMap<String,Any>)
    val secondaryObjective = hashMapToObjective(hashMap["secondaryObjective"] as HashMap<String,Any>)
    val briefing = hashMap["briefing"] as String
    val setupImage = hashMap["setupImage"] as Long
    return (Mission(missionSize,name,missionRules,briefing,primaryObjective,secondaryObjective,setupImage.toInt()))

}

class ObjectiveConverter {

companion object {

    @TypeConverter
    @JvmStatic
    fun fromObjective(objective: Objective): String{
       return Gson().toJson(objective)
    }

    @TypeConverter
    @JvmStatic
    fun toObjective(s: String): Objective {
        return Gson().fromJson(s, Objective::class.java)
    }
}
}

class PrimaryConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromPrimary(mission: Mission): String{
            return Gson().toJson(mission)
        }

        @TypeConverter
        @JvmStatic
        fun toPrimary(s: String): Mission {
            return Gson().fromJson(s, Mission::class.java)
        }
    }
}

class PrimaryListConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromPrimaryList(missions: List<Mission>): String{
            return Gson().toJson(missions)
        }

        @TypeConverter
        @JvmStatic
        fun toPrimaryList(s: String): List<Mission> {
            val type = object : TypeToken<List<Mission>>(){}.type
            return Gson().fromJson(s, type)
        }
    }
}

class ObjectiveListConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromObjectiveList(objectives: List<Objective>): String{
            return Gson().toJson(objectives)
        }

        @TypeConverter
        @JvmStatic
        fun toObjectiveList(s: String): List<Objective> {
            val type = object : TypeToken<List<Objective>>(){}.type
            return Gson().fromJson(s, type)
        }
    }
}