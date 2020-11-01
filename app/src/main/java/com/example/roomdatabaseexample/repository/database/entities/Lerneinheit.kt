package com.example.roomdatabaseexample.repository.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Lerneinheit(
    @PrimaryKey(autoGenerate = false)
    var nummer:Int,
    var name:String,
    var kursNr:Int,
    var modulNr:Int
)