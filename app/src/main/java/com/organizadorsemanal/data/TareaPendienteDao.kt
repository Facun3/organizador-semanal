package com.organizadorsemanal.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaPendienteDao {
    
    @Query("SELECT * FROM tareas_pendientes ORDER BY prioridad DESC, fechaCreacion ASC")
    fun getAllTareas(): Flow<List<TareaPendiente>>
    
    @Query("SELECT * FROM tareas_pendientes WHERE id = :id")
    suspend fun getTareaById(id: Long): TareaPendiente?
    
    @Insert
    suspend fun insertTarea(tarea: TareaPendiente): Long
    
    @Update
    suspend fun updateTarea(tarea: TareaPendiente)
    
    @Delete
    suspend fun deleteTarea(tarea: TareaPendiente)
    
    @Query("UPDATE tareas_pendientes SET prioridad = :prioridad WHERE id = :id")
    suspend fun updatePrioridad(id: Long, prioridad: Int)
    
    @Query("UPDATE tareas_pendientes SET prioridad = :nuevaPrioridad WHERE prioridad = :prioridadActual")
    suspend fun actualizarPrioridades(prioridadActual: Int, nuevaPrioridad: Int)
}
