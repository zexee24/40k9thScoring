package com.erej.a40k9thScoring.dataStoring

import androidx.room.TypeConverter
import com.erej.a40k9thScoring.classes.Mission
import com.erej.a40k9thScoring.classes.Objective
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun HashMapToObjective(hashMap: HashMap<String,Any>) {

}

fun HashMapToMission(hashMap: HashMap<String,Any>) {

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