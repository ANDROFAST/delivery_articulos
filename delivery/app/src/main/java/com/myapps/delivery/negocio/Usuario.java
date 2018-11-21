package com.myapps.delivery.negocio;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;

import org.json.JSONObject;

import java.util.Vector;

public class Usuario {
	public boolean agregar(String nombre, String email, String direccion, String telefono, String clave, String datosRetorno[]) throws Exception {
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		
		valoresPOST.addElement( new HttpPostValues("nombre", nombre) );
		valoresPOST.addElement( new HttpPostValues("email", email) );
		valoresPOST.addElement( new HttpPostValues("direccion", direccion) );
		valoresPOST.addElement( new HttpPostValues("movil", telefono) );
		valoresPOST.addElement( new HttpPostValues("clave", clave) );
				
		String resultado = new Http().enviarPost( Http.URL_WEB_SERVICE+"registrar-usuario.php", valoresPOST);
		
		JSONObject objResultado = new JSONObject(resultado);
		
		String estadox = objResultado.get("estado").toString();
		String mensajex = objResultado.get("mensaje").toString();
		datosRetorno[0] = mensajex;
		
		if ( ! estadox.equalsIgnoreCase("exito")){
			return false;
		}
		return true;
	}
}
