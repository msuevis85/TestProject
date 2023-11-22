package com.vinh.testproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.room.Room
import com.vinh.testproject.database.hospital.PatientDao
import com.vinh.testproject.database.AppDatabase
import com.vinh.testproject.database.repository.PatientRepository
import com.vinh.testproject.viewModel.PatientViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var patientViewModel: PatientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       var textTitle = findViewById<TextView>(R.id.textTitle)

        val patientModelFactory = PatientViewModel.PatientViewModelFactory((application as HospitalApplication).repository)
        patientViewModel = ViewModelProvider(this, patientModelFactory).get(PatientViewModel::class.java)


        lifecycle.coroutineScope.launch {
            patientViewModel.getAllPatient().collect() {
               // Toast.makeText( this,""+ it,Toast.LENGTH_LONG).show()
                textTitle.text = it.toString()
            }
        }





    }
}