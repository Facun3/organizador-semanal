package com.organizadorsemanal;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a8\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\fH\u0007\u001aR\u0010\r\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\fH\u0007\u001a2\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\fH\u0007\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a8\u0006\u0018"}, d2 = {"ActividadCard", "", "actividad", "Lcom/organizadorsemanal/data/Actividad;", "onDelete", "Lkotlin/Function0;", "AddActividadDialog", "diasSemana", "", "", "onDismiss", "onAdd", "Lkotlin/Function1;", "CalendarioSemanal", "diasCortos", "actividadesPorDia", "", "onDeleteActividad", "DiaSemanaCard", "dia", "actividades", "OrganizadorSemanalApp", "viewModel", "Lcom/organizadorsemanal/ui/ActividadViewModel;", "app_debug"})
public final class MainActivityKt {
    
    @androidx.compose.runtime.Composable
    public static final void OrganizadorSemanalApp(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.ui.ActividadViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CalendarioSemanal(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> diasSemana, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> diasCortos, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.util.List<com.organizadorsemanal.data.Actividad>> actividadesPorDia, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.organizadorsemanal.data.Actividad, kotlin.Unit> onDeleteActividad) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void DiaSemanaCard(@org.jetbrains.annotations.NotNull
    java.lang.String dia, @org.jetbrains.annotations.NotNull
    java.util.List<com.organizadorsemanal.data.Actividad> actividades, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.organizadorsemanal.data.Actividad, kotlin.Unit> onDeleteActividad) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ActividadCard(@org.jetbrains.annotations.NotNull
    com.organizadorsemanal.data.Actividad actividad, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void AddActividadDialog(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> diasSemana, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.organizadorsemanal.data.Actividad, kotlin.Unit> onAdd) {
    }
}