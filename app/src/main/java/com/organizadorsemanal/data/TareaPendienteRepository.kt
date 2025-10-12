package com.organizadorsemanal.data

class TareaPendienteRepository(private val tareaPendienteDao: TareaPendienteDao) {
    
    fun getAllTareas() = tareaPendienteDao.getAllTareas()
    
    suspend fun getTareaById(id: Long) = tareaPendienteDao.getTareaById(id)
    
    suspend fun insertTarea(tarea: TareaPendiente) = tareaPendienteDao.insertTarea(tarea)
    
    suspend fun updateTarea(tarea: TareaPendiente) = tareaPendienteDao.updateTarea(tarea)
    
    suspend fun deleteTarea(tarea: TareaPendiente) = tareaPendienteDao.deleteTarea(tarea)
    
    suspend fun updatePrioridad(id: Long, prioridad: Int) = tareaPendienteDao.updatePrioridad(id, prioridad)
    
    suspend fun actualizarPrioridades(prioridadActual: Int, nuevaPrioridad: Int) = 
        tareaPendienteDao.actualizarPrioridades(prioridadActual, nuevaPrioridad)
}
