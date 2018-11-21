package com.myapps.delivery.negocio;

import com.myapps.delivery.C0477R;
import com.myapps.delivery.SeleccionarCategoria;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class Empresa {
    public static ArrayList<Empresa> listaEmpresa = new ArrayList();
    private String categoria;
    private int codigo;
    private String descripcion;
    private int imagen;
    private String nombre;

    public Empresa(int codigo, String nombre, String descripcion, String categoria, int imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public Empresa(int codigo) {
        this.codigo = codigo;
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void listar(String codigo_categoria, String f_nombre) throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("codigo_categoria", codigo_categoria));
        valoresPOST.addElement(new HttpPostValues("f_nombre", f_nombre));
        JSONArray jsonArray = new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/listar-empresa.php", valoresPOST)).getJSONArray("empresas");
        listaEmpresa.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonData = jsonArray.getJSONObject(i);
            listaEmpresa.add(new Empresa(jsonData.getInt("codigo"), jsonData.getString("nombre"), jsonData.getString("descripcion"), jsonData.getString(SeleccionarCategoria.TAG), C0477R.drawable.producto));
        }
    }
}
