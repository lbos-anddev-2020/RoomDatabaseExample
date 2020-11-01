package com.example.roomdatabaseexample.repository.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fakultaet
    (
    @PrimaryKey
    var name:String
     )