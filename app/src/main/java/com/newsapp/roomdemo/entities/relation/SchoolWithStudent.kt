package com.newsapp.roomdemo.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.newsapp.roomdemo.entities.School
import com.newsapp.roomdemo.entities.Student

data class SchoolWithStudent(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students : List<Student>
)