package com.example.roomdatabaseexample.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FakultaetDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fakultaet:Fakultaet)

    @Delete
    suspend fun delete(fakultaet:Fakultaet)

    @Update
    suspend fun update(fakultaet:Fakultaet)

    @Query("SELECT * FROM Fakultaet WHERE name = :nameFakultaet")
    suspend fun getVocById(nameFakultaet:Long):Fakultaet

    @Query("SELECT * FROM Fakultaet")
    suspend fun getVocList():List<Fakultaet>

    @Query("SELECT * FROM Fakultaet")
    fun getLiveDataVocList():LiveData<List<Fakultaet>>
}