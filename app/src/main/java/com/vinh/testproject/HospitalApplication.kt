package com.vinh.testproject

import android.app.Application
import com.vinh.testproject.database.AppDatabase
import com.vinh.testproject.database.repository.PatientRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class HospitalApplication: Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { PatientRepository(database.patientDao()) }
}