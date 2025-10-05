package com.organizadorsemanal.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/organizadorsemanal/ui/ActividadViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/organizadorsemanal/data/ActividadRepository;", "(Lcom/organizadorsemanal/data/ActividadRepository;)V", "_actividades", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/organizadorsemanal/data/Actividad;", "_actividadesPorDia", "", "", "actividades", "Lkotlinx/coroutines/flow/StateFlow;", "getActividades", "()Lkotlinx/coroutines/flow/StateFlow;", "actividadesPorDia", "getActividadesPorDia", "addActividad", "", "actividad", "deleteActividad", "loadActividades", "updateActividad", "app_debug"})
public final class ActividadViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.organizadorsemanal.data.ActividadRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.organizadorsemanal.data.Actividad>> _actividades = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.organizadorsemanal.data.Actividad>> actividades = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.util.List<com.organizadorsemanal.data.Actividad>>> _actividadesPorDia = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.util.List<com.organizadorsemanal.data.Actividad>>> actividadesPorDia = null;
    
    public ActividadViewModel(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.ActividadRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.organizadorsemanal.data.Actividad>> getActividades() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.util.List<com.organizadorsemanal.data.Actividad>>> getActividadesPorDia() {
        return null;
    }
    
    private final void loadActividades() {
    }
    
    public final void addActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad) {
    }
    
    public final void deleteActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad) {
    }
    
    public final void updateActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad) {
    }
}