package com.erej.a40k9thScoring.dataStoring

import androidx.lifecycle.LiveData
import androidx.room.*
import com.erej.a40k9thScoring.classes.Battle


@Dao
interface BattleDAO {

    @Query("SELECT * from battle_table ORDER BY battle ASC")
    fun getBattle(): LiveData<List<Battle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(battle: Battle)

    @Query ("DELETE FROM battle_table ")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteOne(battle: Battle)

    @Update
    suspend fun update(battle: Battle)


}