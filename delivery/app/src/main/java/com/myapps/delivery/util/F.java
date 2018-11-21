package com.myapps.delivery.util;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import com.myapps.delivery.datos.Http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;


public class F {
	public static final int PAYPAL_RESPONDE = 100;	
	
	public static void msg(Context cnt, String msg){
		Toast.makeText(cnt, msg, Toast.LENGTH_LONG).show();
	}
	
	public static void alertador(String titulo, String msg, Context cont){
			
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
			cont);	 
					alertDialogBuilder.setTitle(titulo);
					alertDialogBuilder
						.setMessage(msg)
						.setCancelable(true);
							 
						AlertDialog alertDialog = alertDialogBuilder.create();
						alertDialog.show();
	}
	
	public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
              int count=is.read(bytes, 0, buffer_size);
              if(count==-1)
                  break;
              os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
	
	public static String getDireccionLL(double latitud, double longitud){
		String googleapi = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+
				String.valueOf(latitud)+"%2C"+
				String.valueOf(longitud);
		
		String resultado = null;
		try {
			resultado = new Http().enviarGet(googleapi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
		JSONObject json = new JSONObject(resultado);
		JSONArray jsonArray = json.getJSONArray("results");
		
		JSONObject jsonData = jsonArray.getJSONObject(0);
		
			return jsonData.getString("formatted_address");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "Lat / Long inv�lidas";
	}
	
	
}

