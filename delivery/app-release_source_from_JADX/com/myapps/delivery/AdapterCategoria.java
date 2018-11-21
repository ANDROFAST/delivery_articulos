package com.myapps.delivery;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.myapps.delivery.datos.Http;
import com.myapps.delivery.negocio.Categoria;
import com.myapps.delivery.util.ImageLoader;

public class AdapterCategoria extends ArrayAdapter<Categoria> {
    Activity contexto;

    public AdapterCategoria(Activity context) {
        super(context, C0477R.layout.categoria_item, Categoria.listaCategoria);
        this.contexto = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        item = this.contexto.getLayoutInflater().inflate(C0477R.layout.categoria_item, null);
        Categoria objCategoria = (Categoria) Categoria.listaCategoria.get(position);
        TextView etiquetaCategoria = (TextView) item.findViewById(C0477R.id.lblItemCategoriaNombre);
        new ImageLoader(this.contexto).DisplayImage(Http.URL_IMAGENES + objCategoria.getUrl(), (ImageView) item.findViewById(C0477R.id.imgItemCategoriaImagen));
        etiquetaCategoria.setText(objCategoria.getNombre());
        return item;
    }
}
