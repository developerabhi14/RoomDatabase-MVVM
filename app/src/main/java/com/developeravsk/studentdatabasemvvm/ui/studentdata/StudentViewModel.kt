package com.developeravsk.studentdatabasemvvm.ui.studentdata

import androidx.lifecycle.ViewModel
import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData
import com.developeravsk.studentdatabasemvvm.data.repositories.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(private val repo: StudentRepository) : ViewModel() {

    fun upsert(item: StudentData) = CoroutineScope(Dispatchers.Main).launch {
        repo.upsert(item)
    }

    fun delete(item: StudentData) = CoroutineScope(Dispatchers.Main).launch {
        repo.delete(item)
    }

    fun getAllData() = repo.getAllRecords()
}