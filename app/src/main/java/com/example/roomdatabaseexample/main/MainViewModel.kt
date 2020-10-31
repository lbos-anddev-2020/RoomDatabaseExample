package com.example.roomdatabaseexample.main

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseexample.repository.database.Fakultaet
import com.example.roomdatabaseexample.repository.repository.AppRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(application: Application): AndroidViewModel(application)
{
    ////////////////////////////////////////////////////////////
    // Repository:
    private val repository = AppRepository(application)
    private var liveVocList = repository.getLiveDataVocs()

    ////////////////////////////////////////////////////////////
    // Methods to interact with the repository:
    fun insert(foreignWord:String)
    {
        viewModelScope.launch {
            val voc = Fakultaet(foreignWord)
            repository.insert(voc)
        }
    }

    fun update(fakultaet:Fakultaet)
    {
        viewModelScope.launch {
            repository.update(fakultaet)
        }
    }

    fun delete(fakultaet:Fakultaet)
    {
        viewModelScope.launch {
            repository.delete(fakultaet)
        }
    }

    fun getVocById(vocId:Long):Fakultaet?
    {
        var fakultaet:Fakultaet? = null
        viewModelScope.launch {
            fakultaet = repository.getVocById(vocId)
        }

        return fakultaet
    }

    fun getAllVocs():List<Fakultaet>?
    {
        var fakultaets:List<Fakultaet>? = null
        viewModelScope.launch {
            fakultaets =  repository.getAllVocs()
        }
        return fakultaets
    }

    ////////////////////////////////////////////////////////////
    // Getters for LiveData
    fun getLiveVocList():LiveData<List<Fakultaet>> = liveVocList

    ////////////////////////////////////////////////////////////
    // Utils
    @SuppressLint("SimpleDateFormat")
    private fun Date.toStringFormat(pattern:String="dd.MM.yyyy"):String
    {
        return SimpleDateFormat(pattern).format(this)
    }
}