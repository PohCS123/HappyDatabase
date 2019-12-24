package com.example.happydatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

//all activity can use this view model if you declare like this...pass in application
class FeelingViewModel (application: Application):AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: FeelingRepository

    // LiveData gives us updated words when they change.
    val allFeelings : LiveData<List<Feeling>>

    //init is like the constructor of the class
    init{
        val feelingDao = FeelingDatabase.getDatabase(application).feelingDao()
        repository = FeelingRepository(feelingDao)
        allFeelings = repository.allFeelings
    }

}