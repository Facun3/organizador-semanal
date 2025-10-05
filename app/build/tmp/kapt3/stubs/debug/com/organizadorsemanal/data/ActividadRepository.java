package com.organizadorsemanal.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fJ\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/organizadorsemanal/data/ActividadRepository;", "", "actividadDao", "Lcom/organizadorsemanal/data/ActividadDao;", "(Lcom/organizadorsemanal/data/ActividadDao;)V", "deleteActividad", "", "actividad", "Lcom/organizadorsemanal/data/Actividad;", "(Lcom/organizadorsemanal/data/Actividad;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteActividadById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActividadesPorDia", "Lkotlinx/coroutines/flow/Flow;", "", "dia", "", "getAllActividades", "insertActividad", "updateActividad", "app_debug"})
public final class ActividadRepository {
    @org.jetbrains.annotations.NotNull
    private final com.organizadorsemanal.data.ActividadDao actividadDao = null;
    
    public ActividadRepository(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.ActividadDao actividadDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.organizadorsemanal.data.Actividad>> getAllActividades() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.organizadorsemanal.data.Actividad>> getActividadesPorDia(@org.jetbrains.annotations.NotNull
    java.lang.String dia) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteActividadById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}