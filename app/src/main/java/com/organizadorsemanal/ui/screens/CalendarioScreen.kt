package com.organizadorsemanal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import android.app.Application
import android.app.TimePickerDialog
import com.organizadorsemanal.data.Actividad
import com.organizadorsemanal.data.ActividadRepository
import com.organizadorsemanal.data.AppDatabase
import com.organizadorsemanal.ui.ActividadViewModel

@Composable
fun CalendarioScreen(
    onNavigateToPendientes: () -> Unit
) {
    val context = LocalContext.current
    val database = AppDatabase.getDatabase(context)
    val repository = ActividadRepository(database.actividadDao())
    val viewModel: ActividadViewModel = viewModel {
        ActividadViewModel(repository, context.applicationContext as Application)
    }
    
    val actividadesPorDia by viewModel.actividadesPorDia.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var actividadToEdit by remember { mutableStateOf<Actividad?>(null) }
    
    val diasSemana = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    val diasCortos = listOf("Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom")
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Organizador Semanal") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar actividad")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(diasSemana) { dia ->
                DiaSemanaCard(
                    dia = dia,
                    actividades = actividadesPorDia[dia] ?: emptyList(),
                    onActividadClick = { actividad ->
                        actividadToEdit = actividad
                        showEditDialog = true
                    },
                    onDeleteActividad = { actividad ->
                        viewModel.deleteActividad(actividad)
                    }
                )
            }
        }
    }
    
    if (showAddDialog) {
        AddActividadDialog(
            diasSemana = diasSemana,
            onDismiss = { showAddDialog = false },
            onAdd = { actividad ->
                viewModel.addActividad(actividad)
                showAddDialog = false
            }
        )
    }
    
    if (showEditDialog && actividadToEdit != null) {
        EditActividadDialog(
            actividad = actividadToEdit!!,
            diasSemana = diasSemana,
            onDismiss = { 
                showEditDialog = false
                actividadToEdit = null
            },
            onUpdate = { actividad ->
                viewModel.updateActividad(actividad)
                showEditDialog = false
                actividadToEdit = null
            }
        )
    }
}

