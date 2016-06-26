package com.appspot.bgje0341.petagram.Adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appspot.bgje0341.petagram.Pojo.Mascota;
import com.appspot.bgje0341.petagram.R;

import java.util.ArrayList;

import Fragments.Fragment_List;

public class Adapter_Perfil extends RecyclerView.Adapter<Adapter_Perfil.ViewHolder> {

    public static ArrayList<Mascota> mascotas;
    public static ArrayList<Mascota> seleccion = new ArrayList<Mascota>();
    static int fav=0;

    public Adapter_Perfil (ArrayList<Mascota> mascotas){
        this.mascotas=mascotas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla el cardview a el Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        //Setea los valores de Mascota, Asosia los elementos de la lista con cada view

        final Mascota mascota = mascotas.get(position);

        viewHolder.imgPrincipal.setImageResource(mascota.getImagen());
        viewHolder.imgHA.setImageResource(mascota.getHuesoA());
        viewHolder.like.setText(Integer.toString(Fragment_List.mascotas.get(position).getLike()));


    }

    @Override
    public int getItemCount() { //Cantidad de elementos de la lista
        return mascotas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPrincipal;
        private ImageView imgHA;
        private TextView like;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPrincipal = (ImageView) itemView.findViewById(R.id.imgPrincipal);
            imgHA = (ImageView) itemView.findViewById(R.id.imgHA);
            like = (TextView) itemView.findViewById(R.id.numero);
        }
    }
}
