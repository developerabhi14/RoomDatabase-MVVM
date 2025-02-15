package com.developeravsk.studentdatabasemvvm.ui.studentdata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.developeravsk.studentdatabasemvvm.data.repositories.StudentRepository

class StudentViewModelFactory(
    private val repo: StudentRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StudentViewModel(repo) as T
    }
}