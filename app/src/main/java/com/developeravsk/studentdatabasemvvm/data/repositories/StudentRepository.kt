package com.developeravsk.studentdatabasemvvm.data.repositories

import com.developeravsk.studentdatabasemvvm.data.db.StudentDatabase
import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData

class StudentRepository(private val db: StudentDatabase) {

    suspend fun upsert(item: StudentData) = db.getStudentDao().upsert(item);

    suspend fun delete(item: StudentData) = db.getStudentDao().delete(item)

    fun getAllRecords() = db.getStudentDao().getAllData()
}
