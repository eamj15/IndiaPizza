package com.example.indiapizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.indiapizza.entidades.Clientes;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView pedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InicializarControler();
    }

    private void InicializarControler() {
        pedidos=(ListView)findViewById(R.id.lstPedidos);
        CargarListView();
    }

    private void CargarListView(){
        List<String> nombres = new Clientes().ObtenerNombreClientes(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,nombres);
        pedidos.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.miNewCliente:
                startActivity(new Intent(getApplicationContext(),ClientesActivity.class));
                break;
            case R.id.miNewPedido:
                startActivity(new Intent(getApplicationContext(),PedidosActivity.class));
                break;
        }
        return true;
    }
}