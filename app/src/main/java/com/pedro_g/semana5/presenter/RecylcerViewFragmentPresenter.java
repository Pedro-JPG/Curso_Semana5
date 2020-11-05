package com.pedro_g.semana5.presenter;

import android.content.Context;

import com.pedro_g.semana5.IRecyclerViewFragmentView;
import com.pedro_g.semana5.db.ConstrutorMascotas;
import com.pedro_g.semana5.pojo.Mascotas;

import java.util.ArrayList;

public class RecylcerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView mIRecyclerViewFragmentView;
    private Context mContext;
    private ConstrutorMascotas mConstrutorMascotas;
    private ArrayList<Mascotas> mMascotas;

    public RecylcerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.mIRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.mContext=context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        mConstrutorMascotas = new ConstrutorMascotas(mContext);
        mMascotas= mConstrutorMascotas.obtenerMascotas();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        mIRecyclerViewFragmentView.inicializarAdaptador(mIRecyclerViewFragmentView.crearAdaptador(mMascotas));
        mIRecyclerViewFragmentView.generarLayoutVertical();
    }
}
