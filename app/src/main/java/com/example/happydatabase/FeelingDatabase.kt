package com.example.happydatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//multiple table
// entities = [Feeling::class, AnotherTable::class]
@Database(entities = arrayOf(Feeling::class),version=1)

abstract class FeelingDatabase:RoomDatabase() {
    //Instance of DAO
    abstract fun feelingDao():FeelingDao

    //Ensure only one instance of the database is created
    companion object{
        @Volatile
        private var INSTANCE: FeelingDatabase? = null

        fun getDatabase(context:Context):FeelingDatabase{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }

            //Create an instance of database
            synchronized(this){
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    FeelingDatabase::class.java,
                    "feeling_db"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}