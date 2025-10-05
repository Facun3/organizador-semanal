package com.organizadorsemanal.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ActividadDao_Impl implements ActividadDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Actividad> __insertionAdapterOfActividad;

  private final EntityDeletionOrUpdateAdapter<Actividad> __deletionAdapterOfActividad;

  private final EntityDeletionOrUpdateAdapter<Actividad> __updateAdapterOfActividad;

  private final SharedSQLiteStatement __preparedStmtOfDeleteActividadById;

  public ActividadDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfActividad = new EntityInsertionAdapter<Actividad>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `actividades` (`id`,`nombre`,`dia`,`horaInicio`,`horaFin`,`color`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Actividad entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getDia() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDia());
        }
        if (entity.getHoraInicio() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getHoraInicio());
        }
        if (entity.getHoraFin() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getHoraFin());
        }
        if (entity.getColor() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getColor());
        }
      }
    };
    this.__deletionAdapterOfActividad = new EntityDeletionOrUpdateAdapter<Actividad>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `actividades` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Actividad entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfActividad = new EntityDeletionOrUpdateAdapter<Actividad>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `actividades` SET `id` = ?,`nombre` = ?,`dia` = ?,`horaInicio` = ?,`horaFin` = ?,`color` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Actividad entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getDia() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDia());
        }
        if (entity.getHoraInicio() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getHoraInicio());
        }
        if (entity.getHoraFin() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getHoraFin());
        }
        if (entity.getColor() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getColor());
        }
        statement.bindLong(7, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteActividadById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM actividades WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertActividad(final Actividad actividad,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfActividad.insertAndReturnId(actividad);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteActividad(final Actividad actividad,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfActividad.handle(actividad);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateActividad(final Actividad actividad,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfActividad.handle(actividad);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteActividadById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteActividadById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteActividadById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Actividad>> getAllActividades() {
    final String _sql = "SELECT * FROM actividades ORDER BY dia, horaInicio";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"actividades"}, new Callable<List<Actividad>>() {
      @Override
      @NonNull
      public List<Actividad> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfDia = CursorUtil.getColumnIndexOrThrow(_cursor, "dia");
          final int _cursorIndexOfHoraInicio = CursorUtil.getColumnIndexOrThrow(_cursor, "horaInicio");
          final int _cursorIndexOfHoraFin = CursorUtil.getColumnIndexOrThrow(_cursor, "horaFin");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final List<Actividad> _result = new ArrayList<Actividad>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Actividad _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpDia;
            if (_cursor.isNull(_cursorIndexOfDia)) {
              _tmpDia = null;
            } else {
              _tmpDia = _cursor.getString(_cursorIndexOfDia);
            }
            final String _tmpHoraInicio;
            if (_cursor.isNull(_cursorIndexOfHoraInicio)) {
              _tmpHoraInicio = null;
            } else {
              _tmpHoraInicio = _cursor.getString(_cursorIndexOfHoraInicio);
            }
            final String _tmpHoraFin;
            if (_cursor.isNull(_cursorIndexOfHoraFin)) {
              _tmpHoraFin = null;
            } else {
              _tmpHoraFin = _cursor.getString(_cursorIndexOfHoraFin);
            }
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            _item = new Actividad(_tmpId,_tmpNombre,_tmpDia,_tmpHoraInicio,_tmpHoraFin,_tmpColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Actividad>> getActividadesPorDia(final String dia) {
    final String _sql = "SELECT * FROM actividades WHERE dia = ? ORDER BY horaInicio";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dia == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dia);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"actividades"}, new Callable<List<Actividad>>() {
      @Override
      @NonNull
      public List<Actividad> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfDia = CursorUtil.getColumnIndexOrThrow(_cursor, "dia");
          final int _cursorIndexOfHoraInicio = CursorUtil.getColumnIndexOrThrow(_cursor, "horaInicio");
          final int _cursorIndexOfHoraFin = CursorUtil.getColumnIndexOrThrow(_cursor, "horaFin");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final List<Actividad> _result = new ArrayList<Actividad>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Actividad _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpDia;
            if (_cursor.isNull(_cursorIndexOfDia)) {
              _tmpDia = null;
            } else {
              _tmpDia = _cursor.getString(_cursorIndexOfDia);
            }
            final String _tmpHoraInicio;
            if (_cursor.isNull(_cursorIndexOfHoraInicio)) {
              _tmpHoraInicio = null;
            } else {
              _tmpHoraInicio = _cursor.getString(_cursorIndexOfHoraInicio);
            }
            final String _tmpHoraFin;
            if (_cursor.isNull(_cursorIndexOfHoraFin)) {
              _tmpHoraFin = null;
            } else {
              _tmpHoraFin = _cursor.getString(_cursorIndexOfHoraFin);
            }
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            _item = new Actividad(_tmpId,_tmpNombre,_tmpDia,_tmpHoraInicio,_tmpHoraFin,_tmpColor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
