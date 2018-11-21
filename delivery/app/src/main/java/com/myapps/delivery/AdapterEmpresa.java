package com.myapps.delivery;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapps.delivery.negocio.Empresa;

public class AdapterEmpresa extends ArrayAdapter<Empresa> {

	Activity contexto;
	
	public AdapterEmpresa(Activity context) {
		super(context, R.layout.empresa_item, Empresa.listaEmpresa);
		this.contexto = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = convertView;
		item = this.contexto.getLayoutInflater().inflate(R.layout.empresa_item, null);
		
		Empresa obj = Empresa.listaEmpresa.get(position);
		
		ImageView imagenArticulo = (ImageView)item.findViewById(R.id.imgItemEmpresaImagen);
		TextView etiquetaNombre = (TextView) item.findViewById(R.id.lblItemEmpresaNombre);
		TextView etiquetaDescripcion = (TextView) item.findViewById(R.id.lblItemEmpresaDescripcion);
		TextView etiquetaCategoria = (TextView) item.findViewById(R.id.lblItemEmpresaCategoria);
		
		imagenArticulo.setImageDrawable(this.contexto.getResources().getDrawable(obj.getImagen()));
		etiquetaNombre.setText( obj.getNombre() );
		etiquetaCategoria.setText( obj.getCategoria() );
		etiquetaDescripcion.setText( obj.getDescripcion() );			
		
		return (item);
	}
		
}

