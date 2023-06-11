package com.example.myapplicationrestaurant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class FormularioFragment extends Fragment {
    private String set;
    private RadioGroup rbtGrup;


    private EditText texDireccion, texDate, textNombre, textApellidos, textTelefono;

    public FormularioFragment(String set) {
        // Required empty public constructor
        this.set=set;
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_formulario, container, false);

        Button btForm;
        RadioButton rdbRestaurante, rdbCasa;
        rbtGrup = v.findViewById(R.id.RadioGroupRest);
        texDireccion = v.findViewById(R.id.editTextDireccion);
        rdbRestaurante = v.findViewById(R.id.radioButtonRestaurante);
        rdbCasa= v.findViewById(R.id.radioButtonLlevar);
        texDate= v.findViewById(R.id.editTextDate);
        btForm = v.findViewById(R.id.buttonForm);
        int referencia = (int) (Math.floor(Math.random()*(1000000-100000+1)+100000));  // Valor entre M y N, ambos incluidos. no me juzgues dani.
        setLugar(set);


        btForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().finish();


            }
        });



        return v;
    }

    public boolean confi(EditText editText){
        String campoTexto = editText.getText().toString();

        if (campoTexto.isEmpty()) {
            // El campo está vacío, mostrar un mensaje de error o tomar la acción correspondiente.
            Toast.makeText(getContext(), "Todos los campos tienen que estar rellenos", Toast.LENGTH_LONG).show();
            return false;
        } else {
            // El campo no está vacío, continuar con el flujo normal del programa.
            return true;
        }

    }

    public void setLugar(String set){
        if (set.equals("restaurante")==true){

            texDireccion.setVisibility(View.GONE);
            texDate.setVisibility(View.VISIBLE);
            rbtGrup.setVisibility(View.VISIBLE);


        } else {
            rbtGrup.setVisibility(View.GONE);
            texDireccion.setVisibility(View.VISIBLE);
            texDate.setVisibility(View.GONE);


        }
    }
}