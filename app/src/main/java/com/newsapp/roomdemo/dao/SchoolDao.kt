package com.newsapp.roomdemo.dao

import androidx.room.*
import com.newsapp.roomdemo.entities.*
import com.newsapp.roomdemo.entities.relation.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student : Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudenSubjectCroRef(studentSubjectCroRef: StudentSubjectCroRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName =:schoolName")
    suspend fun getSchoolAndDirectorUsingSchoolName(schoolName: String) : List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName =:schoolName")
    suspend fun getSchoolWithStudentsUsingSchoolName(schoolName: String) : List<SchoolWithStudent>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName =:subjectName")
    suspend fun getStudentsOfSubject(subjectName: String) : List<SubjectWithStudent>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName =:studentName")
    suspend fun getSubjectsOfStudent(studentName: String) : List<StudentWithSubject>
}