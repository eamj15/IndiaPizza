package com.example.indiapizza.entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.indiapizza.Helpers.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;


    public Clientes(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<String> ObtenerNombreClientes(Context context){
        List<String> nombre = new ArrayList<>();
        try{
            DbHelper dbHelper = new DbHelper(context, "indiapizza");
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            if(db != null){

                String[] campos = new String[]{"nombre"};
                Cursor cursor = db.query("clientes", campos, null, null, null, null, null);
                if(cursor.moveToFirst()){
                    do{
                        nombre.add(cursor.getString(0));
                    }while (cursor.moveToNext());
                }

            }
        }catch (Exception e){
            Toast.makeText(context, "Error en la insercion de cliente =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }

        return nombre;
    }

    public Clientes(int id, String nombre, String direccion, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Clientes(String nombre, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }




  public boolean insert(Context context){
        try{
            DbHelper dbHelper = new DbHelper(context, "indiapizza");
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            if(db != null){
                ContentValues valores = new ContentValues();

                valores.put("nombre", this.getNombre());
                valores.put("direccion", this.getDireccion());
                valores.put("telefono", this.getTelefono());
                valores.put("correo", this.getCorreo());


                db.insert("clientes", null, valores);
                return true;
            }

        }catch (Exception e){
            Toast.makeText(context, "Error en la insercion de cliente =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return false;
  }



}