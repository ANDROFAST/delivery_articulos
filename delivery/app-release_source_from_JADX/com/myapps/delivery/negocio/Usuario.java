package com.myapps.delivery.negocio;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;
import java.util.Vector;
import org.json.JSONObject;

public class Usuario {
    public boolean agregar(String nombre, String email, String direccion, String telefono, String clave, String[] datosRetorno) throws Exception {
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("nombre", nombre));
        valoresPOST.addElement(new HttpPostValues("email", email));
        valoresPOST.addElement(new HttpPostValues("direccion", direccion));
        valoresPOST.addElement(new HttpPostValues("telefono", telefono));
        valoresPOST.addElement(new HttpPostValues("clave", clave));
        JSONObject objResultado = new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/registrar-usuario.php", valoresPOST));
        String estadox = objResultado.get("estado").toString();
        datosRetorno[0] = objResultado.get("mensaje").toString();
        if (estadox.equalsIgnoreCase("exito")) {
            return true;
        }
        return false;
    }
}
