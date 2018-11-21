package com.myapps.delivery;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapps.delivery.negocio.Articulo;
import com.myapps.delivery.negocio.Votacion;
import com.myapps.delivery.util.F;

import org.json.JSONArray;
import org.w3c.dom.Text;


public class AdapterArticulo extends ArrayAdapter<Articulo> {

	Activity contexto;
	
	public AdapterArticulo(Activity context) {
		super(context, R.layout.articulo_item, Articulo.listaArticulo);
		this.contexto = context;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = convertView;
		item = this.contexto.getLayoutInflater().inflate(R.layout.articulo_item, null);		
		Articulo objArticulo = Articulo.listaArticulo.get(position);

		ImageView imagenArticulo = (ImageView)item.findViewById(R.id.imgItemArticuloImagen);
		TextView etiquetaArticulo = (TextView) item.findViewById(R.id.lblItemArticuloNombre);
		TextView precioArticulo = (TextView) item.findViewById(R.id.lblItemArticuloPrecio);
		TextView stockArticulo = (TextView) item.findViewById(R.id.lblItemArticuloStock);
				
		imagenArticulo.setImageDrawable(this.contexto.getResources().getDrawable(objArticulo.getImagen()));
		etiquetaArticulo.setText(objArticulo.getNombre());
		precioArticulo.setText( String.valueOf(objArticulo.getPrecio()));
		stockArticulo.setText(String.valueOf(objArticulo.getStock()));

        double prom=0, aux=0;
        try {
            Votacion objV=new Votacion();
            prom=objV.obtenerPromedioVotosDeUnArticulo(String.valueOf(objArticulo.getCodigo()));
        }catch(Exception e){

        }
		aux=Math.rint(prom*10)/10;

        TextView promedioVotos = (TextView)item.findViewById(R.id.promedioVotos);
		promedioVotos.setText(String.valueOf(aux));//Asignar el promedio de votaciones obtenido al TextView

        ImageView estrella1=(ImageView)item.findViewById(R.id.estrella1);
        ImageView estrella2=(ImageView)item.findViewById(R.id.estrella2);
        ImageView estrella3=(ImageView)item.findViewById(R.id.estrella3);
        ImageView estrella4=(ImageView)item.findViewById(R.id.estrella4);
        ImageView estrella5=(ImageView)item.findViewById(R.id.estrella5);

        if(aux>0 && aux<=1.4){//1 ESTRELLA
            estrella1.setVisibility(View.VISIBLE);

            estrella2.setImageResource(R.drawable.ic_estrella_vacia);
            estrella2.setVisibility(View.VISIBLE);
            estrella3.setImageResource(R.drawable.ic_estrella_vacia);
            estrella3.setVisibility(View.VISIBLE);
            estrella4.setImageResource(R.drawable.ic_estrella_vacia);
            estrella4.setVisibility(View.VISIBLE);
            estrella5.setImageResource(R.drawable.ic_estrella_vacia);
            estrella5.setVisibility(View.VISIBLE);
        }else{
            if(aux>1.4 && aux<=2.4){//2 ESTRELLA
                estrella1.setVisibility(View.VISIBLE);
                estrella2.setVisibility(View.VISIBLE);

                estrella3.setImageResource(R.drawable.ic_estrella_vacia);
                estrella3.setVisibility(View.VISIBLE);
                estrella4.setImageResource(R.drawable.ic_estrella_vacia);
                estrella4.setVisibility(View.VISIBLE);
                estrella5.setImageResource(R.drawable.ic_estrella_vacia);
                estrella5.setVisibility(View.VISIBLE);
            }else{
                if(aux>2.4 && aux<=3.4){//3 ESTRELLA
                    estrella1.setVisibility(View.VISIBLE);
                    estrella2.setVisibility(View.VISIBLE);
                    estrella3.setVisibility(View.VISIBLE);

                    estrella4.setImageResource(R.drawable.ic_estrella_vacia);
                    estrella4.setVisibility(View.VISIBLE);
                    estrella5.setImageResource(R.drawable.ic_estrella_vacia);
                    estrella5.setVisibility(View.VISIBLE);
                }else{
                    if(aux>3.4 && aux<=4.4){//4 ESTRELLA
                        estrella1.setVisibility(View.VISIBLE);
                        estrella2.setVisibility(View.VISIBLE);
                        estrella3.setVisibility(View.VISIBLE);
                        estrella4.setVisibility(View.VISIBLE);

                        estrella5.setImageResource(R.drawable.ic_estrella_vacia);
                        estrella5.setVisibility(View.VISIBLE);
                    }
                    else{//5 ESTRELLA
                        estrella1.setVisibility(View.VISIBLE);
                        estrella2.setVisibility(View.VISIBLE);
                        estrella3.setVisibility(View.VISIBLE);
                        estrella4.setVisibility(View.VISIBLE);
                        estrella5.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
				
		return (item);
	}
	
}
