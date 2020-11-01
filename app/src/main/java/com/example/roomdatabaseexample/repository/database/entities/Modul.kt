package com.example.roomdatabaseexample.repository.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Modul(
    @PrimaryKey(autoGenerate = false)
    var nummer:Int,
    var name:String,
    var courses_bool:Boolean
)