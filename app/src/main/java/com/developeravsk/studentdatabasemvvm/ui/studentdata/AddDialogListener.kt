package com.developeravsk.studentdatabasemvvm.ui.studentdata

import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData

interface AddDialogListener {
    fun onAddButtonClick(item: StudentData)
}