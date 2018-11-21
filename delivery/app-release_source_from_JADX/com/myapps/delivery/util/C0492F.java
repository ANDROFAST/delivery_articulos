package com.myapps.delivery.util;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.Toast;
import com.myapps.delivery.datos.Http;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class C0492F {
    public static final int PAYPAL_RESPONDE = 100;

    public static void msg(Context cnt, String msg) {
        Toast.makeText(cnt, msg, 1).show();
    }

    public static void alertador(String titulo, String msg, Context cont) {
        Builder alertDialogBuilder = new Builder(cont);
        alertDialogBuilder.setTitle(titulo);
        alertDialogBuilder.setMessage(msg).setCancelable(true);
        alertDialogBuilder.create().show();
    }

    public static void CopyStream(InputStream is, OutputStream os) {
        try {
            byte[] bytes = new byte[1024];
            while (true) {
                int count = is.read(bytes, 0, 1024);
                if (count != -1) {
                    os.write(bytes, 0, count);
                } else {
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    public static String getDireccionLL(double latitud, double longitud) {
        String resultado = null;
        try {
            resultado = new Http().enviarGet("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + String.valueOf(latitud) + "%2C" + String.valueOf(longitud));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return new JSONObject(resultado).getJSONArray("results").getJSONObject(0).getString("formatted_address");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "Lat / Long inv�lidas";
        }
    }
}
