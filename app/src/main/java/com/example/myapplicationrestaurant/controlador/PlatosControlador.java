package com.example.myapplicationrestaurant.controlador;

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

public class PlatosControlador {
    private  OkHttpClient client = new OkHttpClient();
    private List<Platos> listaPlatos;
    private List<Platos> bb;
    public void ConsultarPlatos() {
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
                    listaPlatos = gson.fromJson(responseBody, platosListType);
                    for (Platos plato : listaPlatos) {
                        System.out.println(plato.toString()+"----------------------------------------------------------------------------------------------------------------------00000000000000000000000000000");
                        bb.add(plato);
                    }
                    //System.out.println(listaPlatos.size()+"----------------------------------------------------------------------------------------------------------------------00000000000000000000000000000");




                    // Aquí puedes procesar la respuesta exitosa
                } else {
                    // Manejo de error en caso de respuesta no exitosa
                    System.out.println("no vaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

                }

            }
        });
    }

    public List<Platos> getListaClientes() throws Exception {
        ConsultarPlatos();
        return this.listaPlatos;
    }

    public Platos getPlatos(Platos platos) throws Exception {
        for (Platos c: getListaClientes()) {
            c.equals(platos);
        }
        return platos;
    }


    public List<Platos> getPlatoTipo(String tipo) throws Exception {
        List<Platos> t = null;
        for (Platos c: getListaClientes()) {
            if ( c.getTipo().equals(tipo)){
                bb.add(c);
            }
        }
        return bb;
    }


}
