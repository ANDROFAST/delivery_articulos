package com.myapps.delivery.negocio;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class Votacion {
    public static ArrayList<Votacion> resultadoVotacion = new ArrayList();
    private int cod_articulo;
    private int cod_usuario;
    private String descripcion;
    private String estado;
    private int estrellas;
    private String titulo;
    private int votos;

    public Votacion(int cod_articulo, int cod_usuario, int estrellas, String estado, String titulo, String descripcion) {
        this.cod_articulo = cod_articulo;
        this.cod_usuario = cod_usuario;
        this.estrellas = estrellas;
        this.estado = estado;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Votacion(int estrellas, int votos) {
        this.estrellas = estrellas;
        this.votos = votos;
    }

    public int getVotos() {
        return this.votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getCod_articulo() {
        return this.cod_articulo;
    }

    public void setCod_articulo(int cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public int getCod_usuario() {
        return this.cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public int getEstrellas() {
        return this.estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double obtenerPromedioVotosDeUnArticulo(String cod_articulo) throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_articulo", cod_articulo));
        JSONArray jsonArray = new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/obtener-votacion-articulo.php", valoresPOST)).getJSONArray("votos");
        int m = 0;
        int suma = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonData = jsonArray.getJSONObject(i);
            m += jsonData.getInt("estrellas") * jsonData.getInt("votos");
            suma += jsonData.getInt("votos");
        }
        return (10.0d * (((double) m) / Double.valueOf((double) suma).doubleValue())) / 10.0d;
    }

    public boolean agregarVotacion(String cod_articulo, String cod_usuario, String estrellas) throws Exception {
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_articulo", cod_articulo));
        valoresPOST.addElement(new HttpPostValues("cod_usuario", cod_usuario));
        valoresPOST.addElement(new HttpPostValues("estrellas", estrellas));
        return new Http().enviarPost("http://negocioe.netau.net/web-service/agregar-votacion.php", valoresPOST).trim().equalsIgnoreCase("exito") ? true : true;
    }

    public int verificarSiYaVoto(String cod_articulo, String cod_usuario) throws Exception {
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_articulo", cod_articulo));
        valoresPOST.addElement(new HttpPostValues("cod_usuario", cod_usuario));
        if (new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/verificarSiYaVoto.php", valoresPOST)).getJSONArray("estado").getJSONObject(0).getInt("voto_si_no") == 1) {
            return 1;
        }
        return 0;
    }

    public int validarSiHayVotosParaArticulo(String cod_articulo) throws Exception {
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_articulo", cod_articulo));
        if (new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/validarSiHayVotos.php", valoresPOST)).getJSONArray("estado").getJSONObject(0).getInt("registros") > 0) {
            return 1;
        }
        return 0;
    }
}
