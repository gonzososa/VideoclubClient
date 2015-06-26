package com.outlook.gonzasosa.demos.videoclubclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.outlook.gonzasosa.demos.videoclubclient.Fragments.ClientesNuevoFragment;
import com.outlook.gonzasosa.demos.videoclubclient.Fragments.FragmentDevoluciones;
import com.outlook.gonzasosa.demos.videoclubclient.Fragments.FragmentRentas;
import com.outlook.gonzasosa.demos.videoclubclient.Fragments.FragmentTitulos;

public class ActivityMain extends AppCompatActivity {
    Toolbar toolbar;
    ScrimInsetsFrameLayout scrimInsetsFrameLayout;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ListView listView;
    final String [] opciones = new String [] {"Clientes", "Títulos", "Rentas", "Devoluciones"};

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        scrimInsetsFrameLayout = (ScrimInsetsFrameLayout) findViewById (R.id.scrimInsetsFrameLayout);
        toolbar = (Toolbar) findViewById (R.id.appBar);
        setSupportActionBar (toolbar);

        drawerLayout = (DrawerLayout) findViewById (R.id.drawerLayout);
        drawerLayout.setStatusBarBackgroundColor (
                getResources().getColor (R.color.color_primary_dark)
        );

        drawerToggle = new ActionBarDrawerToggle (this,
                                                    drawerLayout,
                                                    toolbar,
                                                    R.string.openDrawer,
                                                    R.string.closeDrawer) {

            @Override
            public void onDrawerOpened (View drawerView) {
                super.onDrawerOpened (drawerView);
            }

            @Override
            public void onDrawerClosed (View drawerView) {
                super.onDrawerClosed (drawerView);
            }
        };

        drawerLayout.setDrawerListener (drawerToggle);

        ArrayAdapter<String> opcionesAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, opciones);

        listView = (ListView) findViewById (R.id.navdrawerlist);
        listView.setAdapter (opcionesAdapter);
        listView.setOnItemClickListener (new Foo ());

        if (getSupportActionBar () != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled      (true);
        }
    }


    /**
     * Opciones click helper class
     */
    class Foo implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick (AdapterView<?> adapterView, View view, int i, long l) {
            Fragment fragment = null;

            switch (i) {
                case 0:
                    fragment = new ClientesNuevoFragment();
                    break;
                case 1:
                    fragment = new FragmentTitulos();
                    break;
                case 2:
                    fragment = new FragmentRentas();
                    break;
                case 3:
                    fragment = new FragmentDevoluciones();
                    break;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction ();
            transaction.replace(R.id.dummyContent, fragment);
            transaction.commit  ();

            listView.setItemChecked (i, true);

            if (getSupportActionBar () != null) {
                getSupportActionBar ().setTitle (opciones [i]);
            }

            drawerLayout.closeDrawer (scrimInsetsFrameLayout);
        }
    }

}
