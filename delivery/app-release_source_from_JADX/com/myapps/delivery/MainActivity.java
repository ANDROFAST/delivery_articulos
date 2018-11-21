package com.myapps.delivery;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {
    private GoogleApiClient client;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;

    class C04631 implements OnClickListener {
        C04631() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainActivity.this.finish();
        }
    }

    class C04642 implements OnClickListener {
        C04642() {
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0477R.layout.activity_main);
        this.mToolbar = (Toolbar) findViewById(C0477R.id.toolbar_actionbar);
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().setIcon((int) C0477R.mipmap.ic_icono);
        this.mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(C0477R.id.fragment_drawer);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.mNavigationDrawerFragment.setup(C0477R.id.fragment_drawer, (DrawerLayout) findViewById(C0477R.id.drawer), this.mToolbar);
        Bundle parametros = getIntent().getExtras();
        String mensaje = parametros.getString("par_mensaje");
        this.mNavigationDrawerFragment.setUserData(parametros.getString("par_nombre"), parametros.getString("par_email"), BitmapFactory.decodeResource(getResources(), C0477R.drawable.avatar));
        this.client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0:
                getFragmentManager().beginTransaction().replace(C0477R.id.container, new Inicio(), Inicio.TAG).commit();
                return;
            case 1:
                getFragmentManager().beginTransaction().replace(C0477R.id.container, new SeleccionarCategoria(), SeleccionarCategoria.TAG).commit();
                return;
            case 2:
                getFragmentManager().beginTransaction().replace(C0477R.id.container, new MostrarCarrito(), MostrarCarrito.TAG).commit();
                return;
            case 3:
                cerrarSesion();
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        cerrarSesion();
    }

    public void cerrarSesion() {
        AlertDialog.Builder dialogoCerrar = new AlertDialog.Builder(this);
        dialogoCerrar.setTitle("Cerrar Sesion de Delivery App");
        dialogoCerrar.setMessage("Realmente desea Cerrar su Sesion...");
        dialogoCerrar.setCancelable(false);
        dialogoCerrar.setPositiveButton("SI", new C04631());
        dialogoCerrar.setNegativeButton("NO", new C04642());
        dialogoCerrar.show();
    }
}
