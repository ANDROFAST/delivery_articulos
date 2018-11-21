package com.myapps.delivery;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myapps.delivery.negocio.Sesion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by AMD on 15/11/2015.
 */
public class PagarDomicilio extends ActionBarActivity implements View.OnClickListener {
    TextView lblPTDTotal, lblNombreUsuarioPD;
    Button btnPDDDContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar_domicilio);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        lblPTDTotal=(TextView)findViewById(R.id.txtTotalPagoADomicilio);
        btnPDDDContinuar=(Button)findViewById(R.id.btnPDDDContinuar);
        btnPDDDContinuar.setOnClickListener(this);
        lblNombreUsuarioPD=(TextView)findViewById(R.id.txtNombreUsuarioPagoDomicilio);
        lblNombreUsuarioPD.setText(Sesion.nombreUsuario);

        Bundle parametros4 = this.getIntent().getExtras();
        Double total_ped = parametros4.getDouble("total_pedido");
        Double aux=0.0;
        aux=Math.rint(total_ped*100)/100;
        lblPTDTotal.setText(String.valueOf(aux));


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnPDDDContinuar:
                //PedidoDetalle.listaPedido.clear();
                //Toast.makeText(this,PedidoDetalle.listaPedido.size(), Toast.LENGTH_LONG).show();
                //lvDetallePedido.setAdapter(null);
                //lblDireccion.setText(null);
                //F.msg(this, "Pedido realizado correctamente!");
                //recargarLista();
                this.finish();
                break;
            default:
                break;
        }
    }

}
