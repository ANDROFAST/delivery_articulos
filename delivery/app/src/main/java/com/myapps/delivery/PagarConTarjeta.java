package com.myapps.delivery;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.myapps.delivery.negocio.PedidoDetalle;
import com.myapps.delivery.negocio.Sesion;

/**
 * Created by AMD on 15/11/2015.
 */
public class PagarConTarjeta extends ActionBarActivity implements View.OnClickListener {
    EditText txtPTNumeroTarjeta;
    EditText txtPTCodSeguridad;
    EditText txtPTFecha;
    EditText txtPTNombre;
    Spinner cboTipoDoc;
    EditText txtPTDocumento;
    Button btnPTContinuar;
    Button btnVolverCarrito;

    ProgressDialog pd;
    Double total_pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar_con_tarjeta);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        txtPTNumeroTarjeta = (EditText)findViewById(R.id.txtPTNumeroTarjeta);
        txtPTCodSeguridad = (EditText)findViewById(R.id.txtPTCodSeguridad);
        txtPTFecha = (EditText)findViewById(R.id.txtPTFecha);
        txtPTNombre = (EditText)findViewById(R.id.txtPTNombre);
        txtPTDocumento = (EditText)findViewById(R.id.txtPTDocumento);

        cboTipoDoc = (Spinner)findViewById(R.id.cboTipoDoc);

        btnPTContinuar = (Button)findViewById(R.id.btnPTContinuar);
        btnPTContinuar.setOnClickListener(this);

        btnVolverCarrito = (Button)findViewById(R.id.btnVolverCarrito);
        btnVolverCarrito.setOnClickListener(this);

        //Llenar Spinner
        Spinner spinner_tipo_documento = (Spinner) findViewById(R.id.cboTipoDoc);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.tipo_documento , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tipo_documento.setAdapter(spinner_adapter);


        Bundle parametros2 = this.getIntent().getExtras();
        total_pedido = parametros2.getDouble("total_pedido");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPTContinuar:
                //new MiTarea().execute();

                Bundle parametros3 = new Bundle();
                parametros3.putDouble("total_p", total_pedido);

                Intent pantallaPagoAceptado= new Intent(this, PagarConTarjetaAceptado.class);
                pantallaPagoAceptado.putExtras(parametros3);
                this.startActivity(pantallaPagoAceptado);

                finish();
                break;
            case R.id.btnVolverCarrito:
                this.finish();
                break;
            default:
                break;
        }
    }



    class MiTarea extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pd = new ProgressDialog(PagarConTarjeta.this);
            pd.setTitle("Espere por favor");
            pd.setMessage("Validando Pago...");
            pd.setIndeterminate(false);

            pd.setCancelable(true);
            /*
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            pd.show();

        }

        @Override
        protected String doInBackground(String... params) {
            //Lo que sigue

            continuar();

            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
        }
    }
    public void continuar(){
        Bundle parametros3 = new Bundle();
        parametros3.putDouble("total_p", total_pedido);

        Intent pantallaPagoAceptado= new Intent(this, PagarConTarjetaAceptado.class);
        pantallaPagoAceptado.putExtras(parametros3);
        this.startActivity(pantallaPagoAceptado);
    }
}
