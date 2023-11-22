package com.vinh.testproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vinh.testproject.database.hospital.Patient
import com.vinh.testproject.database.hospital.PatientDao
import com.vinh.testproject.database.repository.PatientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PatientViewModel( private val patientRepository: PatientRepository): ViewModel() {

    fun getAllPatient(): Flow<List<Patient>> = patientRepository.getAll

//    fun insert(patient: Patient) = viewModelScope.launch {
//        patientRepository.insert(patient)
//    }


    class PatientViewModelFactory(
        private val patientRepository: PatientRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PatientViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PatientViewModel(patientRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}