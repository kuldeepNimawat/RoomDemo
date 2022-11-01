package com.newsapp.roomdemo.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.newsapp.roomdemo.entities.Student
import com.newsapp.roomdemo.entities.StudentSubjectCroRef
import com.newsapp.roomdemo.entities.Subject

data class StudentWithSubject(
    @Embedded
    val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCroRef :: class)
    )
    val subject : List<Subject>
)