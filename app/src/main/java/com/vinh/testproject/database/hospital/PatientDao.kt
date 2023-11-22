package com.vinh.testproject.database.hospital

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {

    @Query("Select * from Patient")
    fun getAll() : Flow<List<Patient>>

    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    //suspend fun insert(patient: Patient)
}