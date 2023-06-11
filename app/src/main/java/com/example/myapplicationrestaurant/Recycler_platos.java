package com.example.myapplicationrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationrestaurant.controlador.PlatosControlador;
import com.example.myapplicationrestaurant.models.Platos;

import java.util.List;

public class Recycler_platos extends RecyclerView.Adapter<Recycler_platos.PlatosViewHolder>{

    private FragmentManager fragmentManager;
    private int numPlatos;
    Context context ;
    List<Platos> platos;

    public Recycler_platos(int numPlatos, Context context, FragmentManager fragmentManager, List<Platos> platos) {
        this.numPlatos = numPlatos;
        this.context = context;
        this.fragmentManager=fragmentManager;
        this.platos=platos;
    }


    @NonNull
    @Override
    public Recycler_platos.PlatosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutParaListItem = R.layout.recycler_platos;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        boolean attach = false;

        View view =inflater.inflate(layoutParaListItem,parent,attach);
        PlatosViewHolder platosViewHolder = new PlatosViewHolder(view);
        return new PlatosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_platos.PlatosViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        PlatosControlador platosControlador = new PlatosControlador();

        return platos.size();
    }


    public class PlatosViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenCheck;
        TextView listaItemTitulo,listaItemTipo,listaItemPrecio;

        protected void fragmentoVideito(int position){

            FragmentTransaction ft=  fragmentManager.beginTransaction();
            //aqui cuando le paso el fragmente de la pelicula le paso la clase Pelicula en especifico.
            infoPlatoFragment fv= new infoPlatoFragment(platos.get(position));

            ft.replace(R.id.fragment_containerMain, fv)
                    .addToBackStack(null)
                    .commit();


        }

        public void bind(int listaIndex){


            listaItemTitulo.setText(platos.get(listaIndex).getNombre());
            listaItemTipo.setText(platos.get(listaIndex).getTipo());
            listaItemPrecio.setText(platos.get(listaIndex).getTotal()+" $");
            Glide.with(context).load(platos.get(listaIndex).getImg()).into(imagenCheck);
        }

        //constructor
        public PlatosViewHolder(@NonNull View itemView) {
            super(itemView);
            listaItemTitulo = itemView.findViewById(R.id.textViewItemTitulo);
            listaItemTipo = itemView.findViewById(R.id.listaItemTipo);
            listaItemPrecio = itemView.findViewById(R.id.textViewItemPrecio);
            imagenCheck= itemView.findViewById(R.id.imagePlato);
            LinearLayout li = itemView.findViewById(R.id.ocaso);


            //definimos el onclik
            li.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //en el on click llamamos a nuestra clase fragmento y le pasamos el getAdapterPosition para que ponga en el contenedor que esta
                    //en el activite main. y que muestre el nuevo fragmeto de video es decir que ya no se muestre el recycler si no el fragmento del video.
                    fragmentoVideito(getAdapterPosition());
                }
            });{

            }

        }

    }



}
