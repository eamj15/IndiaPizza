package com.example.indiapizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PedidosActivity extends AppCompatActivity {

    Spinner spnPizzas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        InicializarController();

    }

    private void InicializarController() {
        spnPizzas = (Spinner)findViewById(R.id.spnPizzas);
        CargarSpinnerPizza();

    }

    public void CargarSpinnerPizza(){
        List<String> pizzas = new ArrayList<>();
        pizzas.add("Normalita");
        pizzas.add("Disq con peperoni");
        pizzas.add("CovidPizza");
        pizzas.add("La faiser");
        pizzas.add("Golpe Aztrazeneca Pizza");
        pizzas.add("Hisopado Pizza");
        pizzas.add("Sobrecosto Pizza");
        pizzas.add("Pizza Corrupcion");

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,pizzas);
        spnPizzas.setAdapter(adapter);
    }
}