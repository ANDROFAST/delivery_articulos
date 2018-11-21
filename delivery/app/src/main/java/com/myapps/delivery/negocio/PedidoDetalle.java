package com.myapps.delivery.negocio;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;


public class PedidoDetalle {


	private Empresa empresa;
	private Articulo articulo;
	private String cantidad;
	private String subTotal;
	public static ArrayList<PedidoDetalle> listaPedido = new ArrayList<PedidoDetalle>();
	public static PedidoDetalle pedido = new PedidoDetalle();
	
	public PedidoDetalle() {
		
	}
	
	public PedidoDetalle(Empresa empresa,Articulo articulo,String cantidad, String subTotal) {
		super();		
		this.empresa = empresa;
		this.articulo = articulo;
		this.cantidad = cantidad;		
		this.subTotal = subTotal;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public boolean registrarTemporal() throws Exception {
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("cod_empresa", String.valueOf(this.getEmpresa().getCodigo())));
		valoresPOST.addElement( new HttpPostValues("cod_usuario",Sesion.codUsuario));
		valoresPOST.addElement( new HttpPostValues("cod_articulo", String.valueOf(this.getArticulo().getCodigo())));
		valoresPOST.addElement( new HttpPostValues("cantidad", String.valueOf(this.getCantidad())));
		
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"registrar-pedido-temporal.php",valoresPOST);		
		
		JSONObject objResultado = new JSONObject(resultado);
		String estado = objResultado.get("estado").toString();
	
		if (!estado.equals("exito")){
			return false;
		}
		return true;
		
	}
	
	public boolean existe() throws Exception {
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("cod_empresa", String.valueOf(this.getEmpresa().getCodigo())));
		valoresPOST.addElement( new HttpPostValues("cod_usuario",Sesion.codUsuario));
		valoresPOST.addElement( new HttpPostValues("cod_articulo", String.valueOf(this.getArticulo().getCodigo())));
		
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"existe-pedido-detalle.php",valoresPOST);
		
		JSONObject objResultado = new JSONObject(resultado);
		int cantidad = objResultado.getInt("cantidad");
		
		if (cantidad==0){
			return false;
		}
		return true;
	}
		
	public void listar() throws Exception {
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("codigo_usuario",Sesion.codUsuario ));
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"listar-pedido-detalle.php",valoresPOST);
		
		JSONObject json = new JSONObject(resultado);
		JSONArray jsonArray = json.getJSONArray("pedido_detalle");
		
		PedidoDetalle.listaPedido.clear();
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			Empresa E = new Empresa();
			E.setCodigo(jsonData.getInt("cod_empresa"));
			E.setNombre(jsonData.getString("empresa"));
			Articulo A = new Articulo();
			A.setCodigo(jsonData.getInt("cod_articulo"));
			A.setNombre(jsonData.getString("articulo"));
			A.setPrecio(jsonData.getString("precio"));
			PedidoDetalle.listaPedido.add( new PedidoDetalle( 					
					E,A,jsonData.getString("cantidad"),jsonData.getString("subtotal")
					) 
			);
		}		
	}
	
	public boolean quitar() throws Exception {
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("cod_empresa", String.valueOf(this.getEmpresa().getCodigo())));
		valoresPOST.addElement( new HttpPostValues("cod_usuario",Sesion.codUsuario));
		valoresPOST.addElement( new HttpPostValues("cod_articulo", String.valueOf(this.getArticulo().getCodigo())));
		
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"quitar-pedido-temporal.php",valoresPOST);		
		
		JSONObject objResultado = new JSONObject(resultado);
		String estado = objResultado.get("estado").toString();
	
		if (!estado.equals("exito")){
			return false;
		}
		return true;
		
	}
	
	public boolean actualizar(String cantidad) throws Exception {
		String resultado = "";
		Vector<HttpPostValues> valoresPOST = new Vector<HttpPostValues>();
		valoresPOST.addElement( new HttpPostValues("cod_empresa", String.valueOf(this.getEmpresa().getCodigo())));
		valoresPOST.addElement( new HttpPostValues("cod_usuario",Sesion.codUsuario));
		valoresPOST.addElement( new HttpPostValues("cod_articulo", String.valueOf(this.getArticulo().getCodigo())));
		valoresPOST.addElement( new HttpPostValues("cantidad",cantidad));
		
		resultado = new Http().enviarPost(Http.URL_WEB_SERVICE+"actualizar-pedido-temporal.php",valoresPOST);		
		
		JSONObject objResultado = new JSONObject(resultado);
		String estado = objResultado.get("estado").toString();
	
		if (!estado.equals("exito")){
			return false;
		}
		return true;
		
	}
	
}
