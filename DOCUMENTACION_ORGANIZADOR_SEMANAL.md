# Organizador Semanal - Documentación del Proyecto

## Resumen del Proyecto

**Nombre**: Organizador Semanal  
**Plataforma**: Android (versión más reciente)  
**Lenguaje**: Kotlin  
**Idioma**: Español  
**Estilo**: Minimalista con enfoque en accesibilidad  
**Almacenamiento**: Local (SQLite con Room)  

## Objetivo

Crear una aplicación Android que permita a los usuarios organizar sus actividades semanales de manera visual e intuitiva, con un calendario semanal claro y personalización de colores para diferentes tipos de actividades.

## Funcionalidades Principales

### 1. Calendario Semanal
- Vista de 7 días (Lunes a Domingo)
- Horarios visibles con bloques de tiempo
- Actividades mostradas como bloques de colores
- Diseño limpio y fácil de leer
- Sin navegación entre semanas (schedule fijo)

### 2. Gestión de Actividades Personalizable
- **Tipos de actividades**: Creados completamente por el usuario
- **Sin tipos predefinidos**: Total flexibilidad para el usuario
- **Propiedades de cada actividad**:
  - Nombre personalizable
  - Tipo de actividad (seleccionado de los creados por el usuario)
  - Día de la semana
  - Hora de inicio y fin (duración definida por el usuario)
  - Color personalizable (asociado al tipo de actividad)
  - Repetición indefinida hasta que se elimine/modifique

### 3. Sistema de Notificaciones
- Notificaciones antes de cada actividad
- Recordatorios programables por el usuario
- Configuración de tiempo de anticipación personalizable

### 4. Personalización
- Colores personalizables por tipo de actividad
- Fuentes claras y legibles
- Contraste adecuado para accesibilidad
- Diseño minimalista

## Arquitectura Técnica

### Tecnologías Utilizadas
- **Lenguaje**: Kotlin
- **Base de datos**: Room (SQLite local)
- **UI**: Jetpack Compose
- **Notificaciones**: WorkManager + NotificationCompat
- **Navegación**: Navigation Component
- **Arquitectura**: MVVM (Model-View-ViewModel)

### Estructura de Datos

```kotlin
// Tipo de Actividad (creado por el usuario)
data class TipoActividad(
    val id: Long,
    val nombre: String,
    val color: String,
    val fechaCreacion: LocalDateTime
)

// Actividad
data class Actividad(
    val id: Long,
    val nombre: String,
    val tipoActividadId: Long, // Referencia al tipo creado por el usuario
    val diaSemana: DiaSemana,
    val horaInicio: LocalTime,
    val horaFin: LocalTime,
    val notificacionMinutosAntes: Int
)

// Enum para días de la semana
enum class DiaSemana(val nombre: String, val orden: Int) {
    LUNES("Lunes", 1),
    MARTES("Martes", 2),
    MIERCOLES("Miércoles", 3),
    JUEVES("Jueves", 4),
    VIERNES("Viernes", 5),
    SABADO("Sábado", 6),
    DOMINGO("Domingo", 7)
}
```

## Pantallas de la Aplicación

1. **Pantalla Principal** - Calendario semanal con actividades
2. **Agregar/Editar Actividad** - Formulario de actividad con selector de tipo
3. **Gestión de Tipos** - Crear/editar tipos de actividades
4. **Configuración de Colores** - Personalización de colores por tipo
5. **Configuración de Notificaciones** - Ajustes de recordatorios

## Flujo de Usuario

### Primer Uso
1. Usuario abre la aplicación
2. Crea tipos de actividades personalizados (ej: "Estudio Japonés", "Gym", "Trabajo")
3. Asigna colores a cada tipo de actividad
4. Configura preferencias de notificaciones

### Uso Diario
1. Usuario ve el calendario semanal con sus actividades
2. Para agregar nueva actividad:
   - Toca en horario vacío
   - Selecciona tipo existente O crea nuevo tipo
   - Define nombre, horario y día
   - Configura notificaciones
3. Para editar actividad existente:
   - Toca en la actividad
   - Modifica los campos necesarios
4. Para gestionar tipos:
   - Accede a configuración de tipos
   - Crea, edita o elimina tipos de actividades

## Consideraciones de Diseño

### Estilo Visual
- **Minimalista**: Interfaz limpia y sin elementos innecesarios
- **Colores**: Personalizables por el usuario, con contraste adecuado
- **Tipografía**: Fuentes claras y legibles

### Accesibilidad
- Fuentes de tamaño adecuado (mínimo 14sp)
- Contraste de colores WCAG AA
- Navegación por teclado
- Etiquetas descriptivas para lectores de pantalla
- Colores que no dependan solo del color para transmitir información

## Funcionalidades Excluidas (Por Ahora)

- Navegación entre semanas
- Búsqueda de actividades por texto
- Exportar o compartir calendario
- Sincronización con otros calendarios
- Almacenamiento en la nube
- Soporte multiidioma
- Sincronización con Google Calendar/Outlook

## Requisitos del Sistema

- **Android**: Versión más reciente
- **Idioma**: Solo español
- **Almacenamiento**: Local únicamente
- **Permisos**: Notificaciones

## Estructura del Proyecto

```
app/
├── src/main/java/com/organizadorsemanal/
│   ├── data/
│   │   ├── database/
│   │   │   ├── AppDatabase.kt
│   │   │   ├── entities/
│   │   │   └── dao/
│   │   └── repository/
│   ├── ui/
│   │   ├── calendar/
│   │   ├── activities/
│   │   ├── types/
│   │   └── settings/
│   ├── viewmodel/
│   ├── utils/
│   └── MainActivity.kt
├── src/main/res/
│   ├── values/
│   ├── layout/
│   └── drawable/
└── build.gradle
```

## Notas de Desarrollo

- Priorizar la experiencia de usuario y la accesibilidad
- Mantener el código limpio y bien documentado
- Usar principios SOLID y Clean Architecture
- Implementar testing unitario para lógica de negocio
- Considerar futuras expansiones (navegación entre semanas, sincronización, etc.)

## Ejemplos de Uso

### Creación de Tipos de Actividades
- Usuario crea tipo "Estudio Japonés" con color azul (#4A90E2)
- Usuario crea tipo "Gym" con color verde (#7ED321)
- Usuario crea tipo "Trabajo" con color rojo (#D0021B)

### Agregar Actividades
- Lunes 9:00-10:30: "Estudio Japonés" (tipo: Estudio Japonés, color azul)
- Martes 18:00-19:30: "Gym" (tipo: Gym, color verde)
- Miércoles 14:00-15:00: "Reunión semanal" (tipo: Trabajo, color rojo)

---

**Fecha de creación**: Diciembre 2024  
**Versión**: 1.0  
**Estado**: En desarrollo
