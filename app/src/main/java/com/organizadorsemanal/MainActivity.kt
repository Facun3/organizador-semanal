package com.organizadorsemanal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.organizadorsemanal.data.Actividad
import com.organizadorsemanal.data.ActividadRepository
import com.organizadorsemanal.data.AppDatabase
import com.organizadorsemanal.ui.ActividadViewModel
import com.organizadorsemanal.ui.theme.OrganizadorSemanalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrganizadorSemanalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val database = AppDatabase.getDatabase(this)
                    val repository = ActividadRepository(database.actividadDao())
                    val viewModel: ActividadViewModel = viewModel { 
                        ActividadViewModel(repository) 
                    }
                    
                    OrganizadorSemanalApp(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun OrganizadorSemanalApp(viewModel: ActividadViewModel) {
    val actividadesPorDia by viewModel.actividadesPorDia.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }
    
    val diasSemana = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    val diasCortos = listOf("Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom")
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "Organizador Semanal",
                        style = MaterialTheme.typography.h6
                    ) 
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar actividad"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Calendario semanal
            CalendarioSemanal(
                diasSemana = diasSemana,
                diasCortos = diasCortos,
                actividadesPorDia = actividadesPorDia,
                onDeleteActividad = { actividad ->
                    viewModel.deleteActividad(actividad)
                }
            )
        }
    }
    
    // Diálogo para agregar actividad
    if (showAddDialog) {
        AddActividadDialog(
            diasSemana = diasSemana,
            onDismiss = { showAddDialog = false },
            onAdd = { nuevaActividad ->
                viewModel.addActividad(nuevaActividad)
                showAddDialog = false
            }
        )
    }
}

@Composable
fun CalendarioSemanal(
    diasSemana: List<String>,
    diasCortos: List<String>,
    actividadesPorDia: Map<String, List<Actividad>>,
    onDeleteActividad: (Actividad) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(diasSemana) { dia ->
            DiaSemanaCard(
                dia = dia,
                actividades = actividadesPorDia[dia] ?: emptyList(),
                onDeleteActividad = onDeleteActividad
            )
        }
    }
}

@Composable
fun DiaSemanaCard(
    dia: String,
    actividades: List<Actividad>,
    onDeleteActividad: (Actividad) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Encabezado del día
            Text(
                text = dia,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            if (actividades.isEmpty()) {
                // Día vacío
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sin actividades programadas",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                // Lista de actividades
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    actividades.forEach { actividad ->
                        ActividadCard(
                            actividad = actividad,
                            onDelete = { onDeleteActividad(actividad) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActividadCard(
    actividad: Actividad,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
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
                    .size(16.dp)
                    .background(
                        Color(android.graphics.Color.parseColor(actividad.color)),
                        CircleShape
                    )
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = actividad.nombre,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${actividad.horaInicio} - ${actividad.horaFin}",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
                )
            }
            
            // Botón eliminar
            IconButton(
                onClick = onDelete,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    modifier = Modifier.size(18.dp),
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
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre de la actividad") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                // Selector de día con botones
                Text(
                    text = "Día:",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    items(diasSemana) { diaOption ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp)
                                .clickable { dia = diaOption },
                            backgroundColor = if (dia == diaOption) 
                                MaterialTheme.colors.primary.copy(alpha = 0.1f) 
                            else 
                                MaterialTheme.colors.surface,
                            elevation = if (dia == diaOption) 4.dp else 1.dp
                        ) {
                            Text(
                                text = diaOption,
                                modifier = Modifier.padding(16.dp),
                                color = if (dia == diaOption) 
                                    MaterialTheme.colors.primary 
                                else 
                                    MaterialTheme.colors.onSurface
                            )
                        }
                    }
                }
                
                // Horarios
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = horaInicio,
                        onValueChange = { horaInicio = it },
                        label = { Text("Inicio") },
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = horaFin,
                        onValueChange = { horaFin = it },
                        label = { Text("Fin") },
                        modifier = Modifier.weight(1f)
                    )
                }
                
                // Selector de color
                Text("Color:", style = MaterialTheme.typography.caption)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    colores.forEach { colorOption ->
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(
                                    Color(android.graphics.Color.parseColor(colorOption)),
                                    CircleShape
                                )
                                .clickable { color = colorOption }
                                .then(
                                    if (color == colorOption) {
                                        Modifier.border(
                                            2.dp,
                                            MaterialTheme.colors.primary,
                                            CircleShape
                                        )
                                    } else {
                                        Modifier
                                    }
                                )
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
                },
                enabled = nombre.isNotBlank()
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