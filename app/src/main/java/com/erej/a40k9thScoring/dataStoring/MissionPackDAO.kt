package com.erej.a40k9thScoring.dataStoring

import androidx.lifecycle.LiveData
import androidx.room.*
import com.erej.a40k9thScoring.classes.MissionPack


@Dao
interface MissionPackDAO {

    @Query("SELECT * from missionPack_table ORDER BY missionPack ASC")
    fun getMissionPack(): LiveData<List<MissionPack>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(MissionPack: MissionPack)

    @Query("DELETE FROM missionPack_table")
    suspend fun deleteALL()

    @Delete
    suspend fun deleteOne(MissionPack: MissionPack)

    @Update
    suspend fun update(MissionPack: MissionPack)
}