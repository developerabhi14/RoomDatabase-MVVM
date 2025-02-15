package com.developeravsk.studentdatabasemvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData


@Database(
    entities = [StudentData::class],
    version = 1
)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

    companion object {
        @Volatile
        private var instance: StudentDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StudentDatabase::class.java, "StudentDB.db"
            ).build()
    }
}