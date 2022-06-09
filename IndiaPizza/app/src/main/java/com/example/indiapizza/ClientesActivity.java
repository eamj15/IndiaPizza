package com.example.indiapizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indiapizza.entidades.Clientes;

public class ClientesActivity extends AppCompatActivity {

    EditText nombre, direccion, telefono, correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);


        InicializarControler();
    }

    private void InicializarControler() {
        nombre= (EditText)findViewById(R.id.txtNombre);
        direccion=(EditText)findViewById(R.id.txtDireccion);
        telefono=(EditText)findViewById(R.id.txtTelefono);
        correo=(EditText)findViewById(R.id.txtCorreo);
    }


    public void InsertarCliente(View v){
        try{
            Clientes cliente = new Clientes(
                    nombre.getText().toString(),
                    direccion.getText().toString(),
                    telefono.getText().toString(),
                    correo.getText().toString()
            );

            Boolean insertado = cliente.insert(this);
            if(insertado){
                Toast.makeText(this, "Se inserto woeeee", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }else{
                Toast.makeText(this, "Valio Madres, no se inserto", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "Error en el boton =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}