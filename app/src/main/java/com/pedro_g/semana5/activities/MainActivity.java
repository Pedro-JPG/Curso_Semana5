package com.pedro_g.semana5.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.pedro_g.semana5.adapter.PageAdapter;
import com.pedro_g.semana5.fragments.MascotasFragment;
import com.pedro_g.semana5.fragments.RecyclerFragment;
import com.pedro_g.semana5.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    ImageView imgFav;
    private Toolbar myToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //

        //ASigno la toolbar
        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //Asigno el TabLayout
        mTabLayout=(TabLayout)findViewById(R.id.tabLayout);
        //Asigno el ViewPager
        mViewPager=(ViewPager) findViewById(R.id.viewPager);



        setUpViewPager();
        if (myToolbar !=null){
            setSupportActionBar(myToolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.mContact:
                intent = new Intent(MainActivity.this, ContactenosActivity.class);
                startActivity(intent);
                break;
            case R.id.mFavoritos:
                intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(new RecyclerFragment());
        fragments.add(new MascotasFragment());
        return fragments;
    }
    private void setUpViewPager(){
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);
    }

    public void navaFAV (View v){
        Log.d("navaFAV","Boton apretado");
        Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
        startActivity(intent);
    }


}