# Organizador Semanal

Una aplicación Android minimalista para organizar actividades semanales con notificaciones personalizables.

## 🎯 Características

- **Calendario Semanal**: Vista de 7 días (Lunes a Domingo) con horarios visibles
- **Tipos Personalizables**: Crea tus propios tipos de actividades con colores únicos
- **Notificaciones**: Recordatorios configurables antes de cada actividad
- **Diseño Minimalista**: Interfaz limpia y accesible
- **Almacenamiento Local**: Datos guardados localmente con Room (SQLite)

## 🏗️ Arquitectura Técnica

- **Lenguaje**: Kotlin
- **UI**: Jetpack Compose
- **Base de datos**: Room (SQLite local)
- **Arquitectura**: MVVM con Hilt para inyección de dependencias
- **Notificaciones**: WorkManager + NotificationCompat
- **Navegación**: Navigation Component

## 📱 Pantallas

1. **Calendario Semanal** - Vista principal con todas las actividades
2. **Agregar/Editar Actividad** - Formulario para gestionar actividades
3. **Gestión de Tipos** - Crear y personalizar tipos de actividades
4. **Configuración** - Ajustes de la aplicación

## 🚀 Cómo usar

### Primer uso
1. Abre la aplicación
2. Crea tipos de actividades (ej: "Estudio Japonés", "Gym", "Trabajo")
3. Asigna colores a cada tipo
4. Configura tus preferencias de notificaciones

### Uso diario
1. Ve el calendario semanal con tus actividades
2. Toca en un horario vacío para agregar una nueva actividad
3. Toca en una actividad existente para editarla
4. Gestiona tipos desde el menú de configuración

## 🛠️ Instalación y Desarrollo

### Requisitos
- Android Studio Arctic Fox o superior
- Android SDK 24+
- Kotlin 1.9.10+

### Configuración
1. Clona el repositorio
2. Abre el proyecto en Android Studio
3. Sincroniza las dependencias de Gradle
4. Ejecuta la aplicación

### Estructura del Proyecto
```
app/
├── src/main/java/com/organizadorsemanal/
│   ├── data/
│   │   ├── database/          # Room database y convertidores
│   │   ├── dao/              # Data Access Objects
│   │   ├── model/            # Entidades de datos
│   │   └── repository/       # Repositorios
│   ├── di/                   # Módulos de Hilt
│   ├── notification/         # Sistema de notificaciones
│   ├── ui/
│   │   ├── components/       # Componentes reutilizables
│   │   ├── screens/          # Pantallas de la aplicación
│   │   ├── theme/            # Temas y colores
│   │   └── viewmodel/        # ViewModels
│   └── MainActivity.kt
```

## 📋 Funcionalidades Implementadas

- ✅ Estructura básica del proyecto Android
- ✅ Configuración de dependencias (Room, Compose, Hilt, WorkManager)
- ✅ Entidades de datos (TipoActividad, Actividad, DiaSemana)
- ✅ Base de datos Room con DAOs
- ✅ Repositorios y ViewModels con MVVM
- ✅ Pantalla principal del calendario semanal
- ✅ Pantallas de gestión de actividades y tipos
- ✅ Sistema de notificaciones con WorkManager

## 🔮 Funcionalidades Futuras

- Navegación entre semanas
- Búsqueda de actividades
- Exportar/importar calendario
- Sincronización con Google Calendar
- Soporte multiidioma
- Temas personalizables

## 📄 Licencia

Este proyecto es de uso personal y educativo.

## 👨‍💻 Autor

Desarrollado siguiendo las especificaciones del documento de requerimientos.
