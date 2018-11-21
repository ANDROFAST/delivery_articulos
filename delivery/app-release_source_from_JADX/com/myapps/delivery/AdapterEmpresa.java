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
        super(context, C0477R.layout.empresa_item, Empresa.listaEmpresa);
        this.contexto = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        item = this.contexto.getLayoutInflater().inflate(C0477R.layout.empresa_item, null);
        Empresa obj = (Empresa) Empresa.listaEmpresa.get(position);
        ImageView imagenArticulo = (ImageView) item.findViewById(C0477R.id.imgItemEmpresaImagen);
        TextView etiquetaNombre = (TextView) item.findViewById(C0477R.id.lblItemEmpresaNombre);
        TextView etiquetaDescripcion = (TextView) item.findViewById(C0477R.id.lblItemEmpresaDescripcion);
        TextView etiquetaCategoria = (TextView) item.findViewById(C0477R.id.lblItemEmpresaCategoria);
        int id_p = obj.getCodigo();
        imagenArticulo.setImageResource(getContext().getResources().getIdentifier("e_" + id_p, "drawable", getContext().getPackageName()));
        etiquetaNombre.setText(obj.getNombre());
        etiquetaCategoria.setText(obj.getCategoria());
        etiquetaDescripcion.setText(obj.getDescripcion());
        return item;
    }
}
