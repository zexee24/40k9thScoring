package com.erej.a40k9thScoring

import android.content.Context
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


            val testBattle = Battle(null,"Testi Jere","Ei jere","ei mitään")
            testBattle.p1Secondary1 = 7
            testBattle.p1Secondary2 = 8
            testBattle.p1Secondary3 = 9
            testBattle.p2Secondary1 = 10
            testBattle.p2Secondary2 = 11
            testBattle.p2Secondary3 = 12
            battleDAO.insert(testBattle)


        }


    }

}