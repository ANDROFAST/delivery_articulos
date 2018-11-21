package com.myapps.delivery.negocio;

import com.myapps.delivery.datos.Http;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class Categoria {

	private int codigo;
	private String nombre;
	private String url;

	public static ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	public Categoria(int codigo, String nombre,String url) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.url = url;
		
	}
	public Categoria() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void listar() throws Exception {
		String resultado = "";
		resultado = new Http().enviarGet(Http.URL_WEB_SERVICE+"listar-categoria.php");
		
		JSONObject json = new JSONObject(resultado);
		JSONArray jsonArray = json.getJSONArray("categorias");
		
		Categoria.listaCategoria.clear();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			Categoria.listaCategoria.add( 
					new Categoria( jsonData.getInt("codigo"), 
							jsonData.getString("nombre"), 
							jsonData.getString("url") ) );
		}
		
		
	}
}
