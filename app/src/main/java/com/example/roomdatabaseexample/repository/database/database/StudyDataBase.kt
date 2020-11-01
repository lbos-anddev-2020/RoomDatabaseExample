package com.example.roomdatabaseexample.repository.database.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabaseexample.repository.database.dataaccessobjects.FakultaetDao
import com.example.roomdatabaseexample.repository.database.entities.Fakultaet

@Database(entities = [Fakultaet::class],version = 1, exportSchema = false)
abstract class StudyDataBase():RoomDatabase()
{
    abstract val fakultaetDao: FakultaetDao

    companion object{

        @Volatile
        private var INSTANCE: StudyDataBase? = null

        fun createInstance(application: Application): StudyDataBase
        {
            synchronized(this)
            {
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        application.applicationContext,
                        StudyDataBase::class.java,
                        "StudyDB")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}