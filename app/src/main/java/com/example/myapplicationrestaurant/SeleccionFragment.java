package com.example.myapplicationrestaurant;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationrestaurant.controlador.PlatosControlador;
import com.example.myapplicationrestaurant.models.Platos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SeleccionFragment extends Fragment {
    Button btnPago;
    String set;
    private OkHttpClient client = new OkHttpClient();
    private List<Platos> platosList;
    private List<Platos> tipoList;
    public SeleccionFragment(String set) {
        // Required empty public constructor
        this.set=set;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_seleccion, container, false);
        btnPago = v.findViewById(R.id.buttonPagar);
        setPago(set);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView myRv = (RecyclerView) v.findViewById(R.id.RcPlatos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        PlatosControlador platosControlador = new PlatosControlador();
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String  url = "http://192.168.1.10:8080/CRUDRepo/ConsultarPlatos";
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                // Manejo de error en caso de falla
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    //System.out.println(responseBody+"22222222222222222222222222222222222222222222222222222222222222222222222");
                    Gson gson = new Gson();
                    Type platosListType = new TypeToken<List<Platos>>() {}.getType();
                    platosList = gson.fromJson(responseBody, platosListType);
                    for (Platos plato : platosList) {
                        System.out.println(plato.toString()+"----------------------------------------------------------------------------------------------------------------------00000000000000000000000000000");

                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // y seteo el adaptador de la clase de RecyclerAdapter que cree yo.
                            Recycler_platos myAdapter = null;
                            try {
                                /*
                                for (Platos plato : platosList) {
                                    System.out.println(plato.toString()+"----------------------------------------------------------------------------------------------------------------------00000000000000000000000000000");
                                    if(plato.getTipo().equals(set)){
                                        tipoList.add(plato);
                                    }
                                }

                                 */
                                myAdapter = new Recycler_platos(5,getContext(), getParentFragmentManager(),platosList);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            myRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

                            myRv.setAdapter(myAdapter);


                        }
                    });
                    //System.out.println(listaPlatos.size()+"----------------------------------------------------------------------------------------------------------------------00000000000000000000000000000");

                    // Aquí puedes procesar la respuesta exitosa
                } else {
                    // Manejo de error en caso de respuesta no exitosa
                    System.out.println("no vaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


                }

            }
        });

        return v;

    }

    public void setPago(String set){
        if (set.equals("pago")==true){
            btnPago.setVisibility(View.VISIBLE);
        } else {
            btnPago.setVisibility(View.GONE);
        }
    }
}