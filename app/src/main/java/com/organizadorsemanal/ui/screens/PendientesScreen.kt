package com.organizadorsemanal.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.scale
import androidx.lifecycle.viewmodel.compose.viewModel
import android.app.Application
import com.organizadorsemanal.data.TareaPendiente
import com.organizadorsemanal.data.TareaPendienteRepository
import com.organizadorsemanal.data.AppDatabase
import com.organizadorsemanal.ui.TareaPendienteViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun PendientesScreen() {
    val context = LocalContext.current
    val database = AppDatabase.getDatabase(context)
    val repository = TareaPendienteRepository(database.tareaPendienteDao())
    val viewModel: TareaPendienteViewModel = viewModel {
        TareaPendienteViewModel(repository, context.applicationContext as Application)
    }
    
    val tareas by viewModel.tareas.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var tareaToEdit by remember { mutableStateOf<TareaPendiente?>(null) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tareas Pendientes") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar tarea")
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
            if (tareas.isEmpty()) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = 2.dp,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No hay tareas pendientes\nToca el + para agregar una nueva",
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }
            } else {
                items(tareas.withIndex().toList()) { (index, tarea) ->
                    TareaCard(
                        tarea = tarea,
                        index = index,
                        onClick = {
                            tareaToEdit = tarea
                            showEditDialog = true
                        },
                        onDelete = { viewModel.deleteTarea(tarea) }
                    )
                }
            }
        }
    }
    
    if (showAddDialog) {
        AddTareaDialog(
            onDismiss = { showAddDialog = false },
            onAdd = { tarea ->
                viewModel.addTarea(tarea)
                showAddDialog = false
            }
        )
    }
    
    if (showEditDialog && tareaToEdit != null) {
        EditTareaDialog(
            tarea = tareaToEdit!!,
            onDismiss = { 
                showEditDialog = false
                tareaToEdit = null
            },
            onUpdate = { tarea ->
                viewModel.updateTarea(tarea)
                showEditDialog = false
                tareaToEdit = null
            }
        )
    }
}

@Composable
fun TareaCard(
    tarea: TareaPendiente,
    index: Int,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    val isTopThree = index < 3
    val infiniteTransition = rememberInfiniteTransition()
    
    // Animación de pulso para las primeras 3 tareas
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isTopThree) 1.05f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        )
    )
    
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = if (isTopThree) 0.8f else 0.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        )
    )
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .animateContentSize(),
        elevation = if (isTopThree) 8.dp else 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box {
            // Efecto de destaque para las primeras 3 tareas
            if (isTopThree) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color(android.graphics.Color.parseColor(tarea.color))
                                .copy(alpha = pulseAlpha)
                        )
                        .scale(pulseScale)
                )
            }
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Indicador de prioridad
                if (isTopThree) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Prioridad alta",
                        tint = MaterialTheme.colors.error,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                
                // Indicador de color
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(Color(android.graphics.Color.parseColor(tarea.color)))
                )
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = tarea.titulo,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = if (isTopThree) FontWeight.Bold else FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    
                    if (tarea.descripcion.isNotBlank()) {
                        Text(
                            text = tarea.descripcion,
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    
                    Text(
                        text = "Creada: ${formatDate(tarea.fechaCreacion)}",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
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
}

@Composable
fun AddTareaDialog(
    onDismiss: () -> Unit,
    onAdd: (TareaPendiente) -> Unit
) {
    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("#4A90E2") }
    var prioridad by remember { mutableStateOf(0) }
    
    val colores = listOf("#4A90E2", "#7ED321", "#D0021B", "#9013FE", "#50E3C2", "#F5A623")
    val prioridades = listOf("Normal" to 0, "Alta" to 1, "Urgente" to 2)
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Nueva Tarea") },
        text = {
            Column {
                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    label = { Text("Descripción (opcional)") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selector de prioridad
                Text(
                    text = "Prioridad",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    prioridades.forEach { (nombre, valor) ->
                        Button(
                            onClick = { prioridad = valor },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = if (prioridad == valor) 
                                    MaterialTheme.colors.primary 
                                else 
                                    MaterialTheme.colors.surface
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = nombre,
                                color = if (prioridad == valor) 
                                    MaterialTheme.colors.onPrimary 
                                else 
                                    MaterialTheme.colors.onSurface,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                
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
                    if (titulo.isNotBlank()) {
                        onAdd(
                            TareaPendiente(
                                titulo = titulo,
                                descripcion = descripcion,
                                color = color,
                                prioridad = prioridad
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
fun EditTareaDialog(
    tarea: TareaPendiente,
    onDismiss: () -> Unit,
    onUpdate: (TareaPendiente) -> Unit
) {
    var titulo by remember { mutableStateOf(tarea.titulo) }
    var descripcion by remember { mutableStateOf(tarea.descripcion) }
    var color by remember { mutableStateOf(tarea.color) }
    var prioridad by remember { mutableStateOf(tarea.prioridad) }
    
    val colores = listOf("#4A90E2", "#7ED321", "#D0021B", "#9013FE", "#50E3C2", "#F5A623")
    val prioridades = listOf("Normal" to 0, "Alta" to 1, "Urgente" to 2)
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Editar Tarea") },
        text = {
            Column {
                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    label = { Text("Descripción (opcional)") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Selector de prioridad
                Text(
                    text = "Prioridad",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    prioridades.forEach { (nombre, valor) ->
                        Button(
                            onClick = { prioridad = valor },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = if (prioridad == valor) 
                                    MaterialTheme.colors.primary 
                                else 
                                    MaterialTheme.colors.surface
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = nombre,
                                color = if (prioridad == valor) 
                                    MaterialTheme.colors.onPrimary 
                                else 
                                    MaterialTheme.colors.onSurface,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
                
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
                    if (titulo.isNotBlank()) {
                        onUpdate(
                            tarea.copy(
                                titulo = titulo,
                                descripcion = descripcion,
                                color = color,
                                prioridad = prioridad
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


private fun formatDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return sdf.format(Date(timestamp))
}
