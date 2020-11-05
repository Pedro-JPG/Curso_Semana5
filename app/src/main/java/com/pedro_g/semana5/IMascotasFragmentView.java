package com.pedro_g.semana5;

import com.pedro_g.semana5.adapter.MascotaAdapter;
import com.pedro_g.semana5.pojo.Mascotas;

import java.util.ArrayList;

public interface IMascotasFragmentView {

    public void generarLayoutGrid();

    public MascotaAdapter crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptador(MascotaAdapter adaptador);
}
