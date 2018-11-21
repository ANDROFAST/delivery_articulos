package com.myapps.delivery.negocio;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;

import org.json.JSONObject;

import java.util.Vector;


public class Sesion {
		
	public static String codUsuario = "0";
	public static String nombreUsuario="";
	
	public boolean iniciarSesion(String email, String clave, String datosRetorno[]) throws Exception {
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		
		valoresPOST.addElement( new HttpPostValues("email", email) );
		valoresPOST.addElement( new HttpPostValues("clave", clave) );
		
		String resultado = new Http().enviarPost( Http.URL_WEB_SERVICE+"iniciar-sesion.php", valoresPOST);
		
		JSONObject objResultado = new JSONObject(resultado);
		
		String estadox = objResultado.get("estado").toString();
		String mensajex = objResultado.get("mensaje").toString();
		
		if (!estadox.equals("exito")){
			datosRetorno[0] = mensajex;
			return false;
		}
		
		//exito = si acerto el email y la clave
		JSONObject objDatos = (JSONObject)objResultado.get("datos");
		
		String nombrex = objDatos.get("nombre").toString();
		String emailx = objDatos.get("email").toString();
		Sesion.codUsuario = objDatos.get("cod_usuario").toString();
		Sesion.nombreUsuario=nombrex;
				
		datosRetorno[0] = mensajex;
		datosRetorno[1] = nombrex;
		datosRetorno[2] = emailx;		
		
		return true;
	}
		
	
	
	
	
}
