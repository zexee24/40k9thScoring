package com.erej.a40k9thScoring.dataStoring

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.erej.a40k9thScoring.classes.Battle


@Database(entities = [Battle::class],version = 1, exportSchema = false)
@TypeConverters(ObjectiveConverter::class, PrimaryConverter::class)
abstract class BattleRoomDatabase: RoomDatabase() {

    abstract fun battleDao(): BattleDAO

    companion object{


        @Volatile
        private var INSTANCE: BattleRoomDatabase? = null

        fun getDatabase(context: Context): BattleRoomDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BattleRoomDatabase::class.java,
                    "battle_database"

                ).addCallback(BattleDatabaseCallback()).build()
                INSTANCE = instance
                return instance
            }
        }

    }

    private class BattleDatabaseCallback : RoomDatabase.Callback()

}