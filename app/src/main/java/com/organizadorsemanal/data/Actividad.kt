package com.organizadorsemanal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actividades")
data class Actividad(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val dia: String,
    val horaInicio: String,
    val horaFin: String,
    val color: String
)
