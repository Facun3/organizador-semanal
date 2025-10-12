package com.organizadorsemanal.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tareas_pendientes")
data class TareaPendiente(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val titulo: String,
    val descripcion: String = "",
    val color: String = "#4A90E2",
    val fechaCreacion: Long = System.currentTimeMillis(),
    val prioridad: Int = 0 // 0 = normal, 1 = alta, 2 = urgente
)
