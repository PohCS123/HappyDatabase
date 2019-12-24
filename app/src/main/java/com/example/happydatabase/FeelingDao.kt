package com.example.happydatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FeelingDao {

    @Insert
    suspend fun insertFeeling(feeling: Feeling) //suspend= background doing things

    @Update
    suspend fun updateFeeling(feeling: Feeling)

    @Delete
    suspend fun deleteFeeling(feeling: Feeling)

    //Query can dont need to put suspend

    @Query("SELECT * FROM feeling")
    fun getAllRecord():LiveData<List<Feeling>>

    @Query("SELECT * FROM feeling WHERE id=:search_id")
    fun getOneRecord(search_id:Int): Feeling
}