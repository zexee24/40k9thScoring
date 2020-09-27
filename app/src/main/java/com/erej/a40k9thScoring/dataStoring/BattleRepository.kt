package com.erej.a40k9thScoring.dataStoring

import androidx.lifecycle.LiveData
import com.erej.a40k9thScoring.classes.Battle

class BattleRepository(private val battleDAO: BattleDAO) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allBattles: LiveData<List<Battle>> = battleDAO.getBattle()

    suspend fun insert(battle: Battle) {
        battleDAO.insert(battle)
    }
    suspend fun delete(battle: Battle){
        battleDAO.deleteOne(battle)
    }
    suspend fun deleteAll(){
        battleDAO.deleteAll()
    }
    suspend fun update(battle: Battle){
        battleDAO.update(battle)
    }
}