package com.newsapp.roomdemo.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.newsapp.roomdemo.entities.Student
import com.newsapp.roomdemo.entities.Subject

@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCroRef(
    val studentName: String,
    val subjectName: String
)