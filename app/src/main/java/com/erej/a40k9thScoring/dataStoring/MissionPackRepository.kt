package com.erej.a40k9thScoring.dataStoring

import androidx.lifecycle.LiveData
import com.erej.a40k9thScoring.classes.MissionPack

class MissionPackRepository(private val missionPackDAO: MissionPackDAO){

    val allMissionPacks: LiveData<List<MissionPack>> = missionPackDAO.getMissionPack()

    suspend fun insert(missionPack: MissionPack){
        missionPackDAO.insert(missionPack)
    }

    suspend fun delete(missionPack: MissionPack){
        missionPackDAO.deleteOne(missionPack)
    }

    suspend fun deleteAll(){
        missionPackDAO.deleteALL()
    }

    suspend fun update(missionPack: MissionPack){
        missionPackDAO.update(missionPack)
    }
}