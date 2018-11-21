package com.myapps.delivery;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.myapps.delivery.negocio.Sesion;

public class PagarDomicilio extends ActionBarActivity implements OnClickListener {
    Button btnPDDDContinuar;
    TextView lblNombreUsuarioPD;
    TextView lblPTDTotal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0477R.layout.activity_pagar_domicilio);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.lblPTDTotal = (TextView) findViewById(C0477R.id.txtTotalPagoADomicilio);
        this.btnPDDDContinuar = (Button) findViewById(C0477R.id.btnPDDDContinuar);
        this.btnPDDDContinuar.setOnClickListener(this);
        this.lblNombreUsuarioPD = (TextView) findViewById(C0477R.id.txtNombreUsuarioPagoDomicilio);
        this.lblNombreUsuarioPD.setText(Sesion.nombreUsuario);
        Double total_ped = Double.valueOf(getIntent().getExtras().getDouble("total_pedido"));
        Double aux = Double.valueOf(0.0d);
        this.lblPTDTotal.setText(String.valueOf(Double.valueOf(Math.rint(total_ped.doubleValue() * 100.0d) / 100.0d)));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0477R.id.btnPDDDContinuar:
                finish();
                return;
            default:
                return;
        }
    }
}
