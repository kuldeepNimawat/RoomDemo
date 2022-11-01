package com.newsapp.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.newsapp.roomdemo.database.SchoolDatabase
import com.newsapp.roomdemo.entities.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getDatabaseInstance(this).schoolDao

        val directors = listOf(
            Director("Kuldeep Singh", "BR Hindu Vidya Peeth"),
            Director("Aazad", "AA Sr. Sec. School"),
            Director("Suman", "BR Globle Public School"),
        )

        val school = listOf(
            School("BR Hindu Vidya Peeth"),
            School("AA Sr. Sec. School"),
            School("BR Globle Public School")
        )

        val subject = listOf(
            Subject("Hindi"),
            Subject("Math"),
            Subject("Science"),
            Subject("English"),
            Subject("Sanskrit")
        )

        val student = listOf(
            Student("Prithi", 2, "BR Hindu Vidya Peeth"),
            Student("Raj", 4, "BR Hindu Vidya Peeth"),
            Student("Shekhar", 6, "BR Hindu Vidya Peeth"),
            Student("Suman", 3, "AA Sr. Sec. School"),
            Student("Sanju", 5, "AA Sr. Sec. School"),
            Student("Purav", 1, "BR Globle Public School"),
            Student("Prachi", 6, "BR Globle Public School"),
            Student("Krish", 8, "BR Globle Public School"),
            Student("Richa", 5, "BR Globle Public School")
        )

        val studentSubjectCroRef = listOf(
            StudentSubjectCroRef("Prithi", "Science"),
            StudentSubjectCroRef("Prithi", "Math"),
            StudentSubjectCroRef("Shekhar", "Math"),
            StudentSubjectCroRef("Suman", "Hindi"),
            StudentSubjectCroRef("Suman", "English"),
            StudentSubjectCroRef("Suman", "English"),
            StudentSubjectCroRef("Prachi","English"),
            StudentSubjectCroRef("Krish", "Sanskrit"),
            StudentSubjectCroRef("Krish", "Hindi")
        )

        lifecycleScope.launch {
            directors.forEach{
                dao.insertDirector(it)
            }
            school.forEach {
                dao.insertSchool(it)
            }
            subject.forEach {
                dao.insertSubject(it)
            }
            student.forEach {
                dao.insertStudent(it)
            }
            studentSubjectCroRef.forEach {
                dao.insertStudenSubjectCroRef(it)
            }
            //----------you can access all data here-----------
        }
    }
}