@Composable
fun DiaSemanaCard(
    dia: String,
    actividades: List<Actividad>,
    onActividadClick: (Actividad) -> Unit,
    onDeleteActividad: (Actividad) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = dia,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            if (actividades.isEmpty()) {
                Text(
                    text = "Sin actividades",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            } else {
                actividades.forEach { actividad ->
                    ActividadCard(
                        actividad = actividad,
                        onClick = { onActividadClick(actividad) },
                        onDelete = { onDeleteActividad(actividad) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun ActividadCard(
    actividad: Actividad,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = 2.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Indicador de color
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(Color(android.graphics.Color.parseColor(actividad.color)))
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = actividad.nombre,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "${actividad.horaInicio} - ${actividad.horaFin}",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
                )
            }
            
            IconButton(
                onClick = onDelete
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = MaterialTheme.colors.error
                )
            }
        }
    }
}

@Composable
fun AddActividadDialog(
    diasSemana: List<String>,
    onDismiss: () -> Unit,
    onAdd: (Actividad) -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("Lunes") }
    var horaInicio by remember { mutableStateOf("09:00") }
    var horaFin by remember { mutableStateOf("10:00") }
    var color by remember { mutableStateOf("#4A90E2") }
    var expandedDia by remember { mutableStateOf(false) }
    
    val colores = listOf("#4A90E2", "#7ED321", "#D0021B", "#9013FE", "#50E3C2", "#F5A623")
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Nueva Actividad") },
        text = {
            Column {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selector de día
                Text(
                    text = "Día de la semana",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Column {
                    Row {
                        diasSemana.take(4).forEach { diaOption ->
                            DiaButton(
                                dia = diaOption,
                                isSelected = dia == diaOption,
                                onClick = { dia = diaOption },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    Row {
                        diasSemana.drop(4).forEach { diaOption ->
                            DiaButton(
                                dia = diaOption,
                                isSelected = dia == diaOption,
                                onClick = { dia = diaOption },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selectores de tiempo
                TimeSelector(
                    label = "Hora de Inicio",
                    selectedTime = horaInicio,
                    onTimeSelected = { horaInicio = it }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                TimeSelector(
                    label = "Hora de Fin",
                    selectedTime = horaFin,
                    onTimeSelected = { horaFin = it }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selector de color
                Text(
                    text = "Color",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    colores.forEach { colorOption ->
                        ColorButton(
                            color = colorOption,
                            isSelected = color == colorOption,
                            onClick = { color = colorOption }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (nombre.isNotBlank()) {
                        onAdd(
                            Actividad(
                                nombre = nombre,
                                dia = dia,
                                horaInicio = horaInicio,
                                horaFin = horaFin,
                                color = color
                            )
                        )
                    }
                }
            ) {
                Text("Agregar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun EditActividadDialog(
    actividad: Actividad,
    diasSemana: List<String>,
    onDismiss: () -> Unit,
    onUpdate: (Actividad) -> Unit
) {
    var nombre by remember { mutableStateOf(actividad.nombre) }
    var dia by remember { mutableStateOf(actividad.dia) }
    var horaInicio by remember { mutableStateOf(actividad.horaInicio) }
    var horaFin by remember { mutableStateOf(actividad.horaFin) }
    var color by remember { mutableStateOf(actividad.color) }
    
    val colores = listOf("#4A90E2", "#7ED321", "#D0021B", "#9013FE", "#50E3C2", "#F5A623")
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Editar Actividad") },
        text = {
            Column {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selector de día
                Text(
                    text = "Día de la semana",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Column {
                    Row {
                        diasSemana.take(4).forEach { diaOption ->
                            DiaButton(
                                dia = diaOption,
                                isSelected = dia == diaOption,
                                onClick = { dia = diaOption },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    Row {
                        diasSemana.drop(4).forEach { diaOption ->
                            DiaButton(
                                dia = diaOption,
                                isSelected = dia == diaOption,
                                onClick = { dia = diaOption },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selectores de tiempo
                TimeSelector(
                    label = "Hora de Inicio",
                    selectedTime = horaInicio,
                    onTimeSelected = { horaInicio = it }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                TimeSelector(
                    label = "Hora de Fin",
                    selectedTime = horaFin,
                    onTimeSelected = { horaFin = it }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selector de color
                Text(
                    text = "Color",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    colores.forEach { colorOption ->
                        ColorButton(
                            color = colorOption,
                            isSelected = color == colorOption,
                            onClick = { color = colorOption }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (nombre.isNotBlank()) {
                        onUpdate(
                            actividad.copy(
                                nombre = nombre,
                                dia = dia,
                                horaInicio = horaInicio,
                                horaFin = horaFin,
                                color = color
                            )
                        )
                    }
                }
            ) {
                Text("Actualizar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun DiaButton(
    dia: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(2.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) 
                MaterialTheme.colors.primary 
            else 
                MaterialTheme.colors.surface
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = if (isSelected) 4.dp else 1.dp
        )
    ) {
        Text(
            text = dia,
            color = if (isSelected) 
                MaterialTheme.colors.onPrimary 
            else 
                MaterialTheme.colors.onSurface,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ColorButton(
    color: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(40.dp)
            .clickable { onClick() },
        shape = CircleShape,
        elevation = if (isSelected) 4.dp else 1.dp,
        border = if (isSelected) 
            androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colors.primary)
        else null
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(android.graphics.Color.parseColor(color)))
        )
    }
}

@Composable
fun TimeSelector(
    label: String,
    selectedTime: String,
    onTimeSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val (hora, minuto) = selectedTime.split(":").let { 
        it[0].toInt() to it[1].toInt() 
    }
    
    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        // Botón que abre el TimePickerDialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val timePickerDialog = TimePickerDialog(
                        context,
                        { _, hourOfDay, minute ->
                            val formattedTime = String.format("%02d:%02d", hourOfDay, minute)
                            onTimeSelected(formattedTime)
                        },
                        hora,
                        minuto,
                        true // 24-hour format
                    )
                    timePickerDialog.show()
                },
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 2.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = selectedTime,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Medium
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Seleccionar hora",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
