package com.erej.a40k9thScoring.classes

import androidx.room.TypeConverter
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
    fun toObjective(s: String): Objective{
        return Gson().fromJson(s, Objective::class.java)
    }
}
}

class PrimaryConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromPrimary(primary: Primary): String{
            return Gson().toJson(primary)
        }

        @TypeConverter
        @JvmStatic
        fun toPrimary(s: String): Primary{
            return Gson().fromJson(s, Primary::class.java)
        }
    }
}