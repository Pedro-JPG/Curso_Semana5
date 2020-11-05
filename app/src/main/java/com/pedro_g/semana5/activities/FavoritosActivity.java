package com.pedro_g.semana5.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedro_g.semana5.IRecyclerViewFragmentView;
import com.pedro_g.semana5.pojo.Mascotas;
import com.pedro_g.semana5.R;
import com.pedro_g.semana5.adapter.ContactoAdapter;
import com.pedro_g.semana5.presenter.FavoritosFragmentPresenter;
import com.pedro_g.semana5.presenter.IRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IRecyclerViewFragmentView {
    ArrayList<Mascotas> mMascotasFav;
    private RecyclerView listaMascotasFav;
    private IRecyclerViewFragmentPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Log.d("Favoritos","Si, entro a favoritos");
        //Defino la toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    listaMascotasFav = (RecyclerView) findViewById(R.id.recyclerviewfav);
    //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
        presenter= new FavoritosFragmentPresenter(this,this);
    }



    private void initListaContactos() {
//        mMascotasFav = new ArrayList<Mascotas>();
//        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro A",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro2,"Perro B",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro C",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro2,"Perro D",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro E",0));
    }
    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Mascotas> mascotas) {
        ContactoAdapter adapter =  new ContactoAdapter(mascotas,this);
        return adapter;
    }

    @Override
    public void inicializarAdaptador(ContactoAdapter adaptador) {
        listaMascotasFav.setAdapter(adaptador);
    }



}
