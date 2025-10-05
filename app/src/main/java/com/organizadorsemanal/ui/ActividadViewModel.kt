package com.organizadorsemanal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.organizadorsemanal.data.Actividad
import com.organizadorsemanal.data.ActividadRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ActividadViewModel(private val repository: ActividadRepository) : ViewModel() {
    
    private val _actividades = MutableStateFlow<List<Actividad>>(emptyList())
    val actividades: StateFlow<List<Actividad>> = _actividades.asStateFlow()
    
    private val _actividadesPorDia = MutableStateFlow<Map<String, List<Actividad>>>(emptyMap())
    val actividadesPorDia: StateFlow<Map<String, List<Actividad>>> = _actividadesPorDia.asStateFlow()
    
    init {
        loadActividades()
    }
    
    private fun loadActividades() {
        viewModelScope.launch {
            repository.getAllActividades().collect { actividadesList ->
                _actividades.value = actividadesList
                _actividadesPorDia.value = actividadesList.groupBy { it.dia }
            }
        }
    }
    
    fun addActividad(actividad: Actividad) {
        viewModelScope.launch {
            repository.insertActividad(actividad)
        }
    }
    
    fun deleteActividad(actividad: Actividad) {
        viewModelScope.launch {
            repository.deleteActividad(actividad)
        }
    }
    
    fun updateActividad(actividad: Actividad) {
        viewModelScope.launch {
            repository.updateActividad(actividad)
        }
    }
}
