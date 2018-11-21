package com.myapps.delivery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PagarConTarjeta extends ActionBarActivity implements OnClickListener {
    Button btnPTContinuar;
    Button btnVolverCarrito;
    Spinner cboTipoDoc;
    ProgressDialog pd;
    Double total_pedido;
    EditText txtPTCodSeguridad;
    EditText txtPTDocumento;
    EditText txtPTFecha;
    EditText txtPTNombre;
    EditText txtPTNumeroTarjeta;

    class MiTarea extends AsyncTask<String, String, String> {
        MiTarea() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            PagarConTarjeta.this.pd = new ProgressDialog(PagarConTarjeta.this);
            PagarConTarjeta.this.pd.setTitle("Espere por favor");
            PagarConTarjeta.this.pd.setMessage("Validando Pago...");
            PagarConTarjeta.this.pd.setIndeterminate(false);
            PagarConTarjeta.this.pd.setCancelable(true);
            PagarConTarjeta.this.pd.show();
        }

        protected String doInBackground(String... params) {
            PagarConTarjeta.this.continuar();
            return null;
        }

        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            PagarConTarjeta.this.pd.dismiss();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0477R.layout.activity_pagar_con_tarjeta);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.txtPTNumeroTarjeta = (EditText) findViewById(C0477R.id.txtPTNumeroTarjeta);
        this.txtPTCodSeguridad = (EditText) findViewById(C0477R.id.txtPTCodSeguridad);
        this.txtPTFecha = (EditText) findViewById(C0477R.id.txtPTFecha);
        this.txtPTNombre = (EditText) findViewById(C0477R.id.txtPTNombre);
        this.txtPTDocumento = (EditText) findViewById(C0477R.id.txtPTDocumento);
        this.cboTipoDoc = (Spinner) findViewById(C0477R.id.cboTipoDoc);
        this.btnPTContinuar = (Button) findViewById(C0477R.id.btnPTContinuar);
        this.btnPTContinuar.setOnClickListener(this);
        this.btnVolverCarrito = (Button) findViewById(C0477R.id.btnVolverCarrito);
        this.btnVolverCarrito.setOnClickListener(this);
        Spinner spinner_tipo_documento = (Spinner) findViewById(C0477R.id.cboTipoDoc);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource(this, C0477R.array.tipo_documento, 17367048);
        spinner_adapter.setDropDownViewResource(17367049);
        spinner_tipo_documento.setAdapter(spinner_adapter);
        this.total_pedido = Double.valueOf(getIntent().getExtras().getDouble("total_pedido"));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0477R.id.btnVolverCarrito:
                finish();
                return;
            case C0477R.id.btnPTContinuar:
                Bundle parametros3 = new Bundle();
                parametros3.putDouble("total_p", this.total_pedido.doubleValue());
                Intent pantallaPagoAceptado = new Intent(this, PagarConTarjetaAceptado.class);
                pantallaPagoAceptado.putExtras(parametros3);
                startActivity(pantallaPagoAceptado);
                finish();
                return;
            default:
                return;
        }
    }

    public void continuar() {
        Bundle parametros3 = new Bundle();
        parametros3.putDouble("total_p", this.total_pedido.doubleValue());
        Intent pantallaPagoAceptado = new Intent(this, PagarConTarjetaAceptado.class);
        pantallaPagoAceptado.putExtras(parametros3);
        startActivity(pantallaPagoAceptado);
    }
}
