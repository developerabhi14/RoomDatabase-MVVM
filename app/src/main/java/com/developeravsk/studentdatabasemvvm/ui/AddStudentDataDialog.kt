package com.developeravsk.studentdatabasemvvm.ui

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.developeravsk.studentdatabasemvvm.R
import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData
import com.developeravsk.studentdatabasemvvm.ui.studentdata.AddDialogListener

class AddStudentDataDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_student_data)
        val btnSave: Button? = findViewById(R.id.btnSave)
        val btnCancel: Button? = findViewById(R.id.btnCancel)
        val name: EditText?= findViewById(R.id.etName)
        val address: EditText?= findViewById(R.id.etAddress)
        val phone: EditText?= findViewById(R.id.etphone)

        btnSave!!.setOnClickListener{
            val names=name!!.text.toString()
            val addresses=address!!.text.toString()
            val phones=phone!!.text.toString()

            if(names.isEmpty() || addresses.isEmpty() || phones.isEmpty()){
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item=StudentData(names, addresses, phones)
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }
        btnCancel!!.setOnClickListener{
            cancel()
        }
    }
}