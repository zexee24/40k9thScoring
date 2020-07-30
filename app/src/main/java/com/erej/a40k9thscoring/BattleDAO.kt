package com.erej.a40k9thscoring

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface BattleDAO {

    @Query("SELECT * from battle_table ORDER BY battle ASC")
    fun getBattle(): LiveData<List<Battle>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(battle: Battle)

    @Query ("DELETE FROM battle_table ")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteOne(battle: Battle)



}