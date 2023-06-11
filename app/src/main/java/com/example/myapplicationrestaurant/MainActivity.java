package com.example.myapplicationrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplicationrestaurant.controlador.PlatosControlador;
import com.example.myapplicationrestaurant.models.Platos;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private OkHttpClient client = new OkHttpClient();
    private List<Platos> platosList;


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlatosControlador platosControlador = new PlatosControlador();


        //esto es para el splash para que quede rexulon
        Intent j = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(j);



        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            SeleccionFragment fragment_seleccion= new SeleccionFragment("Entrante");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerMain, fragment_seleccion).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }



    }



    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int selectedId = item.getItemId();

        if (selectedId == R.id.nav_home) {


            // Lógica para la opción "nav_home"
             SeleccionFragment fragment_seleccion= new SeleccionFragment("Entrante");
            //aqui seteo el fragmento ya iniciado en el contenedor fragmento
             getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerMain, fragment_seleccion).commit();

        } else if (selectedId == R.id.nav_settings) {
            // Lógica para la opción "nav_profile"
              SeleccionFragment fragment_seleccion= new SeleccionFragment("Platos principales");
            //aqui seteo el fragmento ya iniciado en el contenedor fragmento
              getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerMain, fragment_seleccion).commit();
        } else if (selectedId == R.id.nav_share) {
            // Lógica para la opción "nav_settings"
             SeleccionFragment fragment_seleccion= new SeleccionFragment("Postres");
            //aqui seteo el fragmento ya iniciado en el contenedor fragmento
              getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerMain, fragment_seleccion).commit();
        } else if (selectedId == R.id.nav_about) {
             SeleccionFragment fragment_seleccion= new SeleccionFragment("Bebidas");
            //aqui seteo el fragmento ya iniciado en el contenedor fragmento
              getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerMain, fragment_seleccion).commit();

        }else if (selectedId == R.id.nav_pedidos) {
             SeleccionFragment fragment_seleccion= new SeleccionFragment("Mis pedidos");
            //aqui seteo el fragmento ya iniciado en el contenedor fragmento
              getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerMain, fragment_seleccion).commit();

        }else if (selectedId == R.id.nav_logout) {
            // SeleccionFragment fragment_seleccion= new SeleccionFragment("pago");
            //aqui seteo el fragmento ya iniciado en el contenedor fragmento
            // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerMain, fragment_seleccion).commit();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openNavigationMenu(View view) {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.openDrawer(GravityCompat.START);
    }


    }





