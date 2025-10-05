# 📅 Organizador Semanal

Una aplicación Android moderna y minimalista para organizar tus actividades semanales de manera visual e intuitiva.

## 🎯 Características

- **📱 Interfaz Moderna**: Diseño limpio con Jetpack Compose y Material Design
- **🗓️ Vista Semanal**: Organización visual de actividades por días de la semana
- **🎨 Colores Personalizables**: 6 colores predefinidos para categorizar actividades
- **💾 Persistencia de Datos**: Base de datos Room para guardar actividades permanentemente
- **⚡ Arquitectura MVVM**: Código limpio y mantenible con ViewModel y Repository
- **🗑️ Gestión de Actividades**: Agregar y eliminar actividades fácilmente

## 🛠️ Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación
- **Jetpack Compose** - Framework de UI moderno
- **Room Database** - Persistencia de datos local
- **Material Design** - Sistema de diseño de Google
- **MVVM Architecture** - Patrón de arquitectura
- **Coroutines** - Programación asíncrona
- **StateFlow** - Gestión de estado reactivo

## 📱 Capturas de Pantalla

La aplicación presenta:
- Vista principal con tarjetas de días de la semana
- Formulario intuitivo para agregar actividades
- Selector visual de días con botones
- Tarjetas de actividades con colores personalizables
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
2. **Seleccionar Día**: Elige el día de la semana de la lista
3. **Configurar Horarios**: Establece hora de inicio y fin
4. **Elegir Color**: Selecciona un color para categorizar
5. **Guardar**: Toca "Agregar" para crear la actividad
6. **Eliminar**: Toca el icono de eliminar en cualquier actividad

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

La aplicación sigue los principios de Material Design con:
- **Colores**: Paleta personalizada con modo claro y oscuro
- **Tipografía**: Jerarquía clara de textos
- **Espaciado**: Sistema de espaciado consistente
- **Elevación**: Uso de sombras para profundidad
- **Interactividad**: Feedback visual en todas las interacciones

## 📊 Funcionalidades

### ✅ Implementadas
- [x] Vista semanal con tarjetas de días
- [x] Agregar actividades con formulario completo
- [x] Selector visual de días de la semana
- [x] Colores personalizables para actividades
- [x] Persistencia de datos con Room
- [x] Eliminación de actividades
- [x] Arquitectura MVVM completa

### 🔄 Futuras Mejoras
- [ ] Edición de actividades existentes
- [ ] Notificaciones programadas
- [ ] Categorías de actividades
- [ ] Exportar/importar datos
- [ ] Modo oscuro automático
- [ ] Widgets de pantalla de inicio
- [ ] Sincronización en la nube

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