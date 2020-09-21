package com.erej.a40k9thScoring

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class BattleViewModel(application: Application): AndroidViewModel(application) {

     private val repository: BattleRepository

     val allBattles: LiveData<List<Battle>>

    init {
        val battleDAO = BattleRoomDatabase.getDatabase(application, viewModelScope).battleDao()
        repository = BattleRepository(battleDAO)
        allBattles = repository.allBattles
    }

     fun insert(battle: Battle) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(battle)
    }
     fun deleteOne(battle: Battle) = viewModelScope.launch(Dispatchers.IO){
         repository.delete(battle)
     }
     fun deleteAll() = viewModelScope.launch(Dispatchers.IO){
         repository.deleteAll()
     }
     fun update(battle: Battle) = viewModelScope.launch(Dispatchers.IO) {
         repository.update(battle)
     }
}