package com.myapps.delivery.negocio;

import com.myapps.delivery.R;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

public class Empresa {

	private int codigo;
	private String nombre;
	private String descripcion;
	private String categoria;
	private int imagen;
	
	public static ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();
	
	public Empresa(int codigo, String nombre, String descripcion,String categoria, int imagen) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.imagen = imagen;
		
	}
	public Empresa() {
		super();
	}
	
	public Empresa(int codigo){
		this.codigo = codigo;
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
	public int getImagen() {
		return imagen;
	}
	public void setImagen(int imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void listar(String codigo_categoria, String f_nombre) throws Exception {
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("codigo_categoria",codigo_categoria ));
		valoresPOST.addElement( new HttpPostValues("f_nombre",f_nombre ));					
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"listar-empresa.php",valoresPOST);		
			
		JSONObject json = new JSONObject(resultado);
		JSONArray jsonArray = json.getJSONArray("empresas");
		
		Empresa.listaEmpresa.clear();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			Empresa.listaEmpresa.add( new Empresa( 
					jsonData.getInt("codigo"),
					jsonData.getString("nombre"),
					jsonData.getString("descripcion"),
					jsonData.getString("categoria"),
					R.drawable.producto ) );
		}			
		
	}
	
}
