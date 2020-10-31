package com.example.roomdatabaseexample.repository.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fakultaet
    (
    @PrimaryKey
    var name:String
     )