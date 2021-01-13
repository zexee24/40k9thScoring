package com.erej.a40k9thScoring.dataStoring

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.erej.a40k9thScoring.classes.MissionPack

@Database(entities = [MissionPack::class], version = 1, exportSchema = false)

abstract class MissionPackRoomDatabase: RoomDatabase() {

    abstract fun missionPackDao(): MissionPackDAO

    companion object{

        @Volatile
        private var INSTANCE: MissionPackRoomDatabase? = null

        fun getDatabase(context: Context): MissionPackRoomDatabase{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MissionPackRoomDatabase::class.java,
                    "missionPack_database"
                ).addCallback(MissionPackDatabaseCallBack()).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class MissionPackDatabaseCallBack : RoomDatabase.Callback()
}