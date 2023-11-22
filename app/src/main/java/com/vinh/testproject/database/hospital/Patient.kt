package com.vinh.testproject.database.hospital

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 */
@Entity(tableName = "Patient")
data class Patient(
    @PrimaryKey val patientId: Int,
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "department") val department: String,
    @ColumnInfo(name = "nurseId") val nurseId: Int,
    @ColumnInfo(name = "room") val room: Int


)