package com.myapps.delivery.negocio;

import com.myapps.delivery.C0477R;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class Articulo {
    public static ArrayList<Articulo> listaArticulo = new ArrayList();
    private int codigo;
    private int imagen;
    private String nombre;
    private String precio;
    private int stock;

    public Articulo(int codigo, String nombre, String precio, int stock, int imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return this.imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return this.precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void listar(String codigo_empresa) throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("codigo_empresa", codigo_empresa));
        JSONArray jsonArray = new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/listar-articulo.php", valoresPOST)).getJSONArray("articulos");
        listaArticulo.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonData = jsonArray.getJSONObject(i);
            listaArticulo.add(new Articulo(jsonData.getInt("codigo"), jsonData.getString("nombre"), jsonData.getString("precio"), jsonData.getInt("stock"), C0477R.drawable.producto));
        }
    }
}
