package com.erej.a40k9thScoring.dataStoring

import androidx.room.TypeConverter
import com.erej.a40k9thScoring.classes.Mission
import com.erej.a40k9thScoring.classes.Objective
import com.google.gson.Gson

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