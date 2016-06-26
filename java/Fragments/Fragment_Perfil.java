package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appspot.bgje0341.petagram.Adapter.Adapter;
import com.appspot.bgje0341.petagram.Adapter.Adapter_Perfil;
import com.appspot.bgje0341.petagram.Pojo.Mascota;
import com.appspot.bgje0341.petagram.R;

import java.util.ArrayList;

public class Fragment_Perfil extends Fragment {

    private Toolbar bar;
    private RecyclerView recyclerView;
    private ArrayList<Mascota> mascotas;

    public Fragment_Perfil() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_Perfil);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager);

        initLista();
        initAdapter();

        ArrayList<String> nombresMascotas = new ArrayList<>();
        for (Mascota mascota: mascotas){
            nombresMascotas.add(mascota.getNombre());
        }
        return v;
    }
    public void initAdapter(){
        Adapter_Perfil adapter = new Adapter_Perfil(mascotas);
        recyclerView.setAdapter(adapter);
    }

    public void initLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.girl1, R.drawable.corazones, R.drawable.estrella, "Carla", 0));
        mascotas.add(new Mascota(R.drawable.girl2, R.drawable.corazones, R.drawable.estrella, "Andrea", 0));
        mascotas.add(new Mascota(R.drawable.girl3, R.drawable.corazones, R.drawable.estrella, "Paola", 0));
        mascotas.add(new Mascota(R.drawable.girl4, R.drawable.corazones, R.drawable.estrella, "Scarlet", 0));
        mascotas.add(new Mascota(R.drawable.girl5, R.drawable.corazones, R.drawable.estrella, "Wendy", 0));
        mascotas.add(new Mascota(R.drawable.girl6, R.drawable.corazones, R.drawable.estrella, "Jannete", 0));
        mascotas.add(new Mascota(R.drawable.girl7, R.drawable.corazones, R.drawable.estrella, "Honey", 0));
        mascotas.add(new Mascota(R.drawable.girl8, R.drawable.corazones, R.drawable.estrella, "Alejandra", 0));
    }

}
