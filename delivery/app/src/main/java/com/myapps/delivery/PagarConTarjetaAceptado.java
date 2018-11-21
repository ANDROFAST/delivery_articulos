package com.myapps.delivery;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.myapps.delivery.negocio.PedidoDetalle;
import com.myapps.delivery.util.F;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by AMD on 15/11/2015.
 */
public class PagarConTarjetaAceptado extends ActionBarActivity implements View.OnClickListener {
    TextView txtop1, txtop2, txtop3, lblPTATotal, txtFecha;
    Button btnPTAContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar_con_tarjeta_aceptado);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        lblPTATotal=(TextView)findViewById(R.id.lblPTATotal);

        txtop1=(TextView)findViewById(R.id.txtop1);
        txtop2=(TextView)findViewById(R.id.txtop2);
        txtop3=(TextView)findViewById(R.id.txtop3);
        txtFecha=(TextView)findViewById(R.id.lblPTAFechaSistema);
        btnPTAContinuar=(Button)findViewById(R.id.btnPTAContinuar);
        btnPTAContinuar.setOnClickListener(this);


       // Random r = new Random();
        //int i1 = r.nextInt(450 - 125) + 125;
        //int i2 = r.nextInt(550 - 101) + 101;
        //int i3 = r.nextInt(680 - 180) + 180;

        //txtop1.setText(i1);
        //txtop2.setText(i2);
       // txtop3.setText(i3);
        /*
        try {
            new PedidoDetalle().listar();
        }catch (Exception e){
            Toast.makeText(this,"Error no cargo ni mierda xD!", Toast.LENGTH_LONG).show();
        }
        */

        //Toast.makeText(this,PedidoDetalle.listaPedido.size(), Toast.LENGTH_LONG).show();

        Calendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formatoFecha = df.format(date);

        Date dt = new Date();
        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        String formatoHora = df2.format(dt.getTime());

        txtFecha.setText(formatoFecha+" - "+formatoHora);

        Bundle parametros4 = this.getIntent().getExtras();
        Double total_ped = parametros4.getDouble("total_p");
        Double aux=0.0;
        aux=Math.rint(total_ped*100)/100;
        lblPTATotal.setText(String.valueOf(aux));
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnPTAContinuar:
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
