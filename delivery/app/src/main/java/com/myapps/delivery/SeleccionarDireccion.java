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
	
	private LatLng latlong = new LatLng(-6.760644,-79.863413);
	private GoogleMap map;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_direccion);            
        MapFragment fMap = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        //map.setMyLocationEnabled(true);
        map = fMap.getMap();
       
        map.setOnMapLongClickListener(new OnMapLongClickListener() {
        	public void onMapLongClick(LatLng LL)  {
        		MostrarCarrito.lat = LL.latitude;
        		MostrarCarrito.lon = LL.longitude;
        		regresar();
			}
        });

        MostrarCarrito.checked = true;        
        if (map!=null){
        	iniciarGPS();
          }
    }
    
    private void iniciarGPS(){	
		 map.addMarker(new MarkerOptions().position(latlong)
	                .title("Ubicacion actual"));
		 map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlong, 15));
	}

	public void regresar() {
		Intent intent = new Intent(this, MostrarCarrito.class);
		intent .setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);	
		this.finish();
		
	}

}
