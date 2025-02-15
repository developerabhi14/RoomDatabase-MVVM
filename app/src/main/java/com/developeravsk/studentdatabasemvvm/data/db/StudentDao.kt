package com.developeravsk.studentdatabasemvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData


@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: StudentData)

    @Delete
    suspend fun delete(item: StudentData)

    @Query("Select * from studentRecords")
    fun getAllData(): LiveData<List<StudentData>>
}