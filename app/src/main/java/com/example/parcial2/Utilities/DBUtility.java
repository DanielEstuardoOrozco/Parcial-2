package com.example.parcial2.Utilities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;
import com.example.parcial2.POJO.Tareas;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public static final String DB_NAME = "tareas.db";
    public static final int DB_VERSION = 1;
    private Context context;
    private DBHelper conn;


    public DBUtility(Context context){
        this.conn = new DBHelper(context);
        this.context = context;
    }

    public void insertaTarea(Tareas tarea){
        String query = "INSERT INTO TAREAS (FECHA, ESTADO, DESCRIPCION) VALUES ('"
                + tarea.getFecha() + "','"
                + Integer.toString(tarea.getEstado()) + "','"
                + tarea.getDescripcion() + "')";
        Log.d("Query", query);
        SQLiteDatabase db = conn.getWritableDatabase();
        db.execSQL(query);
    }

    public void actualizaTarea(String id){
        String query = " UPDATE TAREAS SET ESTADO = 1 WHERE ID = " + id;
        Log.d("Query", query);
        SQLiteDatabase db = conn.getWritableDatabase();
        db.execSQL(query);
    }

    public List<Tareas> getTareas(){
        List<Tareas> list = null;
        Tareas tmp;
        String query = "SELECT ID, FECHA, DESCRIPCION, ESTADO FROM TAREAS ";
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c != null && c.getCount() > 0){
            c.moveToFirst();
            list = new ArrayList<Tareas>();
            while (!c.isAfterLast()){
                tmp = new Tareas();
                tmp.setId(Integer.valueOf( c.getString(c.getColumnIndex("ID"))));
                tmp.setEstado(Integer.valueOf( c.getString(c.getColumnIndex("ESTADO"))));
                tmp.setFecha(c.getString(c.getColumnIndex("FECHA")));
                tmp.setDescripcion(c.getString(c.getColumnIndex("DESCRIPCION")));
                list.add(tmp);
                c.moveToNext();
            }
        }
        return list;
    }

    public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE TAREAS ("
                    + " ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " FECHA TEXT,"
                    + " ESTADO INTEGER, "
                    + " DESCRIPCION TEXT)";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
