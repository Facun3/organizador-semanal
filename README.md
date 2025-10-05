# 📅 Organizador Semanal

Una aplicación Android moderna y minimalista para organizar tus actividades semanales de manera visual e intuitiva.

## 🎯 Características

- **📱 Interfaz Moderna**: Diseño limpio con Jetpack Compose y Material Design 2
- **🗓️ Vista Semanal**: Organización visual de actividades por días de la semana en layout vertical
- **🎨 Colores Personalizables**: 6 colores predefinidos para categorizar actividades
- **💾 Persistencia de Datos**: Base de datos Room para guardar actividades permanentemente
- **⚡ Arquitectura MVVM**: Código limpio y mantenible con ViewModel y Repository
- **✏️ Edición de Actividades**: Toca cualquier actividad para editarla directamente
- **⏰ Selectores de Tiempo Nativos**: TimePickerDialog nativo de Android para selección intuitiva
- **🗑️ Gestión de Actividades**: Agregar, editar y eliminar actividades fácilmente

## 🛠️ Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación principal
- **Jetpack Compose** - Framework de UI moderno
- **Room Database** - Persistencia de datos local con SQLite
- **Material Design 2** - Sistema de diseño de Google (Material Components)
- **MVVM Architecture** - Patrón de arquitectura con ViewModel
- **Coroutines** - Programación asíncrona con Flow
- **StateFlow** - Gestión de estado reactivo
- **TimePickerDialog** - Selector de tiempo nativo de Android
- **Gradle** - Sistema de construcción y gestión de dependencias

### Dependencias Principales
```kotlin
// UI y Compose
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material:material")
implementation("com.google.android.material:material:1.10.0")

// Room Database
implementation("androidx.room:room-runtime:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")

// ViewModel y Lifecycle
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

// Navigation
implementation("androidx.navigation:navigation-compose:2.7.5")
```

## 📱 Capturas de Pantalla

La aplicación presenta:
- Vista principal con tarjetas de días de la semana en layout vertical
- Formulario intuitivo para agregar actividades con selectores nativos
- Selector visual de días con botones en grid
- Selectores de tiempo nativos (TimePickerDialog)
- Tarjetas de actividades con colores personalizables
- Edición directa al tocar cualquier actividad
- Botones de eliminación para cada actividad

## 🚀 Instalación y Uso

### Requisitos
- Android Studio Arctic Fox o superior
- Android SDK 34
- Dispositivo Android con API 24+ o emulador

### Instalación
1. Clona el repositorio:
```bash
git clone https://github.com/tu-usuario/organizador-semanal.git
```

2. Abre el proyecto en Android Studio

3. Sincroniza las dependencias de Gradle

4. Ejecuta la aplicación:
```bash
./gradlew installDebug
```

### Uso de la Aplicación
1. **Agregar Actividades**: Toca el botón "+" flotante
2. **Seleccionar Día**: Elige el día de la semana del grid de botones
3. **Configurar Horarios**: Toca los campos de hora para abrir selectores nativos
4. **Elegir Color**: Selecciona un color para categorizar
5. **Guardar**: Toca "Agregar" para crear la actividad
6. **Editar**: Toca cualquier actividad para editarla directamente
7. **Eliminar**: Toca el icono de eliminar en cualquier actividad

## 🏗️ Estructura del Proyecto

```
app/src/main/java/com/organizadorsemanal/
├── data/
│   ├── Actividad.kt              # Entidad de datos
│   ├── ActividadDao.kt           # Acceso a datos
│   ├── ActividadRepository.kt    # Repositorio de datos
│   └── AppDatabase.kt            # Base de datos Room
├── ui/
│   └── ActividadViewModel.kt     # ViewModel para UI
├── ui/theme/
│   ├── Color.kt                  # Paleta de colores
│   ├── Theme.kt                  # Tema de la aplicación
│   └── Type.kt                   # Tipografía
└── MainActivity.kt               # Actividad principal
```

## 🎨 Diseño

La aplicación sigue los principios de Material Design 2 con:
- **Colores**: Paleta personalizada con 6 colores predefinidos
- **Tipografía**: Jerarquía clara de textos con Material Design 2
- **Espaciado**: Sistema de espaciado consistente
- **Elevación**: Uso de sombras para profundidad
- **Interactividad**: Feedback visual en todas las interacciones
- **Selectores Nativos**: TimePickerDialog para mejor accesibilidad

## 📊 Funcionalidades

### ✅ Implementadas
- [x] Vista semanal con tarjetas de días en layout vertical
- [x] Agregar actividades con formulario completo
- [x] Selector visual de días de la semana en grid
- [x] Colores personalizables para actividades (6 colores)
- [x] Persistencia de datos con Room Database
- [x] Edición de actividades existentes (toque directo)
- [x] Eliminación de actividades
- [x] Selectores de tiempo nativos (TimePickerDialog)
- [x] Arquitectura MVVM completa
- [x] Migración destructiva para cambios de esquema

### 🔄 Futuras Mejoras
- [ ] Notificaciones programadas
- [ ] Categorías de actividades
- [ ] Exportar/importar datos
- [ ] Modo oscuro automático
- [ ] Widgets de pantalla de inicio
- [ ] Sincronización en la nube
- [ ] Drag and drop para reordenar actividades

## 🤝 Contribuir

Las contribuciones son bienvenidas. Para contribuir:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

Desarrollado con ❤️ para ayudar a organizar mejor tu tiempo semanal.

---

**¿Te gusta el proyecto?** ⭐ Dale una estrella al repositorio para apoyar el desarrollo.