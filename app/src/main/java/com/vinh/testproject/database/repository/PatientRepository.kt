package com.vinh.testproject.database.repository

import androidx.annotation.WorkerThread
import com.vinh.testproject.database.hospital.Patient
import com.vinh.testproject.database.hospital.PatientDao
import kotlinx.coroutines.flow.Flow

class PatientRepository(private val patientDao: PatientDao) {

    val getAll : Flow<List<Patient>> = patientDao.getAll()

  /*  @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(patient: Patient) {
        patientDao.insert(patient)
    } */
}