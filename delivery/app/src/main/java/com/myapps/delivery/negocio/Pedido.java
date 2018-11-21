package com.myapps.delivery.negocio;

import android.content.Context;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;

import org.json.JSONObject;

import java.util.Vector;


public class Pedido {

	private int codigo;		
	private String direccion;
	
	public String JSON;
	public Pedido() {
		
	}
	
	public Pedido(int codigo, String direccion) {
		super();
		this.codigo = codigo;	
		this.direccion = direccion;				
	}
	

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	
	

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	
		
	
	public boolean agregar(Context t) throws Exception{
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("cod_usuario",Sesion.codUsuario));		
		valoresPOST.addElement( new HttpPostValues("json",new String(this.JSON.getBytes("ISO-8859-1"), "UTF-8")));
		valoresPOST.addElement( new HttpPostValues("direccion",this.getDireccion()));		
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"registrar-pedido.php",valoresPOST);				
		JSONObject objResultado = new JSONObject(resultado);
		String estado = objResultado.get("estado").toString();
		
		if (!estado.equals("exito")){
			return false;
		}
		return true;
	}
	
}
