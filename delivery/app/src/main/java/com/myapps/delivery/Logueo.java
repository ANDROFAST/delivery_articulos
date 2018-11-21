package com.myapps.delivery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myapps.delivery.negocio.Sesion;

/**
 * Created by AMD on 15/11/2015.
 */
public class Logueo extends Activity implements View.OnClickListener {
    EditText textoEmail;
    EditText textoClave;

    TextView registroCliente;

    Button botonIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);

        textoEmail = (EditText)findViewById(R.id.txtEmail);
        textoClave = (EditText)findViewById(R.id.txtClave);

        botonIniciarSesion = (Button)findViewById(R.id.btnIniciarSesiom);
        botonIniciarSesion.setOnClickListener(this);

        registroCliente = (TextView)findViewById(R.id.txtNuevoUsuario);
        SpannableString content = new SpannableString(registroCliente.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        registroCliente.setText(content);
        registroCliente.setTextColor(Color.BLUE);
        registroCliente.setOnClickListener(this);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIniciarSesiom:
                String datosRetorno[] = new String[3];

                try {
                    Sesion objSesion = new Sesion();
                    String email = textoEmail.getText().toString();
                    String clave = textoClave.getText().toString();

                    boolean r = objSesion.iniciarSesion(email, clave, datosRetorno);

                    if (r){ //Ingreso
                        Bundle parametros = new Bundle();
                        parametros.putString("par_mensaje", datosRetorno[0]);
                        parametros.putString("par_nombre", datosRetorno[1]);
                        parametros.putString("par_email", datosRetorno[2]);


                        limpiarLogueo();
                        Intent pantallaMenu = new Intent(this, MainActivity.class);
                        pantallaMenu.putExtras(parametros);
                        this.startActivity(pantallaMenu);

                    }else{
                        Toast.makeText(this, datosRetorno[0], Toast.LENGTH_LONG).show();
                    }


                } catch (Exception e) {
                    Toast.makeText(this, e.getMessage() , Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.txtNuevoUsuario:
                Intent pantallaRegUsu = new Intent(this, RegistrarUsuario.class);
                this.startActivity(pantallaRegUsu);

                //Intent pantallaRegUsu = new Intent(this, EstadisticasArticulo.class);
                //this.startActivity(pantallaRegUsu);
                break;
            default:
                break;
        }
    }

    public void limpiarLogueo(){
        textoClave.setText("");
        textoEmail.setText("");
        textoEmail.requestFocus();
    }

}
