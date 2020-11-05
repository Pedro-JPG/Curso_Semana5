package com.pedro_g.semana5.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pedro_g.semana5.IMascotasFragmentView;
import com.pedro_g.semana5.R;
import com.pedro_g.semana5.adapter.MascotaAdapter;
import com.pedro_g.semana5.pojo.Mascotas;
import com.pedro_g.semana5.presenter.IRecyclerViewFragmentPresenter;
import com.pedro_g.semana5.presenter.MascotasFragmentPresenter;

import java.util.ArrayList;


public class MascotasFragment extends Fragment  implements IMascotasFragmentView {
    private RecyclerView listaMascotas;
    ArrayList<Mascotas> mMascotas;
    private ImageView imgMascota;
    private TextView nameMascota;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_mascotas,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.recyclerview);
        imgMascota = (ImageView) v.findViewById(R.id.imgMascota);
        nameMascota = (TextView) v.findViewById(R.id.textMascota);
        presenter= new MascotasFragmentPresenter(this,getContext());
        return v;
    }

    public void incializarAdaptador(){
        MascotaAdapter adapter =  new MascotaAdapter(mMascotas);
        listaMascotas.setAdapter(adapter);
    }
    private void initGridFotos() {
        mMascotas = new ArrayList<Mascotas>();
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro A",1));
        mMascotas.add(new Mascotas(R.drawable.perro2,"Perro B",0));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro C",1));
        mMascotas.add(new Mascotas(R.drawable.perro2,"Perro D",0));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro E",1));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro F",0));
        mMascotas.add(new Mascotas(R.drawable.perro1,"Perro G",1));
    }




    @Override
    public void generarLayoutGrid() {
        //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotaAdapter adapter =  new MascotaAdapter(mascotas);
        return adapter;
    }

    @Override
    public void inicializarAdaptador(MascotaAdapter adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}