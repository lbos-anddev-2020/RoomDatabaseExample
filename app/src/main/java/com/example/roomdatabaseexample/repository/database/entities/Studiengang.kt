package com.example.roomdatabaseexample.repository.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
class Studiengang (

        @PrimaryKey(autoGenerate = false)
        var name:String,
        var fakultaet: String,
        var modul_status:Boolean
    )
