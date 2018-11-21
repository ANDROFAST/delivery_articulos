package com.myapps.delivery.negocio;

import com.myapps.delivery.R;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;
/*
private $cod_articulo;
private $cod_usuario;
private $estrellas;
private $estado;
private $titulo;
private $descripcion;

*/


public class Votacion {
    private int cod_articulo;
    private int cod_usuario;
    private int estrellas;
    private String estado;
    private String titulo;
    private String descripcion;
    private int votos;

    public static ArrayList<Votacion> resultadoVotacion = new ArrayList<Votacion>();

    public Votacion(int cod_articulo, int cod_usuario, int estrellas, String estado, String titulo, String descripcion) {
        this.cod_articulo = cod_articulo;
        this.cod_usuario = cod_usuario;
        this.estrellas = estrellas;
        this.estado = estado;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Votacion(int estrellas, int votos){
        this.estrellas = estrellas;
        this.votos = votos;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Votacion() {
        super();
    }

    public int getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(int cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double obtenerPromedioVotosDeUnArticulo(String cod_articulo) throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
        valoresPOST.addElement( new HttpPostValues("cod_articulo",cod_articulo ));
        resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"obtener-votacion-articulo.php",valoresPOST);

        JSONObject json = new JSONObject(resultado);
        JSONArray jsonArray = json.getJSONArray("votos");
        int e1,e2,e3,e4,e5, v1,v2,v3,v4,v5;
        int m=0, suma=0;
        double promedio=0;

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonData = jsonArray.getJSONObject(i);
            //Votacion.resultadoVotacion.add(new Votacion(jsonData.getInt("estrellas"), jsonData.getInt("votos")));
            m=m+(jsonData.getInt("estrellas")*jsonData.getInt("votos"));
            suma=suma+(jsonData.getInt("votos"));

        }
        promedio=m/Double.valueOf(suma);

        return (promedio*10)/10;
    }

    public boolean agregarVotacion(String cod_articulo, String cod_usuario, String estrellas) throws Exception {
        Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();

        valoresPOST.addElement( new HttpPostValues("cod_articulo", cod_articulo) );
        valoresPOST.addElement( new HttpPostValues("cod_usuario", cod_usuario) );
        valoresPOST.addElement( new HttpPostValues("estrellas", estrellas) );

        String resultado = new Http().enviarPost( Http.URL_WEB_SERVICE+"agregar-votacion.php", valoresPOST);

        if(! resultado.trim().equalsIgnoreCase("exito")){
            throw new Exception("Error: "+resultado);
        }
        return true;
    }
    public int verificarSiYaVoto(String cod_articulo, String cod_usuario) throws Exception{
        Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
        valoresPOST.addElement( new HttpPostValues("cod_articulo", cod_articulo) );
        valoresPOST.addElement( new HttpPostValues("cod_usuario", cod_usuario) );

        String resultado = new Http().enviarPost( Http.URL_WEB_SERVICE+"verificarSiYaVoto.php", valoresPOST);

        JSONObject json = new JSONObject(resultado);
        JSONArray jsonArray = json.getJSONArray("estado");
        JSONObject jsonData = jsonArray.getJSONObject(0);
        if(jsonData.getInt("voto_si_no")==1){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int validarSiHayVotosParaArticulo(String cod_articulo) throws Exception{
        Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
        valoresPOST.addElement( new HttpPostValues("cod_articulo", cod_articulo) );
        String resultado = new Http().enviarPost( Http.URL_WEB_SERVICE+"validarSiHayVotos.php", valoresPOST);
        JSONObject json = new JSONObject(resultado);
        JSONArray jsonArray = json.getJSONArray("estado");
        JSONObject jsonData = jsonArray.getJSONObject(0);
        if(jsonData.getInt("registros")>0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
