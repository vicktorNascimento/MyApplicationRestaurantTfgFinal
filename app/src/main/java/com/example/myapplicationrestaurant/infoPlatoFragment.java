package com.example.myapplicationrestaurant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.myapplicationrestaurant.models.Platos;


public class infoPlatoFragment extends Fragment {

    Button btnMas, btnMenos, btnCesta;
    TextView textCantidad, textViewPrecio, textViewTitulo, textViewDescripcion;
    Platos platos;

    ImageView img;

    public infoPlatoFragment(Platos platos) {
        // Required empty public constructor
        this.platos = platos;
    }




    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =inflater.inflate(R.layout.fragment_info_plato, container, false);
        btnCesta = v.findViewById(R.id.buttonCesta);
        btnMas = v.findViewById(R.id.buttonMas);
        btnMenos= v.findViewById(R.id.buttonMenos);
        textCantidad=v.findViewById(R.id.textViewCantidad);
        textViewTitulo=v.findViewById(R.id.textViewTitulo);
        textViewDescripcion=v.findViewById(R.id.textViewDescripcion);
        textViewPrecio=v.findViewById(R.id.textViewPrecio);
        img=v.findViewById(R.id.imageViewImg);
        Glide.with(getContext()).load(platos.getImg()).into(img);

        textViewPrecio.setText(platos.getTotal()+" * ");
        textViewDescripcion.setText(platos.getFecha_pedido());
        textViewTitulo.setText(platos.getNombre());


        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumar();
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar();
            }
        });



        return v;
    }

    public void sumar() {
        int res = Integer.parseInt(textCantidad.getText().toString());
        System.out.println(res);
        if(res>-1){
            textCantidad.setText(res+1+"");

        }

    }

    public void restar(){
        int res = Integer.parseInt(textCantidad.getText().toString());
        if(res>0){
            textCantidad.setText(res-1+"");

        }
    }

    public void cesta() {

    }


}