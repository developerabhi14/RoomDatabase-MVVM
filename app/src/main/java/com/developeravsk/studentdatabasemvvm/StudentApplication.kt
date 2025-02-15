package com.developeravsk.studentdatabasemvvm

import android.app.Application
import com.developeravsk.studentdatabasemvvm.data.db.StudentDatabase
import com.developeravsk.studentdatabasemvvm.data.repositories.StudentRepository
import com.developeravsk.studentdatabasemvvm.ui.studentdata.StudentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class StudentApplication: Application(), KodeinAware {
    override  val kodein: Kodein=Kodein.lazy {
        import(androidXModule(this@StudentApplication))
        bind() from singleton {
            StudentDatabase(instance())
        }
        bind() from  singleton {
            StudentRepository(instance())
        }
        bind() from provider {
            StudentViewModelFactory(instance())
        }
    }

}