package com.newsapp.roomdemo.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.newsapp.roomdemo.entities.Director
import com.newsapp.roomdemo.entities.School

data class SchoolAndDirector(
    @Embedded
    val school : School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director : Director
)