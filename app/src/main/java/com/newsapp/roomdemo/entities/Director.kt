package com.newsapp.roomdemo.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(autoGenerate = false)
    var directorName : String,
    var schoolName : String
)