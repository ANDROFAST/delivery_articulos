package com.myapps.delivery.negocio;

import com.google.android.gms.plus.PlusShare;
import com.myapps.delivery.datos.Http;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Categoria {
    public static ArrayList<Categoria> listaCategoria = new ArrayList();
    private int codigo;
    private String nombre;
    private String url;

    public Categoria(int codigo, String nombre, String url) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.url = url;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void listar() throws Exception {
        String resultado = "";
        JSONArray jsonArray = new JSONObject(new Http().enviarGet("http://negocioe.netau.net/web-service/listar-categoria.php")).getJSONArray("categorias");
        listaCategoria.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonData = jsonArray.getJSONObject(i);
            listaCategoria.add(new Categoria(jsonData.getInt("codigo"), jsonData.getString("nombre"), jsonData.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        }
    }
}
