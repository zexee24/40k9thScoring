package com.erej.a40k9thScoring.dataStoring

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.erej.a40k9thScoring.classes.MissionPack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MissionPackViewModel(application: Application): AndroidViewModel(application){

    private val repository: MissionPackRepository

    val allMissionPacks: LiveData<List<MissionPack>>

    init {
        val missionPackDAO = MissionPackRoomDatabase.getDatabase(application).missionPackDao()
        repository = MissionPackRepository(missionPackDAO)
        allMissionPacks = repository.allMissionPacks
    }
    fun insert(missionPack: MissionPack) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(missionPack)
    }
    fun deleteOne(missionPack: MissionPack) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(missionPack)
    }
    fun deleteALL() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
    fun update(missionPack: MissionPack) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(missionPack)
    }
}