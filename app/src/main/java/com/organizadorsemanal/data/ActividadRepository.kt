package com.organizadorsemanal.data

import kotlinx.coroutines.flow.Flow

class ActividadRepository(private val actividadDao: ActividadDao) {
    
    fun getAllActividades(): Flow<List<Actividad>> = actividadDao.getAllActividades()
    
    fun getActividadesPorDia(dia: String): Flow<List<Actividad>> = 
        actividadDao.getActividadesPorDia(dia)
    
    suspend fun insertActividad(actividad: Actividad): Long = 
        actividadDao.insertActividad(actividad)
    
    suspend fun updateActividad(actividad: Actividad) = 
        actividadDao.updateActividad(actividad)
    
    suspend fun deleteActividad(actividad: Actividad) = 
        actividadDao.deleteActividad(actividad)
    
    suspend fun deleteActividadById(id: Long) = 
        actividadDao.deleteActividadById(id)
}
