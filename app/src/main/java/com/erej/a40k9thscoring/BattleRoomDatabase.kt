package com.erej.a40k9thscoring

import android.content.Context
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [Battle::class],version = 1, exportSchema = false)
abstract class BattleRoomDatabase: RoomDatabase() {

    abstract fun battleDao(): BattleDAO

    companion object{


        @Volatile
        private var INSTANCE: BattleRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope):BattleRoomDatabase{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BattleRoomDatabase::class.java,
                    "battle_database"

                ).addCallback(BattleDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }

    }

    private class BattleDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                populate(database.battleDao())

                }
            }
        }

        suspend fun populate(battleDAO: BattleDAO){
            battleDAO.deleteAll()

            val testBattle = Battle(null,"TestiJere","Ei jere","ei mitään")
            testBattle.p1Secondary1 = 1
            battleDAO.insert(testBattle)


        }


    }

}