package com.developeravsk.studentdatabasemvvm.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studentRecords")
data class StudentData(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "address")
    var address: String,
    @ColumnInfo(name = "phone")
    var phone: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}