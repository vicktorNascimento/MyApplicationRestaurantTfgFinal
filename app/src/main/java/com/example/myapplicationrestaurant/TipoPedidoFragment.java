package com.example.myapplicationrestaurant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TipoPedidoFragment extends Fragment {


    public TipoPedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_tipo_pedido, container, false);
        Button btCasa, btRestaurant;
        btCasa = v.findViewById(R.id.buttonCasa);
        btRestaurant = v.findViewById(R.id.buttonRestaurant);

         btCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui llamo al fragmento que esta en el contenedor Framelayout que contiene el Recyclerview y el searchView  y le paso el hashmap y el contexto
                FormularioFragment fragment_seleccion= new FormularioFragment("casa");
                //aqui seteo el fragmento ya iniciado en el contenedor fragmento
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainerRegistro, fragment_seleccion).commit();
            }
        });

        btRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui llamo al fragmento que esta en el contenedor Framelayout que contiene el Recyclerview y el searchView  y le paso el hashmap y el contexto
                FormularioFragment fragment_seleccion= new FormularioFragment("restaurante");
                //aqui seteo el fragmento ya iniciado en el contenedor fragmento
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainerRegistro, fragment_seleccion).commit();

            }
        });

        return v;
    }
}