package com.example.myapplicationrestaurant;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplicationrestaurant.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registro);

        //esto es para el splash para que quede rexulon
        Intent i = new Intent(this, Splash.class);
        startActivity(i);

        //Aqui llamo al fragmento que esta en el contenedor Framelayout que contiene el Recyclerview y el searchView  y le paso el hashmap y el contexto
         TipoPedidoFragment fragment_seleccion= new TipoPedidoFragment();
        //aqui seteo el fragmento ya iniciado en el contenedor fragmento
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerRegistro, fragment_seleccion).commit();

    }

}