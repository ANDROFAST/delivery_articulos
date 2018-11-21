package com.myapps.delivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.myapps.delivery.negocio.Sesion;

public class Logueo extends Activity implements OnClickListener {
    Button botonIniciarSesion;
    TextView registroCliente;
    EditText textoClave;
    EditText textoEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0477R.layout.activity_logueo);
        this.textoEmail = (EditText) findViewById(C0477R.id.txtEmail);
        this.textoClave = (EditText) findViewById(C0477R.id.txtClave);
        this.botonIniciarSesion = (Button) findViewById(C0477R.id.btnIniciarSesiom);
        this.botonIniciarSesion.setOnClickListener(this);
        this.registroCliente = (TextView) findViewById(C0477R.id.txtNuevoUsuario);
        SpannableString content = new SpannableString(this.registroCliente.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        this.registroCliente.setText(content);
        this.registroCliente.setTextColor(-16776961);
        this.registroCliente.setOnClickListener(this);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0477R.id.btnIniciarSesiom:
                String[] datosRetorno = new String[3];
                try {
                    if (new Sesion().iniciarSesion(this.textoEmail.getText().toString(), this.textoClave.getText().toString(), datosRetorno)) {
                        Bundle parametros = new Bundle();
                        parametros.putString("par_mensaje", datosRetorno[0]);
                        parametros.putString("par_nombre", datosRetorno[1]);
                        parametros.putString("par_email", datosRetorno[2]);
                        limpiarLogueo();
                        Intent pantallaMenu = new Intent(this, MainActivity.class);
                        pantallaMenu.putExtras(parametros);
                        startActivity(pantallaMenu);
                        return;
                    }
                    Toast.makeText(this, datosRetorno[0], 1).show();
                    return;
                } catch (Exception e) {
                    Toast.makeText(this, e.getMessage(), 1).show();
                    return;
                }
            case C0477R.id.txtNuevoUsuario:
                startActivity(new Intent(this, RegistrarUsuario.class));
                return;
            default:
                return;
        }
    }

    public void limpiarLogueo() {
        this.textoClave.setText("");
        this.textoEmail.setText("");
        this.textoEmail.requestFocus();
    }
}
