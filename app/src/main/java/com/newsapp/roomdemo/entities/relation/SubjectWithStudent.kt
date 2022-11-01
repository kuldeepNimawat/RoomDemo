package com.newsapp.roomdemo.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.newsapp.roomdemo.entities.Student
import com.newsapp.roomdemo.entities.StudentSubjectCroRef
import com.newsapp.roomdemo.entities.Subject

data class SubjectWithStudent(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCroRef::class)
    )
    val student : List<Student>
)