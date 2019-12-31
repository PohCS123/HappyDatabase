package com.example.happydatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "feeling") //if not provide name, it will be the class name

data class Feeling(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val mode: Int, //1 = Sad, 2 = Sad, 3= Happy
    val remarks:String,
    val created_at: Long = System.currentTimeMillis()
)