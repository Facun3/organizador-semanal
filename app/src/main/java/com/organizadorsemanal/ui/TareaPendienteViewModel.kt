package com.organizadorsemanal.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.organizadorsemanal.data.TareaPendiente
import com.organizadorsemanal.data.TareaPendienteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TareaPendienteViewModel(
    private val repository: TareaPendienteRepository,
    private val application: Application
) : AndroidViewModel(application) {
    
    private val _tareas = MutableStateFlow<List<TareaPendiente>>(emptyList())
    val tareas: StateFlow<List<TareaPendiente>> = _tareas.asStateFlow()
    
    init {
        loadTareas()
    }
    
    private fun loadTareas() {
        viewModelScope.launch {
            repository.getAllTareas().collect { tareasList ->
                _tareas.value = tareasList
            }
        }
    }
    
    fun addTarea(tarea: TareaPendiente) {
        viewModelScope.launch {
            repository.insertTarea(tarea)
        }
    }
    
    fun deleteTarea(tarea: TareaPendiente) {
        viewModelScope.launch {
            repository.deleteTarea(tarea)
        }
    }
    
    fun updateTarea(tarea: TareaPendiente) {
        viewModelScope.launch {
            repository.updateTarea(tarea)
        }
    }
    
    fun updatePrioridad(tareaId: Long, nuevaPrioridad: Int) {
        viewModelScope.launch {
            repository.updatePrioridad(tareaId, nuevaPrioridad)
        }
    }
    
    fun reordenarTareas(tareasReordenadas: List<TareaPendiente>) {
        viewModelScope.launch {
            tareasReordenadas.forEachIndexed { index, tarea ->
                repository.updatePrioridad(tarea.id, tareasReordenadas.size - index)
            }
        }
    }
}
