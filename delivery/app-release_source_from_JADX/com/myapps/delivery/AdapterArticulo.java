package com.myapps.delivery;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.myapps.delivery.negocio.Articulo;
import com.myapps.delivery.negocio.Votacion;

public class AdapterArticulo extends ArrayAdapter<Articulo> {
    Activity contexto;

    public AdapterArticulo(Activity context) {
        super(context, C0477R.layout.articulo_item, Articulo.listaArticulo);
        this.contexto = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        item = this.contexto.getLayoutInflater().inflate(C0477R.layout.articulo_item, null);
        Articulo objArticulo = (Articulo) Articulo.listaArticulo.get(position);
        ImageView imagenArticulo = (ImageView) item.findViewById(C0477R.id.imgItemArticuloImagen);
        TextView etiquetaArticulo = (TextView) item.findViewById(C0477R.id.lblItemArticuloNombre);
        TextView precioArticulo = (TextView) item.findViewById(C0477R.id.lblItemArticuloPrecio);
        TextView stockArticulo = (TextView) item.findViewById(C0477R.id.lblItemArticuloStock);
        imagenArticulo.setImageDrawable(this.contexto.getResources().getDrawable(objArticulo.getImagen()));
        String nombre = "a_" + objArticulo.getCodigo();
        imagenArticulo.setImageResource(getContext().getResources().getIdentifier(nombre, "drawable", getContext().getPackageName()));
        etiquetaArticulo.setText(objArticulo.getNombre());
        precioArticulo.setText(String.valueOf(objArticulo.getPrecio()));
        stockArticulo.setText(String.valueOf(objArticulo.getStock()));
        double prom = 0.0d;
        try {
            prom = new Votacion().obtenerPromedioVotosDeUnArticulo(String.valueOf(objArticulo.getCodigo()));
        } catch (Exception e) {
        }
        double aux = Math.rint(10.0d * prom) / 10.0d;
        ((TextView) item.findViewById(C0477R.id.promedioVotos)).setText(String.valueOf(aux));
        ImageView estrella1 = (ImageView) item.findViewById(C0477R.id.estrella1);
        ImageView estrella2 = (ImageView) item.findViewById(C0477R.id.estrella2);
        ImageView estrella3 = (ImageView) item.findViewById(C0477R.id.estrella3);
        ImageView estrella4 = (ImageView) item.findViewById(C0477R.id.estrella4);
        ImageView estrella5 = (ImageView) item.findViewById(C0477R.id.estrella5);
        if (aux > 0.0d && aux <= 1.4d) {
            estrella1.setVisibility(0);
            estrella2.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella2.setVisibility(0);
            estrella3.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella3.setVisibility(0);
            estrella4.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella4.setVisibility(0);
            estrella5.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella5.setVisibility(0);
        } else if (aux > 1.4d && aux <= 2.4d) {
            estrella1.setVisibility(0);
            estrella2.setVisibility(0);
            estrella3.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella3.setVisibility(0);
            estrella4.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella4.setVisibility(0);
            estrella5.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella5.setVisibility(0);
        } else if (aux > 2.4d && aux <= 3.4d) {
            estrella1.setVisibility(0);
            estrella2.setVisibility(0);
            estrella3.setVisibility(0);
            estrella4.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella4.setVisibility(0);
            estrella5.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella5.setVisibility(0);
        } else if (aux <= 3.4d || aux > 4.4d) {
            estrella1.setVisibility(0);
            estrella2.setVisibility(0);
            estrella3.setVisibility(0);
            estrella4.setVisibility(0);
            estrella5.setVisibility(0);
        } else {
            estrella1.setVisibility(0);
            estrella2.setVisibility(0);
            estrella3.setVisibility(0);
            estrella4.setVisibility(0);
            estrella5.setImageResource(C0477R.drawable.ic_estrella_vacia);
            estrella5.setVisibility(0);
        }
        return item;
    }
}
