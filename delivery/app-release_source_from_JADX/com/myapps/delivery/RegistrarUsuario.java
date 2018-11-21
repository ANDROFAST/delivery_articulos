package com.myapps.delivery;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.myapps.delivery.negocio.Usuario;

public class RegistrarUsuario extends Activity implements OnClickListener {
    Button botonRegistrar;
    Button btnCancelarRegistro;
    EditText textoClave;
    EditText textoDireccion;
    EditText textoEmail;
    EditText textoNombre;
    EditText textoTelefono;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0477R.layout.activity_registrar_usuario);
        this.textoNombre = (EditText) findViewById(C0477R.id.txtRegUsuPedNombre);
        this.textoEmail = (EditText) findViewById(C0477R.id.txtRegUsuEmail);
        this.textoDireccion = (EditText) findViewById(C0477R.id.txtRegUsuDireccion);
        this.textoTelefono = (EditText) findViewById(C0477R.id.txtRegUsuCantPed);
        this.textoClave = (EditText) findViewById(C0477R.id.txtRegUsuClave);
        this.botonRegistrar = (Button) findViewById(C0477R.id.btnRegistrarUsuario);
        this.botonRegistrar.setOnClickListener(this);
        this.btnCancelarRegistro = (Button) findViewById(C0477R.id.btnCancelarRegistro);
        this.btnCancelarRegistro.setOnClickListener(this);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0477R.id.btnRegistrarUsuario:
                String[] datosRetorno = new String[1];
                try {
                    String nombre = this.textoNombre.getText().toString();
                    String email = this.textoEmail.getText().toString();
                    String direccion = this.textoDireccion.getText().toString();
                    String telefono = this.textoTelefono.getText().toString();
                    String clave = this.textoClave.getText().toString();
                    if (nombre.length() == 0 || email.length() == 0 || direccion.length() == 0 || telefono.length() == 0 || clave.length() == 0) {
                        Toast.makeText(this, "Debe completar todos los campos", 0).show();
                        limpiarRegistroUsuario();
                        this.textoNombre.requestFocus();
                        return;
                    } else if (new Usuario().agregar(nombre, email, direccion, telefono, clave, datosRetorno)) {
                        Toast.makeText(this, datosRetorno[0], 0).show();
                        limpiarRegistroUsuario();
                        finish();
                        return;
                    } else {
                        Toast.makeText(this, datosRetorno[0], 1).show();
                        return;
                    }
                } catch (Exception e) {
                    Toast.makeText(this, e.getMessage(), 1).show();
                    return;
                }
            case C0477R.id.btnCancelarRegistro:
                finish();
                return;
            default:
                return;
        }
    }

    public void limpiarRegistroUsuario() {
        this.textoNombre.setText("");
        this.textoEmail.setText("");
        this.textoDireccion.setText("");
        this.textoTelefono.setText("");
        this.textoClave.setText("");
    }
}
