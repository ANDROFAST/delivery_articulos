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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class PagarConTarjetaAceptado extends ActionBarActivity implements OnClickListener {
    Button btnPTAContinuar;
    TextView lblPTATotal;
    TextView txtFecha;
    TextView txtop1;
    TextView txtop2;
    TextView txtop3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0477R.layout.activity_pagar_con_tarjeta_aceptado);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.lblPTATotal = (TextView) findViewById(C0477R.id.lblPTATotal);
        this.txtop1 = (TextView) findViewById(C0477R.id.txtop1);
        this.txtop2 = (TextView) findViewById(C0477R.id.txtop2);
        this.txtop3 = (TextView) findViewById(C0477R.id.txtop3);
        this.txtFecha = (TextView) findViewById(C0477R.id.lblPTAFechaSistema);
        this.btnPTAContinuar = (Button) findViewById(C0477R.id.btnPTAContinuar);
        this.btnPTAContinuar.setOnClickListener(this);
        String formatoFecha = new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar().getTime());
        this.txtFecha.setText(formatoFecha + " - " + new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(new Date().getTime())));
        Double total_ped = Double.valueOf(getIntent().getExtras().getDouble("total_p"));
        Double aux = Double.valueOf(0.0d);
        this.lblPTATotal.setText(String.valueOf(Double.valueOf(Math.rint(total_ped.doubleValue() * 100.0d) / 100.0d)));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0477R.id.btnPTAContinuar:
                finish();
                return;
            default:
                return;
        }
    }
}
