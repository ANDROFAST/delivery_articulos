package com.myapps.delivery.negocio;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;
import java.util.Vector;
import org.json.JSONObject;

public class Sesion {
    public static String codUsuario = "0";
    public static String nombreUsuario = "";

    public boolean iniciarSesion(String email, String clave, String[] datosRetorno) throws Exception {
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("email", email));
        valoresPOST.addElement(new HttpPostValues("clave", clave));
        JSONObject objResultado = new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/iniciar-sesion.php", valoresPOST));
        String estadox = objResultado.get("estado").toString();
        String mensajex = objResultado.get("mensaje").toString();
        if (estadox.equalsIgnoreCase("exito")) {
            JSONObject objDatos = (JSONObject) objResultado.get("datos");
            String nombrex = objDatos.get("nombre").toString();
            String emailx = objDatos.get("email").toString();
            codUsuario = objDatos.get("cod_usuario").toString();
            nombreUsuario = nombrex;
            datosRetorno[0] = mensajex;
            datosRetorno[1] = nombrex;
            datosRetorno[2] = emailx;
            return true;
        }
        datosRetorno[0] = mensajex;
        return false;
    }
}
