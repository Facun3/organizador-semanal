package com.organizadorsemanal.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ActividadDao {
    
    @Query("SELECT * FROM actividades ORDER BY dia, horaInicio")
    fun getAllActividades(): Flow<List<Actividad>>
    
    @Query("SELECT * FROM actividades WHERE dia = :dia ORDER BY horaInicio")
    fun getActividadesPorDia(dia: String): Flow<List<Actividad>>
    
    @Insert
    suspend fun insertActividad(actividad: Actividad): Long
    
    @Update
    suspend fun updateActividad(actividad: Actividad)
    
    @Delete
    suspend fun deleteActividad(actividad: Actividad)
    
    @Query("DELETE FROM actividades WHERE id = :id")
    suspend fun deleteActividadById(id: Long)
}
