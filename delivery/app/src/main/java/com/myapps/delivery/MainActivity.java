package com.myapps.delivery;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_icono);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

        Bundle parametros = this.getIntent().getExtras();

        String mensaje = parametros.getString("par_mensaje");
        String nombre = parametros.getString("par_nombre");
        String email = parametros.getString("par_email");

        // populate the navigation drawer
        mNavigationDrawerFragment.setUserData(nombre, email, BitmapFactory.decodeResource(getResources(), R.drawable.avatar));

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment fragment, fragment1, fragment2, fragment3;
        switch (position) {
            case 0: //Inicio//todo
                fragment1 = new Inicio();
                getFragmentManager().beginTransaction().replace(R.id.container, fragment1, Inicio.TAG).commit();
                break;
            case 1: //Producto - Seleccionar categoria
                fragment2 = new SeleccionarCategoria();
                getFragmentManager().beginTransaction().replace(R.id.container, fragment2, SeleccionarCategoria.TAG).commit();
                break;
            case 2: //carrito //todo
                fragment3 = new MostrarCarrito();
                getFragmentManager().beginTransaction().replace(R.id.container, fragment3, MostrarCarrito.TAG).commit();
                break;
            case 3: //salir //todo
                cerrarSesion();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        /*
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();*/
        cerrarSesion();
    }

    public void cerrarSesion() {
        final AlertDialog.Builder dialogoCerrar = new AlertDialog.Builder(this);
        dialogoCerrar.setTitle("Cerrar Sesion de Delivery App");
        dialogoCerrar.setMessage("Realmente desea Cerrar su Sesion...");
        dialogoCerrar.setCancelable(false);

        dialogoCerrar.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialogoCerrar.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //No hace nada
            }
        });
        dialogoCerrar.show();
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
    */

}
