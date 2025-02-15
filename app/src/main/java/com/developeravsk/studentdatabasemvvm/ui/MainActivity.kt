package com.developeravsk.studentdatabasemvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developeravsk.studentdatabasemvvm.R
import com.developeravsk.studentdatabasemvvm.data.db.StudentDatabase
import com.developeravsk.studentdatabasemvvm.data.db.entities.StudentData
import com.developeravsk.studentdatabasemvvm.data.repositories.StudentRepository
import com.developeravsk.studentdatabasemvvm.other.StudentDataAdapter
import com.developeravsk.studentdatabasemvvm.ui.studentdata.AddDialogListener
import com.developeravsk.studentdatabasemvvm.ui.studentdata.StudentViewModel
import com.developeravsk.studentdatabasemvvm.ui.studentdata.StudentViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    // added for Kodein DI
    override val kodein by closestKodein()

    //added for Kodein DI
    private val factory: StudentViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // commented because of kodein DI
//        val database = StudentDatabase(this)
//        val repo = StudentRepository(database)
//        val factory = StudentViewModelFactory(repo)
        val viewmodel: StudentViewModel =
            ViewModelProvider(this, factory)[StudentViewModel::class.java]

        val adapter = StudentDataAdapter(listOf(), viewmodel)

        val rv: RecyclerView = findViewById(R.id.rv)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        viewmodel.getAllData().observe(this, Observer {
            adapter.item = it
            adapter.notifyDataSetChanged()
        })

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            AddStudentDataDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClick(item: StudentData) {
                        viewmodel.upsert(item)
                    }

                }).show()
        }

    }
}