package com.example.antoine.examapp.db

import android.content.Context
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Questions::class), version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun favDao(): QuestionsDAO

    companion object {
        private var appDb : AppDataBase? = null

        fun getDataBase(context: Context?): AppDataBase{
            if(appDb == null){
                appDb = Room.databaseBuilder(context!!,AppDataBase::class.java,"user_db")
                        .allowMainThreadQueries()
                        .build()
            }
            return appDb!!
        }
    }
}