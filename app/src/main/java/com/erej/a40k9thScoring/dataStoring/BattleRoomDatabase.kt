package com.erej.a40k9thScoring.dataStoring

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.erej.a40k9thScoring.Battle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [Battle::class],version = 1, exportSchema = false)
abstract class BattleRoomDatabase: RoomDatabase() {

    abstract fun battleDao(): BattleDAO

    companion object{


        @Volatile
        private var INSTANCE: BattleRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): BattleRoomDatabase {
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

<<<<<<< HEAD
<<<<<<< HEAD
            battleDAO.insert(Battle(null,"Testi1","Ei jere","ei mitään"))
            battleDAO.insert(Battle(null,"Testi2","Ei jere","ei mitään"))
            battleDAO.insert(Battle(null,"Testi3","Ei jere","ei mitään"))
=======
            val testBattle = Battle(null,"TestiJere","Ei jere","ei mitään")
=======

            val testBattle = Battle(null,"Testi Jere","Ei jere","ei mitään")
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> dc6b797... Merge remote-tracking branch 'origin/master'
            testBattle.p1Secondary1 = 1
            testBattle.p1Secondary2 = 2
            testBattle.p1Secondary3 = 3
            testBattle.p2Secondary1 = 4
=======
            testBattle.p1Secondary1 = 7
<<<<<<< HEAD:app/src/main/java/com/erej/a40k9thscoring/BattleRoomDatabase.kt
            testBattle.p1Secondary2 = 0
            testBattle.p1Secondary3 = 0
            testBattle.p2Secondary1 = 0
>>>>>>> 5c39fd9... 3 Check Mark counter done
            testBattle.p2Secondary2 = 0
            testBattle.p2Secondary3 = 0
=======
            testBattle.p1Secondary2 = 8
            testBattle.p1Secondary3 = 9
            testBattle.p2Secondary1 = 10
            testBattle.p2Secondary2 = 11
            testBattle.p2Secondary3 = 12
>>>>>>> f308786... Renamed as shit:app/src/main/java/com/erej/a40k9thScoring/BattleRoomDatabase.kt
=======
            testBattle.p1Secondary1 = 13
            testBattle.p1Secondary2 = 14
            testBattle.p1Secondary3 = 15
            testBattle.p2Secondary1 = 16
            testBattle.p2Secondary2 = 17
            testBattle.p2Secondary3 = 0
>>>>>>> 83b5257... All exept banners working.
            battleDAO.insert(testBattle)

>>>>>>> 1fc6641... Merge remote-tracking branch 'origin/master'

        }


    }

}