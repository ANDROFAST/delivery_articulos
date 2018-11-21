package com.myapps.delivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SeleccionarDireccion extends Activity {
    private LatLng latlong = new LatLng(-6.760644d, -79.863413d);
    private GoogleMap map;

    class C08151 implements OnMapLongClickListener {
        C08151() {
        }

        public void onMapLongClick(LatLng LL) {
            MostrarCarrito.lat = LL.latitude;
            MostrarCarrito.lon = LL.longitude;
            SeleccionarDireccion.this.regresar();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0477R.layout.activity_seleccionar_direccion);
        this.map = ((MapFragment) getFragmentManager().findFragmentById(C0477R.id.map)).getMap();
        this.map.setOnMapLongClickListener(new C08151());
        MostrarCarrito.checked = true;
        if (this.map != null) {
            iniciarGPS();
        }
    }

    private void iniciarGPS() {
        this.map.addMarker(new MarkerOptions().position(this.latlong).title("Ubicacion actual"));
        this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(this.latlong, 15.0f));
    }

    public void regresar() {
        Intent intent = new Intent(this, MostrarCarrito.class);
        intent.setFlags(131072);
        startActivity(intent);
        finish();
    }
}
