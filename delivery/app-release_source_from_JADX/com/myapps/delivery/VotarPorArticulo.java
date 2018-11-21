package com.myapps.delivery;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.myapps.delivery.negocio.Sesion;
import com.myapps.delivery.negocio.Votacion;

public class VotarPorArticulo extends Activity implements OnClickListener {
    Button btnDeVotarAArticulo;
    Button btnMasCinco;
    Button btnMasCuatro;
    Button btnMasDos;
    Button btnMasTres;
    Button btnMasUno;
    int codigo_articulo;
    TextView lblVANombreArticulo;

    class C04911 implements DialogInterface.OnClickListener {
        C04911() {
        }

        public void onClick(DialogInterface dialog, int which) {
            VotarPorArticulo.this.finish();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0477R.layout.activity_votar_por_articulo);
        this.lblVANombreArticulo = (TextView) findViewById(C0477R.id.lblVANombreArticulo);
        this.btnDeVotarAArticulo = (Button) findViewById(C0477R.id.btnDeVotarAArticulo);
        this.btnDeVotarAArticulo.setOnClickListener(this);
        this.btnMasUno = (Button) findViewById(C0477R.id.btnMasUno);
        this.btnMasUno.setOnClickListener(this);
        this.btnMasDos = (Button) findViewById(C0477R.id.btnMasDos);
        this.btnMasDos.setOnClickListener(this);
        this.btnMasTres = (Button) findViewById(C0477R.id.btnMasTres);
        this.btnMasTres.setOnClickListener(this);
        this.btnMasCuatro = (Button) findViewById(C0477R.id.btnMasCuatro);
        this.btnMasCuatro.setOnClickListener(this);
        this.btnMasCinco = (Button) findViewById(C0477R.id.btnMasCinco);
        this.btnMasCinco.setOnClickListener(this);
        Bundle parametros = getIntent().getExtras();
        this.codigo_articulo = parametros.getInt("cod_arti");
        this.lblVANombreArticulo.setText(parametros.getString("nombre_arti"));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0477R.id.btnDeVotarAArticulo:
                finish();
                return;
            case C0477R.id.btnMasUno:
                registrarVotacion("1");
                return;
            case C0477R.id.btnMasDos:
                registrarVotacion("2");
                return;
            case C0477R.id.btnMasTres:
                registrarVotacion("3");
                return;
            case C0477R.id.btnMasCuatro:
                registrarVotacion("4");
                return;
            case C0477R.id.btnMasCinco:
                registrarVotacion("5");
                return;
            default:
                return;
        }
    }

    public void registrarVotacion(String estrella) {
        try {
            if (new Votacion().agregarVotacion(String.valueOf(this.codigo_articulo), Sesion.codUsuario, estrella.toString())) {
                votoHecho();
            } else {
                Toast.makeText(this, "Error de Registro", 1).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 1).show();
        }
    }

    public void votoHecho() {
        Builder dialogoAceptar = new Builder(this);
        dialogoAceptar.setTitle("Hecho!");
        dialogoAceptar.setMessage("Tu voto ha sido registrado");
        dialogoAceptar.setCancelable(false);
        dialogoAceptar.setPositiveButton("Aceptar", new C04911());
        dialogoAceptar.show();
    }
}
