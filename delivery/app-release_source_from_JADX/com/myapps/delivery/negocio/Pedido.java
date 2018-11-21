package com.myapps.delivery.negocio;

import android.content.Context;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;
import java.util.Vector;
import org.json.JSONObject;

public class Pedido {
    public String JSON;
    private int codigo;
    private String direccion;

    public Pedido(int codigo, String direccion) {
        this.codigo = codigo;
        this.direccion = direccion;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean agregar(Context t) throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_usuario", Sesion.codUsuario));
        valoresPOST.addElement(new HttpPostValues("json", new String(this.JSON.getBytes("ISO-8859-1"), "UTF-8")));
        valoresPOST.addElement(new HttpPostValues("direccion", getDireccion()));
        if (new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/registrar-pedido.php", valoresPOST)).get("estado").toString().equals("exito")) {
            return true;
        }
        return false;
    }
}
