package com.example.happydatabase

import androidx.lifecycle.LiveData

class FeelingRepository(private val feelingDao: FeelingDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allFeelings: LiveData<List<Feeling>> =
        feelingDao.getAllRecord()

    suspend fun insertFeeling(feeling: Feeling){
        feelingDao.insertFeeling(feeling)
    }


}