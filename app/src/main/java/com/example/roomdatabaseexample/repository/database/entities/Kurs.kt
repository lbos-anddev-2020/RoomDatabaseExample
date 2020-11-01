package com.example.roomdatabaseexample.repository.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Kurs(
    @PrimaryKey(autoGenerate = false)
    var nummer:Int,
    var name:String
)