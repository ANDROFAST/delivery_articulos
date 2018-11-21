package com.myapps.delivery;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myapps.delivery.datos.Http;
import com.myapps.delivery.negocio.Sesion;
import com.myapps.delivery.negocio.Votacion;

import org.apache.http.util.EncodingUtils;

public class VotarPorArticulo extends Activity implements View.OnClickListener{
	TextView lblVANombreArticulo;
    Button btnDeVotarAArticulo, btnMasUno, btnMasDos, btnMasTres, btnMasCuatro, btnMasCinco;
    int codigo_articulo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_votar_por_articulo);

		lblVANombreArticulo=(TextView)findViewById(R.id.lblVANombreArticulo);
        btnDeVotarAArticulo=(Button)findViewById(R.id.btnDeVotarAArticulo);
        btnDeVotarAArticulo.setOnClickListener(this);
        btnMasUno=(Button)findViewById(R.id.btnMasUno);
        btnMasUno.setOnClickListener(this);
        btnMasDos=(Button)findViewById(R.id.btnMasDos);
        btnMasDos.setOnClickListener(this);
        btnMasTres=(Button)findViewById(R.id.btnMasTres);
        btnMasTres.setOnClickListener(this);
        btnMasCuatro=(Button)findViewById(R.id.btnMasCuatro);
        btnMasCuatro.setOnClickListener(this);
        btnMasCinco=(Button)findViewById(R.id.btnMasCinco);
        btnMasCinco.setOnClickListener(this);




        Bundle parametros = this.getIntent().getExtras();

        codigo_articulo = parametros.getInt("cod_arti");
        String nom_articulo= parametros.getString("nombre_arti");
        lblVANombreArticulo.setText(nom_articulo);
        //Toast.makeText(this, ""+codigo_articulo, Toast.LENGTH_LONG).show();


	}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDeVotarAArticulo:
                this.finish();
                break;
            case R.id.btnMasUno:
                registrarVotacion("1");
                break;
            case R.id.btnMasDos:
                registrarVotacion("2");
                break;
            case R.id.btnMasTres:
                registrarVotacion("3");
                break;
            case R.id.btnMasCuatro:
                registrarVotacion("4");
                break;
            case R.id.btnMasCinco:
                registrarVotacion("5");
                break;
            default:
                break;
        }
    }

    public void registrarVotacion(String estrella){
        //String datosRetorno[] = new String[1];

        try {
            //String cod_articulo=String.valueOf(codigo_articulo);
            String cod_usuario= Sesion.codUsuario;
            String estrellas =estrella.toString();


                Votacion objVotacion = new Votacion();
                if (objVotacion.agregarVotacion(String.valueOf(codigo_articulo), cod_usuario, estrellas)){
                    //Toast.makeText(this, "Tu voto ha sido registrado", Toast.LENGTH_LONG).show();
                    votoHecho();

                }else {
                    Toast.makeText(this, "Error de Registro", Toast.LENGTH_LONG).show();
                }

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    public void votoHecho() {
        final AlertDialog.Builder dialogoAceptar = new AlertDialog.Builder(this);
        dialogoAceptar.setTitle("Hecho!");
        dialogoAceptar.setMessage("Tu voto ha sido registrado");
        dialogoAceptar.setCancelable(false);

        dialogoAceptar.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialogoAceptar.show();
    }

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.registrar_usuario, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		switch (id){
			case R.id.action_settings1:
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/
		
	
}
