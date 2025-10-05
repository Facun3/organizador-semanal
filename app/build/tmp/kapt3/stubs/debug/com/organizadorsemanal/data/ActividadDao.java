package com.organizadorsemanal.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/organizadorsemanal/data/ActividadDao;", "", "deleteActividad", "", "actividad", "Lcom/organizadorsemanal/data/Actividad;", "(Lcom/organizadorsemanal/data/Actividad;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteActividadById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActividadesPorDia", "Lkotlinx/coroutines/flow/Flow;", "", "dia", "", "getAllActividades", "insertActividad", "updateActividad", "app_debug"})
@androidx.room.Dao
public abstract interface ActividadDao {
    
    @androidx.room.Query(value = "SELECT * FROM actividades ORDER BY dia, horaInicio")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.organizadorsemanal.data.Actividad>> getAllActividades();
    
    @androidx.room.Query(value = "SELECT * FROM actividades WHERE dia = :dia ORDER BY horaInicio")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.organizadorsemanal.data.Actividad>> getActividadesPorDia(@org.jetbrains.annotations.NotNull
    java.lang.String dia);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteActividad(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM actividades WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteActividadById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}