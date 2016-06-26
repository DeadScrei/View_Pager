package com.appspot.bgje0341.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.appspot.bgje0341.petagram.Adapter.Adapter;
import com.appspot.bgje0341.petagram.Adapter.PageAdapter;
import com.appspot.bgje0341.petagram.Pojo.Mascota;

import java.util.ArrayList;

import Fragments.Fragment_List;
import Fragments.Fragment_Perfil;

public class MainActivity extends AppCompatActivity {

    private Toolbar bar;
    private RecyclerView recyclerView;
    private ArrayList<Mascota> mascotas;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        if(bar==null)
            setSupportActionBar(bar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        setViewPager();
/*
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        initLista();
        initAdapter();

        ArrayList<String> nombresMascotas = new ArrayList<>();
        for (Mascota mascota: mascotas){
            nombresMascotas.add(mascota.getNombre());
        }*/
    }

    private ArrayList<Fragment> setFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new Fragment_List());
        fragments.add(new Fragment_Perfil());

        return  fragments;
    }

    public void setViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), setFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.seleccione_todos);
        tabLayout.getTabAt(1).setIcon(R.drawable.usuario);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.iconodeBar:
                Intent intent = new Intent(this,fab_mas.class);
                for (int c=0;c< Adapter.seleccion.size();c++){
                    intent.putExtra("Imagen"+c,Adapter.seleccion.get(c).getImagen());//Imagen
                    intent.putExtra("Estrella"+c,Adapter.seleccion.get(c).getHuesoB());//Estrella
                    intent.putExtra("Corazon"+c,Adapter.seleccion.get(c).getHuesoA());//Corazon
                    intent.putExtra("Nombre"+c,Adapter.seleccion.get(c).getNombre());//Nombre
                    intent.putExtra("Like"+c,Adapter.seleccion.get(c).getLike());//Like
                }
                startActivity(intent);
                return true;
            case R.id.m_contacto:
                Intent intent1 = new Intent(this,Contacto.class);
                startActivity(intent1);
                return true;
            case R.id.m_acercade:
                Intent intent2 = new Intent(this,About.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
