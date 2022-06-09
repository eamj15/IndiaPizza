package com.example.indiapizza.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.indiapizza.R;

public class DbHelper extends SQLiteOpenHelper {

    String clientes =  "CREATE TABLE clientes (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, direccion TEXT, telefono TEXT, correo TEXT)";
    String pedidos= "CREATE TABLE pedidos (id INTEGER PRIMARY KEY AUTOINCREMENT, pizza TEXT, fecha TEXT, hora TEXT, precio FLOAT, ingredientes TEXT, cliente_id INTEGER)";

    public DbHelper(Context context, String dbName){
        super(context, dbName, null, R.integer.db_version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(clientes);
        sqLiteDatabase.execSQL(pedidos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
