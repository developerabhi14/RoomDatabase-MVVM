package com.developeravsk.studentdatabasemvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.developeravsk.studentdatabasemvvm.R
import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData
import com.developeravsk.studentdatabasemvvm.ui.studentdata.StudentViewModel

class StudentDataAdapter(
    var item: List<StudentData>,
    private val viewmodel: StudentViewModel
) : RecyclerView.Adapter<StudentDataAdapter.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_data, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val curStudentDat = item[position]
        holder.tvName.text = curStudentDat.name
        holder.tvAddress.text = curStudentDat.address
        holder.tvPhone.text = curStudentDat.phone
        holder.delete.setOnClickListener {
            viewmodel.delete(curStudentDat)
        }
    }

    inner class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
        val tvPhone: TextView = view.findViewById(R.id.tvPhone)
        val delete: TextView = view.findViewById(R.id.btndelete)

    }
}