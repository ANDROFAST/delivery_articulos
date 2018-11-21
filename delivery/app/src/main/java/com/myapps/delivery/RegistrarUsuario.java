package com.myapps.delivery;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapps.delivery.negocio.Usuario;

public class RegistrarUsuario extends Activity implements View.OnClickListener {

	EditText textoNombre;
	EditText textoEmail;
	EditText textoDireccion;
	EditText textoTelefono;
	EditText textoClave;
	
	Button botonRegistrar;
    Button btnCancelarRegistro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.activity_registrar_usuario);
		
		textoNombre = (EditText)findViewById(R.id.txtRegUsuPedNombre);
		textoEmail = (EditText)findViewById(R.id.txtRegUsuEmail);
		textoDireccion = (EditText)findViewById(R.id.txtRegUsuDireccion);
		textoTelefono = (EditText)findViewById(R.id.txtRegUsuCantPed);
		textoClave = (EditText)findViewById(R.id.txtRegUsuClave);
		botonRegistrar = (Button)findViewById(R.id.btnRegistrarUsuario);
		botonRegistrar.setOnClickListener(this);
        btnCancelarRegistro = (Button)findViewById(R.id.btnCancelarRegistro);
        btnCancelarRegistro.setOnClickListener(this);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
	}

	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.registrar_usuario, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		switch (id){
			case R.id.action_settings1:
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/
	@Override
	public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegistrarUsuario:
                String datosRetorno[] = new String[1];
                try {
                    String nombre = textoNombre.getText().toString();
                    String email = textoEmail.getText().toString();
                    String direccion = textoDireccion.getText().toString();
                    String telefono = textoTelefono.getText().toString();
                    String clave = textoClave.getText().toString();

					if(nombre.length()==0 || email.length()==0 || direccion.length()==0 || telefono.length()==0 || clave.length()==0){
						Toast.makeText(this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
						limpiarRegistroUsuario();
						textoNombre.requestFocus();
					}
					else{
						Usuario objCliente = new Usuario();
						if (objCliente.agregar(nombre, email, direccion, telefono, clave, datosRetorno) == true){
							Toast.makeText(this, datosRetorno[0], Toast.LENGTH_SHORT).show();
							limpiarRegistroUsuario();
							finish();

						}else{
							Toast.makeText(this, datosRetorno[0], Toast.LENGTH_LONG).show();
						}
					}

                } catch (Exception e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnCancelarRegistro:
                finish();
                break;
			default:
				break;
        }



	}

	public void limpiarRegistroUsuario(){
		textoNombre.setText("");
		textoEmail.setText("");
		textoDireccion.setText("");
		textoTelefono.setText("");
		textoClave.setText("");
	}
		
	
}
