package com.myapps.delivery;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapps.delivery.negocio.PedidoDetalle;


public class AdapterPedidoDetalle extends ArrayAdapter<PedidoDetalle> {

	Activity contexto;
	
	public AdapterPedidoDetalle(Activity context) {
		super(context, R.layout.pedido_detalle_item, PedidoDetalle.listaPedido);
		this.contexto = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = convertView;
		item = this.contexto.getLayoutInflater().inflate(R.layout.pedido_detalle_item, null);		
		PedidoDetalle objPedidoDetalle = PedidoDetalle.listaPedido.get(position);
		
		ImageView imagenPedidoDetalle = (ImageView)item.findViewById(R.id.imgItemPD);
		TextView etiquetaPedidoDetalle = (TextView) item.findViewById(R.id.lblItemPDNombre);
		TextView precioPedidoDetalle = (TextView) item.findViewById(R.id.lblItemPDPrecio);
		TextView empresaPedidoDetalle = (TextView) item.findViewById(R.id.lblItemPDEmpresa);
		TextView subtotalPedidoDetalle = (TextView) item.findViewById(R.id.lblItemPDSubTotal);
		TextView cantidadPedidoDetalle = (TextView) item.findViewById(R.id.lblItemPDCantidad);
				
		imagenPedidoDetalle.setImageDrawable(this.contexto.getResources().getDrawable(R.drawable.producto));
		etiquetaPedidoDetalle.setText( objPedidoDetalle.getArticulo().getNombre());
		precioPedidoDetalle.setText( String.valueOf(objPedidoDetalle.getArticulo().getPrecio()));
		empresaPedidoDetalle.setText(  objPedidoDetalle.getEmpresa().getNombre());
		cantidadPedidoDetalle.setText( String.valueOf(objPedidoDetalle.getCantidad()) );
		subtotalPedidoDetalle.setText( String.valueOf(objPedidoDetalle.getSubTotal()) );
				
		return (item);
	}
	
}
