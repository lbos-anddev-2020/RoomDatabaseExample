package com.example.roomdatabaseexample.repository.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.roomdatabaseexample.repository.database.entities.Fakultaet
import com.example.roomdatabaseexample.repository.database.dataaccessobjects.FakultaetDao
import com.example.roomdatabaseexample.repository.database.database.StudyDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository(application: Application)
{
    private val fakultaetDao: FakultaetDao

    init {
        val db = StudyDataBase.createInstance(application)
        fakultaetDao = db.fakultaetDao
    }

    // Implement all functions
    suspend fun insert(fakultaet: Fakultaet)
    {
        withContext(Dispatchers.IO)
        {
            fakultaetDao.insert(fakultaet)
        }
    }

    suspend fun delete(fakultaet: Fakultaet)
    {
        withContext(Dispatchers.IO)
        {
            fakultaetDao.delete(fakultaet)
        }
    }

    suspend fun update(fakultaet: Fakultaet)
    {
        withContext(Dispatchers.IO)
        {
            fakultaetDao.update(fakultaet)
        }
    }

    suspend fun getVocById(vocId:Long): Fakultaet?
    {
        var fakultaet: Fakultaet? = null
        withContext(Dispatchers.IO)
        {
            fakultaet =  fakultaetDao.getVocById(vocId)
        }
        return fakultaet
    }

    suspend fun getAllVocs():List<Fakultaet>?
    {
        var fakultaets:List<Fakultaet>? = null
        withContext(Dispatchers.IO)
        {
            fakultaets =  fakultaetDao.getVocList()
        }
        return fakultaets
    }

    fun getLiveDataVocs():LiveData<List<Fakultaet>>
    {
        return fakultaetDao.getLiveDataVocList()
    }
}