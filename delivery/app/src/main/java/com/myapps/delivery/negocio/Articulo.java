package com.myapps.delivery.negocio;

import com.myapps.delivery.R;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;


public class Articulo {

	private int codigo;
	private String nombre;
	private String precio;
	private int stock;
	private int imagen;
	
	public static ArrayList<Articulo> listaArticulo = new ArrayList<Articulo>();
	
	public Articulo(int codigo, String nombre, String precio, int stock,int imagen) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.imagen = imagen;
		
	}
	public Articulo() {
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
	public int getImagen() {
		return imagen;
	}
	public void setImagen(int imagen) {
		this.imagen = imagen;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void listar(String codigo_empresa) throws Exception {
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("codigo_empresa",codigo_empresa ));
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"listar-articulo.php",valoresPOST);
		
		JSONObject json = new JSONObject(resultado);
		JSONArray jsonArray = json.getJSONArray("articulos");
		
		Articulo.listaArticulo.clear();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			Articulo.listaArticulo.add( 
					new Articulo( jsonData.getInt("codigo"),
							      jsonData.getString("nombre"),
							      jsonData.getString("precio"),
							      jsonData.getInt("stock"),
							      R.drawable.producto ) );
		}
		
		
	}
		
}
