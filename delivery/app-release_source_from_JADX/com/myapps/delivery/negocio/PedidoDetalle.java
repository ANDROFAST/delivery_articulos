package com.myapps.delivery.negocio;

import com.myapps.delivery.SeleccionarArticulo;
import com.myapps.delivery.SeleccionarEmpresa;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.util.HttpPostValues;
import java.util.ArrayList;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class PedidoDetalle {
    public static ArrayList<PedidoDetalle> listaPedido = new ArrayList();
    public static PedidoDetalle pedido = new PedidoDetalle();
    private Articulo articulo;
    private String cantidad;
    private Empresa empresa;
    private String subTotal;

    public PedidoDetalle(Empresa empresa, Articulo articulo, String cantidad, String subTotal) {
        this.empresa = empresa;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Articulo getArticulo() {
        return this.articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public boolean registrarTemporal() throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_empresa", String.valueOf(getEmpresa().getCodigo())));
        valoresPOST.addElement(new HttpPostValues("cod_usuario", Sesion.codUsuario));
        valoresPOST.addElement(new HttpPostValues("cod_articulo", String.valueOf(getArticulo().getCodigo())));
        valoresPOST.addElement(new HttpPostValues("cantidad", String.valueOf(getCantidad())));
        if (new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/registrar-pedido-temporal.php", valoresPOST)).get("estado").toString().equals("exito")) {
            return true;
        }
        return false;
    }

    public boolean existe() throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_empresa", String.valueOf(getEmpresa().getCodigo())));
        valoresPOST.addElement(new HttpPostValues("cod_usuario", Sesion.codUsuario));
        valoresPOST.addElement(new HttpPostValues("cod_articulo", String.valueOf(getArticulo().getCodigo())));
        if (new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/existe-pedido-detalle.php", valoresPOST)).getInt("cantidad") == 0) {
            return false;
        }
        return true;
    }

    public void listar() throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("codigo_usuario", Sesion.codUsuario));
        JSONArray jsonArray = new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/listar-pedido-detalle.php", valoresPOST)).getJSONArray("pedido_detalle");
        listaPedido.clear();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonData = jsonArray.getJSONObject(i);
            Empresa E = new Empresa();
            E.setCodigo(jsonData.getInt("cod_empresa"));
            E.setNombre(jsonData.getString(SeleccionarEmpresa.TAG));
            Articulo A = new Articulo();
            A.setCodigo(jsonData.getInt("cod_articulo"));
            A.setNombre(jsonData.getString(SeleccionarArticulo.TAG));
            A.setPrecio(jsonData.getString("precio"));
            listaPedido.add(new PedidoDetalle(E, A, jsonData.getString("cantidad"), jsonData.getString("subtotal")));
        }
    }

    public boolean quitar() throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_empresa", String.valueOf(getEmpresa().getCodigo())));
        valoresPOST.addElement(new HttpPostValues("cod_usuario", Sesion.codUsuario));
        valoresPOST.addElement(new HttpPostValues("cod_articulo", String.valueOf(getArticulo().getCodigo())));
        if (new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/quitar-pedido-temporal.php", valoresPOST)).get("estado").toString().equals("exito")) {
            return true;
        }
        return false;
    }

    public boolean actualizar(String cantidad) throws Exception {
        String resultado = "";
        Vector<HttpPostValues> valoresPOST = new Vector();
        valoresPOST.addElement(new HttpPostValues("cod_empresa", String.valueOf(getEmpresa().getCodigo())));
        valoresPOST.addElement(new HttpPostValues("cod_usuario", Sesion.codUsuario));
        valoresPOST.addElement(new HttpPostValues("cod_articulo", String.valueOf(getArticulo().getCodigo())));
        valoresPOST.addElement(new HttpPostValues("cantidad", cantidad));
        if (new JSONObject(new Http().enviarPost("http://negocioe.netau.net/web-service/actualizar-pedido-temporal.php", valoresPOST)).get("estado").toString().equals("exito")) {
            return true;
        }
        return false;
    }
}
