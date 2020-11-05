package com.pedro_g.semana5;

import com.pedro_g.semana5.adapter.ContactoAdapter;
import com.pedro_g.semana5.pojo.Mascotas;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView  {

    public void generarLayoutVertical();

    public ContactoAdapter crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptador(ContactoAdapter adaptador);
}
